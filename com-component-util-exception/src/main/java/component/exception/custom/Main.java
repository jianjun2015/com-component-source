package component.exception.custom;

/**
 * 自定义异常测试
 * Created by wangjianjun on 2017/7/19.
 */
public class Main {

    public static void main(String[] args) {

        try {
            fun_execption(101);
        }catch (BusiException e){
            e.printStackTrace();
        }


        try {
            fun_exception_(201);
        } catch (BusiException_ busiException_) {
            busiException_.printStackTrace();
        }

    }

    public static void fun_execption(int num) throws BusiException{
        if (num > 100){
            throw new BusiException("大于100了");
        }
    }

    public static void fun_exception_(int num) throws BusiException_{
        if (num > 200){
            throw new BusiException_("大于200了");
        }
    }
}
