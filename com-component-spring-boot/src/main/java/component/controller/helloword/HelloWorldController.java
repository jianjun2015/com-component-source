package component.controller.helloword;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wangjianjun on 2017/5/15.
 */
@RestController
public class HelloWorldController {

    @RequestMapping("/hello")
    public String getHello(){
        String str = "hello world!!!";

        return str;
    }

}
