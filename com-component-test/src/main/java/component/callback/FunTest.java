package component.callback;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.util.*;

/**
 * Created by wangjianjun on 2017/8/4.
 */
public class FunTest {

    public static void main(String[] args) {
//        System.out.println(parseDate("FWDE150000(yesterday)"));
//        System.out.println(parseDate("FWDE150000(FWDE150000(20170804000000))"));
        Stack stack = operSrcStr("FWDE150000(FWDE150000(FWDE150000(FWDE160000(20170804000000))))");
        System.out.println(stack.size());

//        System.out.println("123".concat("456"));

    }

    private static Date parseDate(String str) {
        if (str == null)
            return null;
        if ("now".equals(str))
            return new Date();
        else if ("today".equals(str)) {
            return DateUtils.truncate(new Date(), Calendar.DATE);
        } else if ("FWDB".equals(str)) {
            return DateUtils.addDays(DateUtils.truncate(new Date(), Calendar.DATE), -1);
        } else if ("FWDE".equals(str)) {
            return DateUtils.addDays(DateUtils.truncate(new Date(), Calendar.DATE), 1);
        } else if ("yesterday".equals(str)) {
            return DateUtils.addDays(DateUtils.truncate(new Date(), Calendar.DATE), -1);
        } else if ("tomorrow".equals(str)) {
            return DateUtils.addDays(DateUtils.truncate(new Date(), Calendar.DATE), 1);
        } else if (str.startsWith("today")) {
            return toDate(DateFormatUtils.format(new Date(), "yyyyMMdd").concat(StringUtils.difference("today", str)));
        } else if (str.startsWith("yesterday")) {
            return toDate(DateFormatUtils.format(DateUtils.addDays(new Date(), -1), "yyyyMMdd").concat(StringUtils.difference("yesterday", str)));
        } else if (str.startsWith("tomorrow")) {
            return toDate(DateFormatUtils.format(DateUtils.addDays(new Date(), 1), "yyyyMMdd").concat(StringUtils.difference("tomorrow", str)));
        } else if (str.startsWith("FWDB") || str.startsWith("FWDE")) {
            Date basicDate = DateUtils.truncate(new Date(), Calendar.DATE);

            if (isNest(str)) {
                basicDate = parseDate(StringUtils.substring(str, str.indexOf("(") + 1, str.lastIndexOf(")")));
                str = StringUtils.substringBefore(str, "(");
            }

            if (str.startsWith("FWDB"))
                return toDate(DateFormatUtils.format(getFWDB(basicDate), "yyyyMMdd").concat(StringUtils.difference("FWDB", str)));
            else
                return toDate(DateFormatUtils.format(getFWDE(basicDate), "yyyyMMdd").concat(StringUtils.difference("FWDE", str)));
        } else
            return toDate(str);
    }

    private static Stack<String> operSrcStr(String str){
        Stack<String> list = new Stack<>();
        Date basicDate = DateUtils.truncate(new Date(), Calendar.DATE);

        while (isNest(str)){
            basicDate = parseDate(StringUtils.substring(str, str.indexOf("(") + 1, str.lastIndexOf(")")));
            list.push(StringUtils.substringBefore(str, "("));
            str = StringUtils.substring(str, str.indexOf("(") + 1, str.lastIndexOf(")"));
        }

        while (!list.isEmpty()){
            String item = list.pop();
            if (item.startsWith("FWDB")){
                basicDate = toDate(DateFormatUtils.format(getFWDB(basicDate), "yyyyMMdd").concat(StringUtils.difference("FWDB", item)));
            }else if (item.startsWith("FWDE")){
                basicDate = toDate(DateFormatUtils.format(getFWDE(basicDate), "yyyyMMdd").concat(StringUtils.difference("FWDE", item)));
            }
        }

        System.out.println(basicDate);
        return list;
    }

    private static Date getFWDB(Date date){
        return DateUtils.addDays(DateUtils.truncate(date, Calendar.DATE), -1);
    }

    private static Date getFWDE(Date date){
        return DateUtils.addDays(DateUtils.truncate(date, Calendar.DATE), 1);
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
            System.out.println("格式化日期错误:" + e.getMessage());
        }

        return null;
    }
}
