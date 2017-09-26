package component.spring.autowrite;

/**
 * Created by wangjianjun on 2017/9/26.
 */
public class AutoWiringService {

    private AutoWiringDao autoWiringDao;

    public void setAutoWiringDao(AutoWiringDao autoWiringDao) {
        this.autoWiringDao = autoWiringDao;
    }

    public void say(String word){
        autoWiringDao.say("Hello");
    }
}
