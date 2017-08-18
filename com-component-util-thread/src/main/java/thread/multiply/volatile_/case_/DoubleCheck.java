package thread.multiply.volatile_.case_;

/**
 *
 * Created by wangjianjun on 2017/8/18.
 */
public class DoubleCheck {

    private volatile static DoubleCheck instance = null;

    private DoubleCheck(){}

    /**
     * 因为每次到要同步，所以加了两次检查
     * @return
     */
    public  static DoubleCheck getInstance(){
        if (instance==null) {
            synchronized (DoubleCheck.class) {
                if (instance == null) {
                    return new DoubleCheck();
                }
            }
        }

        return instance;
    }
}
