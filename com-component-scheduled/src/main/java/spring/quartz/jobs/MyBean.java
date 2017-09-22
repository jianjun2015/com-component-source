package spring.quartz.jobs;

import org.springframework.stereotype.Component;

/**
 * Created by wangjianjun on 2017/9/22.
 */
@Component("myBean")
public class MyBean {

    public void printMessage(){
        System.out.println("T am MYBean.MethodInvokingJobDetailFactoryBean");
    }
}
