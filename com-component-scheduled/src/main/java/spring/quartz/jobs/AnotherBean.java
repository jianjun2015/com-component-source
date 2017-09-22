package spring.quartz.jobs;

import org.springframework.stereotype.Component;

/**
 * Created by wangjianjun on 2017/9/22.
 */
@Component("anotherBean")
public class AnotherBean {

    public void printAnotherMessage(){
        System.out.println("AnotherBean");
    }
}
