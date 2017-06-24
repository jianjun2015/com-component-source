package component.spring.aopxml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by wangjianjun on 2017/6/24.
 */
public class Main {

    public static void main(String[] args) {

        //1、创建spring ioc
        //2、获取bean
        //3、使用bean

        ApplicationContext ctx =new  ClassPathXmlApplicationContext("applicationContext_auto.xml");
        ArithmeticCalculator arithmeticCalculator = (ArithmeticCalculator) ctx.getBean("arithmeticCalculator_");

        int //result = arithmeticCalculator.add(3,6);
        result = arithmeticCalculator.div(10,0);
        System.out.println(result);
    }
}
