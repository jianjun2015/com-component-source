package component.spring.ioc;

import component.spring.base.UnitTestBase;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by wangjianjun on 2017/9/26.
 */
public class BeanScopeTest extends UnitTestBase{
    public BeanScopeTest() {
        super("applicationContext-ioc.xml");
    }

    @Test
    public void say() throws Exception {

        BeanScope beanScope = super.getBean("beanScope");
        BeanScope beanScope_ = super.getBean("beanScope");

        BeanScope beanScope_o = super.getBean("beanScope_");
        BeanScope beanScope_o_ = super.getBean("beanScope_");

        System.out.println(beanScope == beanScope_);
        System.out.println(beanScope_o == beanScope_o_);
    }

}