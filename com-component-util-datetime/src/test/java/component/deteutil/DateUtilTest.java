package component.deteutil;

import component.dateutil.DateUtilThreadLocal;
import junit.framework.TestCase;
import org.junit.Ignore;

import java.text.ParseException;

/**
 * Created by wangjianjun on 2017/6/16.
 */
@Ignore
public class DateUtilTest extends TestCase {

    public static class TestSimpleDateFormatThreadSafe extends Thread{

        @Override
        public void run() {
            while (true){
                try {
                    this.join(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                try {
//                    System.out.println(this.getName()+":"+ DateUtil.parse("2017-05-24 06:02:20"));
//                    System.out.println(this.getName()+":"+ DateUtilPro.parse("2017-05-24 06:02:20"));
                    System.out.println(this.getName()+":"+ DateUtilThreadLocal.parse("2017-05-24 06:02:20"));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        for (int i=0;i<3;i++){
            new TestSimpleDateFormatThreadSafe().start();
        }
    }
}
