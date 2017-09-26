package component.spring.aopxml;

import component.spring.base.UnitTestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

/**
 * Created by wangjianjun on 2017/9/26.
 */
@RunWith(BlockJUnit4ClassRunner.class) //默认执行器
public class ArithmeticCalculatorTest extends UnitTestBase {



    public ArithmeticCalculatorTest() {
        super("classpath:applicationContext_auto.xml");
    }

    @Test
    public void add() throws Exception {

        ArithmeticCalculator arithmeticCalculator = super.getBean("arithmeticCalculator_");
        arithmeticCalculator.add(1,2);
    }

    @Test
    public void sub() throws Exception {
    }

    @Test
    public void mul() throws Exception {
    }

    @Test
    public void div() throws Exception {
    }

}