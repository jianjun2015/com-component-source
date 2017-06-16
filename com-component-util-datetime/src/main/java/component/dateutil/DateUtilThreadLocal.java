package component.dateutil;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wangjianjun on 2017/6/16.
 * DateUtilThreadLocal
 */
public class DateUtilThreadLocal {

    private static ThreadLocal<DateFormat> threadLocal = new ThreadLocal<DateFormat>(){

        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };

    public static String formatDate(Date date){
        return threadLocal.get().format(date);
    }

    public static Date parse(String strDate) throws ParseException {
        return threadLocal.get().parse(strDate);
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
