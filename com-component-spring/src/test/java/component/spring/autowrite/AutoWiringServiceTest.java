package component.spring.autowrite;

import component.spring.base.UnitTestBase;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by wangjianjun on 2017/9/26.
 */
public class AutoWiringServiceTest extends UnitTestBase{
    public AutoWiringServiceTest() {
        super("classpath:applicationContext-autowire.xml");
    }

    @Test
    public void say() throws Exception {

        AutoWiringService service = super.getBean(AutoWiringService.class);
        service.say("HAHA");
    }

}