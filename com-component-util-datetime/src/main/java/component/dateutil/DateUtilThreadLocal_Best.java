package component.dateutil;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wangjianjun on 2017/6/16.
 * DateUtilThreadLocal
 */
public class DateUtilThreadLocal_Best {

    private static final String data_format="yyyy-MM-dd HH:mm:ss";
    private static ThreadLocal<DateFormat> threadLocal = new ThreadLocal<>();

    public static DateFormat getDateFormat(){
        DateFormat df = threadLocal.get();
        if (df == null){
            df = new SimpleDateFormat(data_format);
        }
        return df;
    }

    public static String formatDate(Date date){
        return getDateFormat().format(date);
    }

    public static Date parse(String strDate) throws ParseException {
        return getDateFormat().parse(strDate);
    }

    public static void main(String[] args) {
        System.out.println(formatDate(new Date()));
        try {
            System.out.println(parse("2017-06-16 16:35:24"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
