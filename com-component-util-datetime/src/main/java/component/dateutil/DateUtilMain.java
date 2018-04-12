package component.dateutil;

import org.apache.commons.lang3.time.DateUtils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author: wangjianjun
 * @description:
 * @date: 2018/4/12 14:23
 * @version: V1.0
 */
public class DateUtilMain {

    public static SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static SimpleDateFormat timeFormat1 = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
    public static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    public static SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyyMMdd");
    public static SimpleDateFormat dateFormat3 = new SimpleDateFormat("yyyy.MM.dd");
    public static SimpleDateFormat monthAndDayFormat = new SimpleDateFormat("MM/dd");
    public static SimpleDateFormat yearAndMonthFormat = new SimpleDateFormat("yyyy-MM");
    public static SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");

    /**
     * 获取：从指定日期开始，相隔指定【跨度月】的，最后一天（如当前3月，跨度2个月，返回4月30号）
     *
     * @param startDate
     * @param monthDuration
     * @return
     * @author caojun1@hisense.com
     */
    public static Date getDuraMonthLastDay(Date startDate, int monthDuration) {
        if (startDate == null) {
            startDate = new Date();
        }
        Calendar lastDate = Calendar.getInstance();
        lastDate.setTime(startDate);
        lastDate.add(Calendar.MONTH, monthDuration);// 加n个月
        lastDate.set(Calendar.DATE, 1);// 把日期设置为当月第一天
        lastDate.roll(Calendar.DAY_OF_YEAR, -1);// 日期回滚一天，也就是本月最后一天
        return lastDate.getTime();
    }

    /**
     * 获取：从指定日期开始，相隔指定跨度【月】的，第一天（如当前3月，跨度2个月，返回4月1号）
     *
     * @param startDate
     * @param monthDuration
     * @return
     * @author caojun1@hisense.com
     */
    public static Date getDuraMonthFirstDay(Date startDate, int monthDuration) {
        if (startDate == null) {
            startDate = new Date();
        }
        Calendar lastDate = Calendar.getInstance();
        lastDate.setTime(startDate);
        lastDate.add(Calendar.MONTH, monthDuration - 1);// 加n-1个月
        lastDate.set(Calendar.DATE, 1);// 把日期设置为当月第一天
        return lastDate.getTime();
    }

    /**
     * 获取：从指定日期开始，相隔指定跨度【自然周】的，最后一天
     *
     * @param startDate
     * @param weekDuration
     * @return
     */
    public static Date getDuraWeekLastDay(Date startDate, int weekDuration) {
        if (startDate == null) {
            startDate = new Date();
        }
        Calendar lastDate = Calendar.getInstance();
        lastDate.setTime(startDate);
        lastDate.add(Calendar.WEEK_OF_YEAR, weekDuration);// 加n个周
        lastDate.set(Calendar.DAY_OF_WEEK, 1);// 把日期设置为当周第一天（上周日）
        return lastDate.getTime();
    }

    /**
     * 获取：从指定日期开始，相隔指定跨度【自然周】的，第一天
     *
     * @param startDate
     * @param weekDuration
     * @return
     */
    public static Date getDuraWeekFirstDay(Date startDate, int weekDuration) {
        if (startDate == null) {
            startDate = new Date();
        }
        Calendar lastDate = Calendar.getInstance();
        lastDate.setTime(startDate);
        lastDate.add(Calendar.WEEK_OF_YEAR, weekDuration);// 加n个周
        lastDate.set(Calendar.DAY_OF_WEEK, 2);// 把日期设置为当周第二天（本周一）
        return lastDate.getTime();
    }

    /**
     * 获取：指定【跨度月】的、连续的月（其中，date的日，同为当前日）（顺序：由近向远期排序）
     *
     * @param startDate
     *            可空（空时，为当前日期）
     * @param monthDuration
     *            可负数（负数为前n个月）
     * @return
     */
    public static List<Date> getNextMonths2(Date startDate, int monthDuration) {
        if (startDate == null) {
            startDate = new Date();
        }

        List<Date> list = new ArrayList<Date>();
        int gap = 0;
        if (monthDuration > 0) {
            gap = 1;
        } else {
            gap = -1;
            monthDuration = 0 - monthDuration;
        }
        for (int i = 0; i < monthDuration; i++) {
            startDate = DateUtils.addMonths(startDate, gap);
            list.add(startDate);
        }

        return list;
    }

    /**
     * 获取：指定【跨度月】的、连续的月（其中，date的日，同为当前日）（顺序：时间倒序）
     *
     * @param startDate
     *            可空（空时，为当前日期）
     * @param monthDuration
     *            可负数（负数为前n个月）
     * @return
     */
    public static List<Date> getNextMonths(Date startDate, int monthDuration) {
        if (startDate == null) {
            startDate = new Date();
        }

        List<Date> list = new ArrayList<Date>();
        if (monthDuration > 0) {
            Date d;
            for (int i = 1; i < monthDuration + 1; i++) {
                d = DateUtils.addMonths(startDate, i);
                list.add(d);
            }
        } else {
            Date d;
            for (; monthDuration < 0; monthDuration++) {
                d = DateUtils.addMonths(startDate, monthDuration);
                list.add(d);
            }
        }

        return list;
    }



    /**
     * 获取：指定【跨度周】的、连续的所有自然周（其中，date的周，同为当前周）
     *
     * @param startDate
     *            可空（空时，为当前日期）
     * @param weekDuration
     *            可负数（负数为前n个周）
     * @return
     */
    public static List<Date> getNextWeeks(Date startDate, int weekDuration) {
        if (startDate == null) {
            startDate = new Date();
        }

        List<Date> list = new ArrayList<Date>();
        int gap = 0;
        if (weekDuration > 0) {
            gap = 1;
        } else {
            gap = -1;
            weekDuration = 0 - weekDuration;
        }
        for (int i = 0; i < weekDuration; i++) {
            startDate = DateUtils.addWeeks(startDate, gap);
            list.add(startDate);
        }

        return list;
    }

    public static void main(String[] args) {
        Date date = getDuraMonthFirstDay(new Date(),1);

        System.out.println(date);
    }

}
