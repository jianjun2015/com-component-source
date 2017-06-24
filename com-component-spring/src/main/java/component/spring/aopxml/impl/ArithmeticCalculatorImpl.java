package component.spring.aopxml.impl;

import component.spring.aopxml.ArithmeticCalculator;

/**
 * Created by wangjianjun on 2017/6/24.
 */
public class ArithmeticCalculatorImpl implements ArithmeticCalculator {
    @Override
    public Integer add(Integer arg1, Integer arg2) {
        int result = arg1+arg2;
        return result;
    }

    @Override
    public Integer sub(Integer arg1, Integer arg2) {
        int result = arg1-arg2;
        return result;
    }

    @Override
    public Integer mul(Integer arg1, Integer arg2) {
        int result = arg1*arg2;
        return result;
    }

    @Override
    public Integer div(Integer arg1, Integer arg2) {

        int result = arg1/arg2;

        return result;
    }
}
