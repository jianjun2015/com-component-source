package com.base.util.other;

/**
 * 特定的值
 * Created by houjun on 2016-11-11.
 */
public enum SpecifiedValue {
    now, today, yesterday, tomorrow,
    /**(Financial working days Begin)判断当前日期是否为金融工作日，如果不是，那么获取前一个最近的金融工作日日期*/
    FWDB,
    /**(Financial working days End)判断当前日期是否为金融工作日，如果不是，那么获取接下来最近的一个金融工作日日期*/
    FWDE;

    public static boolean isNow(String value) {
        return now.name().equals(value);
    }

    public static boolean isNow(SpecifiedValue value) {
        return now.equals(value);
    }

    public static boolean isToday(String value) {
        return today.name().equals(value);
    }

    public static boolean isToday(SpecifiedValue value) {
        return today.equals(value);
    }

    public static boolean isYesterday(String value) {
        return yesterday.name().equals(value);
    }

    public static boolean isYesterday(SpecifiedValue value) {
        return yesterday.equals(value);
    }

    public static boolean isTomorrow(String value) {
        return tomorrow.name().equals(value);
    }

    public static boolean isTomorrow(SpecifiedValue value) {
        return tomorrow.equals(value);
    }

    public static boolean isFWDB(String value) {
        return FWDB.name().equals(value);
    }

    public static boolean isFWDB(SpecifiedValue value) {
        return FWDB.equals(value);
    }

    public static boolean isFWDE(String value) {
        return FWDE.name().equals(value);
    }

    public static boolean isFWDE(SpecifiedValue value) {
        return FWDE.equals(value);
    }
}
