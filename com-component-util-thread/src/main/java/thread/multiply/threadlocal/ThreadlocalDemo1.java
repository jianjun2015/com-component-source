package thread.multiply.threadlocal;

import component.thread.TljucUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: wangjianjun
 * @description:
 * @date: 2018/5/7 16:38
 * @version: V1.0
 */
public class ThreadlocalDemo1  implements Runnable {

    static ThreadLocal<SimpleDateFormat> tl=new ThreadLocal<SimpleDateFormat>();
    static SimpleDateFormat simpleDateFormat=null;

    public static void main(String[] args) {
        TljucUtil.timeTasks(100,1,new ThreadlocalDemo1());
    }

    @Override
    public void run() {
        try {
            if(tl.get()==null){
                tl.set(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
            }
            Date date=tl.get().parse("2017-11-28 22:45:11");
            Thread.sleep(100);
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
