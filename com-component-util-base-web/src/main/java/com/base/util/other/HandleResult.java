package com.base.util.other;

/**
 * Created by houjun on 2017-2-24.
 */
public enum HandleResult {
    /**未处理*/
    none,
    /**部分未处理*/
    part,
    /**处理完毕*/
    all;


    public static boolean isNone(String value) {
        return none.name().equals(value);
    }

    public static boolean isNone(HandleResult value) {
        return none.equals(value);
    }

    public static boolean isPart(String value) {
        return part.name().equals(value);
    }

    public static boolean isPart(HandleResult value) {
        return part.equals(value);
    }

    public static boolean isAll(String value) {
        return all.name().equals(value);
    }

    public static boolean isAll(HandleResult value) {
        return all.equals(value);
    }

}
