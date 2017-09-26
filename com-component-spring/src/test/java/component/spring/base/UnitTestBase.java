package component.spring.base;

import org.junit.After;
import org.junit.Before;
import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.StringUtils;

/**
 * Created by wangjianjun on 2017/9/26.
 */
public class UnitTestBase {

    private ClassPathXmlApplicationContext context;

    private String springPath;

    public UnitTestBase(String springPath) {
        this.springPath = springPath;
    }

    @Before
    public void before(){
        if (StringUtils.isEmpty(springPath)){
            springPath = "classpath:application*.xml";
        }

        try {
            context = new ClassPathXmlApplicationContext(springPath);
            context.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @After
    public void after(){
        context.destroy();
    }

    protected <T extends Object> T getBean(String beanId){
        try {
            return (T) context.getBean(beanId);
        }catch (BeansException e){
            e.printStackTrace();
            return null;
        }
    }

    public  <T extends Object> T getBean(Class<T> clazz){
        try {
            return context.getBean(clazz);
        }catch (BeansException e){
            e.printStackTrace();
            return null;
        }
    }
}
