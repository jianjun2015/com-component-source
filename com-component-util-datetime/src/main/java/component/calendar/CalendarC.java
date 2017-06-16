package component.calendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by wangjianjun on 2017/6/16.
 */
public class CalendarC {

    public static void fun_TimeInMillis(){
        Long millins = System.currentTimeMillis();
        System.out.println(millins);
    }

    //优化见dateutil包下面
    public static void fun_date_str() throws ParseException {

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strDate = sdf.format(date);
        Date now = sdf.parse(strDate);

        System.out.println(strDate);
        System.out.println(now);
    }

    //calendar与date转化
    public static void fun_date_calandar(){

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        Date date = calendar.getTime();

        System.out.println(date);
    }

    public static void fun_calendar(){
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR,2017);
        calendar.set(Calendar.MONTH,6-1);//注意,Calendar对象默认一月为0
        calendar.set(Calendar.DAY_OF_MONTH,16);
        int day = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        System.out.println(calendar.getTime());
        System.out.println(day);
    }

    public static void fun_interval_days(Calendar startday,Calendar endday){

        if (startday.after(endday)){
            Calendar cal=startday;
            startday=endday;
            endday=cal;
        }

        long sl = startday.getTimeInMillis();
        long el = endday.getTimeInMillis();

        long se = el-sl;
        long datInt = (long) Math.ceil(se/(1000*60*60*24));

        System.out.println(datInt);
    }

    public static int getDaysBetween(Calendar start,Calendar end){
        if (start.after(end)){
            Calendar tmp = start;
            start = end;
            end=tmp;
        }

        int days = end.get(Calendar.DAY_OF_YEAR)-start.get(Calendar.DAY_OF_YEAR);
        Calendar start_clone;
        if (start.get(Calendar.YEAR) != end.get(Calendar.YEAR)){
            start_clone = (Calendar) start.clone();
            do {
                days+=start_clone.getActualMaximum(Calendar.DAY_OF_YEAR);
                start_clone.add(Calendar.YEAR,+1);
            }while (start_clone.get(Calendar.YEAR) != end.get(Calendar.YEAR));
        }

        return days;
    }

    public static int getDaysBetween_(Calendar start,Calendar end){
        if (start.after(end)){
            Calendar tmp = start;
            start = end;
            end=tmp;
        }

        int days = 0;
        if (start.get(Calendar.YEAR) != end.get(Calendar.YEAR)){
            Calendar start_clone = start;
            int startDays=0;//开始年剩余天数
            int midDays=0;//中间跨年天数
            int endDays=0;//结束年已经过完天数

            if ((end.get(Calendar.YEAR) - start.get(Calendar.YEAR)) == 1){
                startDays=start.getActualMaximum(Calendar.DAY_OF_YEAR)-start.get(Calendar.DAY_OF_YEAR);
                endDays = end.get(Calendar.DAY_OF_YEAR);
            }else {
                startDays=start.getActualMaximum(Calendar.DAY_OF_YEAR)-start.get(Calendar.DAY_OF_YEAR);
                do {
                    start_clone.add(Calendar.YEAR,1);
                    midDays+=start_clone.getActualMaximum(Calendar.DAY_OF_YEAR);
                }while (start_clone.get(Calendar.YEAR) != (end.get(Calendar.YEAR)-1));

                endDays=end.get(Calendar.DAY_OF_YEAR);
            }

            days = startDays+midDays+endDays;

        }else {
            days = end.get(Calendar.DAY_OF_YEAR)-start.get(Calendar.DAY_OF_YEAR);
        }

        return days;
    }

    public static void main(String[] args) {
//        fun_calendar();
        Calendar endCal = Calendar.getInstance();
        //endCal.add(Calendar.DAY_OF_MONTH,4);//add 可以跨月，roll在当月循环
        endCal.add(Calendar.YEAR,+2444);

        fun_interval_days(Calendar.getInstance(),endCal);

        System.out.println(getDaysBetween(Calendar.getInstance(),endCal));
        System.out.println(getDaysBetween_(Calendar.getInstance(),endCal));
    }
}
