package thread.multiply.volatile_.case_;

/**
 * Created by wangjianjun on 2017/8/18.
 */
public class StatusC {

    volatile boolean flag = false;

    public void fun_() {

        while (!flag){
            //doSomeThing()
        }
    }

    public void setFlag() {
        this.flag = true;
    }
}
