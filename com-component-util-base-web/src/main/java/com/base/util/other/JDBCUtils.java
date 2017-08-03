package com.base.util.other;

import com.base.util.exception.CommonException;
import com.base.util.exception.InspectionServiceException;
import com.base.util.mybatis.TFinancialWorkingDaysMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by houjun on 2016-12-20.
 */
public class JDBCUtils {

    private static Logger logger = LoggerFactory.getLogger(JDBCUtils.class);

    public static Object[] decodeParams4PrepareSql(String paramsStr) {
        if (StringUtils.isBlank(paramsStr))
            return null;
        String[] arr = paramsStr.split(";");
        List<Object> params = new ArrayList();
        for (String str : arr) {
            params.add(parseParam(str));
        }
        return params.toArray();
    }


    private static Object parseParam(String str) {
        if (str == null)
            return null;
        if (str.indexOf(":") > 0) {
            String[] arr = str.split(":");
            if ("String".equals(arr[0]))
                return arr[1];
            else if ("Integer".equals(arr[0]))
                return Integer.valueOf(arr[1]);
            else if ("Long".equals(arr[0]))
                return Long.valueOf(arr[1]);
            else if ("Date".equals(arr[0]))
                return parseDate(arr[1]);
            else
                throw new CommonException("参数无法解析：" + str);

        }
        return str;
    }

    private static Date parseDate(String str) {
        if (str == null)
            return null;
        if (SpecifiedValue.now.name().equals(str))
            return new Date();
        else if (SpecifiedValue.today.name().equals(str)) {
            return DateUtils.truncate(new Date(), Calendar.DATE);
        } else if (SpecifiedValue.FWDB.name().equals(str)) {
            return AppCtxUtils.getBean(TFinancialWorkingDaysMapper.class).getFWDB(DateUtils.truncate(new Date(), Calendar.DATE));
        } else if (SpecifiedValue.FWDE.name().equals(str)) {
            return AppCtxUtils.getBean(TFinancialWorkingDaysMapper.class).getFWDE(DateUtils.truncate(new Date(), Calendar.DATE));
        } else if (SpecifiedValue.yesterday.name().equals(str)) {
            return DateUtils.addDays(DateUtils.truncate(new Date(), Calendar.DATE), -1);
        } else if (SpecifiedValue.tomorrow.name().equals(str)) {
            return DateUtils.addDays(DateUtils.truncate(new Date(), Calendar.DATE), 1);
        } else if (str.startsWith(SpecifiedValue.today.name())) {
            return toDate(DateFormatUtils.format(new Date(), "yyyyMMdd").concat(StringUtils.difference(SpecifiedValue.today.name(), str)));
        } else if (str.startsWith(SpecifiedValue.yesterday.name())) {
            return toDate(DateFormatUtils.format(DateUtils.addDays(new Date(), -1), "yyyyMMdd").concat(StringUtils.difference(SpecifiedValue.yesterday.name(), str)));
        } else if (str.startsWith(SpecifiedValue.tomorrow.name())) {
            return toDate(DateFormatUtils.format(DateUtils.addDays(new Date(), 1), "yyyyMMdd").concat(StringUtils.difference(SpecifiedValue.tomorrow.name(), str)));
        } else if (str.startsWith(SpecifiedValue.FWDB.name()) || str.startsWith(SpecifiedValue.FWDE.name())) {
            TFinancialWorkingDaysMapper fwdMapper = AppCtxUtils.getBean(TFinancialWorkingDaysMapper.class);
            Date basicDate = DateUtils.truncate(new Date(), Calendar.DATE);
            if (isNest(str)) {
                basicDate = parseDate(StringUtils.substring(str, str.indexOf("(") + 1, str.lastIndexOf(")")));
                str = StringUtils.substringBefore(str, "(");
            }

            if (str.startsWith(SpecifiedValue.FWDB.name()))
                return toDate(DateFormatUtils.format(fwdMapper.getFWDB(basicDate), "yyyyMMdd").concat(StringUtils.difference(SpecifiedValue.FWDB.name(), str)));
            else
                return toDate(DateFormatUtils.format(fwdMapper.getFWDE(basicDate), "yyyyMMdd").concat(StringUtils.difference(SpecifiedValue.FWDE.name(), str)));
        } else
            return toDate(str);
    }

    public static String parseDateToStr(String str) {

        Date date = parseDate(str);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = sdf.format(date);

        return dateStr;
    }

    private static boolean isNest(String formulaStr) {
        if (formulaStr == null)
            return false;
        if (formulaStr.contains("(") && formulaStr.contains(")")) {
            return true;
        }
        return false;
    }

    private static Date toDate(String dateStr) {
        try {
            return DateUtils.parseDate(dateStr, "yyyyMMddHHmmss");
        } catch (ParseException e) {
            logger.error("格式化日期错误:" + e.getMessage(), e);
            throw new CommonException("格式化日期错误:" + e.getMessage(), e);
        }
    }

    public static String decorateJDBCUrl(String JDBCUrl) {
        if (JDBCUrl == null)
            return null;
        String urlPart = StringUtils.substringBefore(JDBCUrl, "?");
        String paramsPart = StringUtils.substringAfter(JDBCUrl, "?");
        Map<String, String> paramsMap = new HashMap<>();
        if (StringUtils.isNotBlank(paramsPart)) {
            for (String param : paramsPart.split("&")) {
                if (StringUtils.isNotBlank(param)) {
                    String[] s = param.split("=");
                    paramsMap.put(s[0], s[1]);
                }
            }
        }

        if (paramsMap.get("useUnicode") == null)
            paramsMap.put("useUnicode", "true");
        if (paramsMap.get("characterEncoding") == null)
            paramsMap.put("characterEncoding", "UTF-8");
        if (paramsMap.get("allowMultiQueries") == null)
            paramsMap.put("allowMultiQueries", "true");
        if (paramsMap.get("zeroDateTimeBehavior") == null)
            paramsMap.put("zeroDateTimeBehavior", "convertToNull");
        if (paramsMap.get("transformedBitIsBoolean") == null)
            paramsMap.put("transformedBitIsBoolean", "true");
        urlPart = urlPart.concat("?");
        for (Map.Entry<String, String> entry : paramsMap.entrySet()) {
            urlPart = urlPart.concat(entry.getKey()).concat("=").concat(entry.getValue()).concat("&");
        }
        return StringUtils.removeEnd(urlPart, "&");
    }

    public static void closeConn(Connection conn) {
        try {
            if (conn != null)
                conn.close();
        } catch (SQLException e) {

        }
    }

    public static Connection getConnection(DataSourceDef dsDef) throws ClassNotFoundException, SQLException, InspectionServiceException {
        Args.notNull(dsDef, "dsDef");
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(JDBCUtils.decorateJDBCUrl(dsDef.getJdbcUrl()), dsDef.getDsUserName(), dsDef.getDsPassword());
        if (conn == null)
            throw new InspectionServiceException("意外的没有获取数据源{0}的链接，请检查.", dsDef.getDsName());
        return conn;
    }


    public static void main(String[] args) throws Exception {
//        String formulaStr = "FWDB150000(yesterday)";
//        System.out.println(StringUtils.substring(formulaStr, formulaStr.indexOf("(") + 1, formulaStr.lastIndexOf(")")));

        String str_1  = StringUtils.substringBefore("FWDE000000(tomorrow)", "(");
        System.out.println(str_1);
        System.out.println(StringUtils.difference(SpecifiedValue.FWDE.name(), str_1));
        System.out.println(parseDate("tomorrow"));
//        System.out.println(toDate("20170802"));
    }

    public static void excute(){
        System.out.println(parseDate("FWDE(tomorrow)"));
    }
}
