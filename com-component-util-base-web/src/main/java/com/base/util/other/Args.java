package com.base.util.other;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

/**
 * 提供一组常用的断言。
 *
 * @author houjun
 * @since 1.0
 */
public class Args {

    private Args() {
    }

    /**
     * sql注入检查正则表达式
     */
    private static final String REGEX_STR = ".*([';]+|(--)+).*";

    /**
     * 断言参数不是null，若是null将抛出异常。
     *
     * @param argument     参数。
     * @param argumentName 参数名。
     * @throws IllegalArgumentException 当参数argument为null时抛出。
     */
    public static void notNull(Object argument, String argumentName)
            throws IllegalArgumentException {
        if (argument == null) {
            throw new IllegalArgumentException(argumentName + "不能为空");
        }
    }

    /**
     * sql的参数检查（防注入）
     *
     * @param argument
     * @throws IllegalArgumentException
     */
    public static void check4SqlInject(String argument, String argumentName) throws IllegalArgumentException {
        if (argument == null)
            return;
        if (argument.matches(REGEX_STR))
            throw new IllegalArgumentException(argumentName + "参数存在非法字符。");
    }

    /**
     * 检查集合类的参数不能为空，如果为空将抛出异常
     *
     * @param argument
     * @param argumentName
     */
    public static void notEmpty(Object argument, String argumentName) {
        if (argument == null) {
            throw new IllegalArgumentException(argumentName + "不能为空");
        }
        if (argument instanceof Collection && ((Collection) argument).isEmpty()) {
            throw new IllegalArgumentException(argumentName + "不能为空");
        }

        if (argument instanceof Map && ((Map) argument).isEmpty()) {
            throw new IllegalArgumentException(argumentName + "不能为空");
        }
        if (argument.getClass().isArray() && Array.getLength(argument) == 0) {
            throw new IllegalArgumentException(argumentName + "不能为空");
        }
    }

    /**
     * 断言字符串参数没有超出长度限制，若超出将抛出异常。
     *
     * @param argument     参数。
     * @param maxLength    最大长度限制。
     * @param argumentName 参数名。
     * @throws IllegalArgumentException 当参数超出长度限制。
     */
    public static void notTooLong(String argument, int maxLength,
                                  String argumentName) throws IllegalArgumentException {
        if (argument != null && argument.length() > maxLength) {
            throw new IllegalArgumentException(argumentName + "超过最大允许长度"
                    + maxLength);
        }
    }

    /**
     * 判断给定的条件，如果为{@code false}则抛出异常
     *
     * @param condition 给定的条件
     * @param msg       异常消息
     * @throws IllegalArgumentException
     */
    public static void isTrue(boolean condition, String msg) throws IllegalArgumentException {
        if (condition == false)
            throw new IllegalArgumentException(msg);
    }

    /**
     * 判断给定的条件，如果为{@code true}则抛出异常
     *
     * @param condition 给定的条件
     * @param msg       异常消息
     * @throws IllegalArgumentException
     */
    public static void isFalse(boolean condition, String msg) throws IllegalArgumentException {
        if (condition == false)
            throw new IllegalArgumentException(msg);
    }
}
