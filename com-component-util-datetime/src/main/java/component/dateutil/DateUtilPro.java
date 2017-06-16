package component.dateutil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wangjianjun on 2017/6/16.
 * 做同步处理
 */
public class DateUtilPro {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String formatDate(Date date){
        synchronized (sdf) {
            return sdf.format(date);
        }
    }

    //这种做法会出现问题，如果线程操作过多，所以需要对sdf做同步处理
    public static Date parse(String strDate) throws ParseException {
        synchronized (sdf) {
            return sdf.parse(strDate);
        }
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
