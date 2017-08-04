package component.mock.test;

import component.mock.base.OtherSysFacade;
import component.mock.base.OtherSysFacadeMock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by wangjianjun on 2017/8/4.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-applicationContext.xml"})
public class MainTest {

    @Autowired
    private OtherSysFacade otherSysFacade;

    @Test
    public void testBaseMock(){

//        也可以通过注解方式(如上)
//        ApplicationContext atx =new  ClassPathXmlApplicationContext("classpath:test-applicationContext.xml");
//        OtherSysFacade otherSysFacade = (OtherSysFacade) atx.getBean("otherSysFacade");

        System.out.println(otherSysFacade.getMsg("xx"));
        System.out.println(otherSysFacade.oper("succ"));
        System.out.println(otherSysFacade.oper("xx"));
        System.out.println(otherSysFacade.getResult(1));
        try {
            System.out.println(otherSysFacade.exceptionFun());
        }catch (Exception e){
            System.out.println("捕获异常");
        }


    }
}
