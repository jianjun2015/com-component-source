package component.dateutil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wangjianjun on 2017/6/16.
 * 在正常的测试情况之下，都没有问题，但一旦在生产环境中一定负载情况下时，
 * 这个问题就出来了。他会出现各种不同的情况，比如转化的时间不正确，比如报错，比如线程被挂死等等
 * 主要原因在format方法对calendar做了更新操作
 * 解决办法见DateUtilPro
 */
public class DateUtil {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String formatDate(Date date){
        return sdf.format(date);
    }

    //这种做法会出现问题，如果线程操作过多，所以需要对sdf做同步处理
    public static Date parse(String strDate) throws ParseException {
        return sdf.parse(strDate);
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
