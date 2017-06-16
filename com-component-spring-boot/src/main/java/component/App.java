package component;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@RestController
public class App 
{
    public App() {
    }

    @RequestMapping("/")
    public String greeting(){
        return "GREETING HAHHAAHA";
    }

    public static void main(String[] args )
    {
//        System.out.println( "Hello World!" );
        //启动spring boot
        SpringApplication.run(App.class,args);
    }
}
