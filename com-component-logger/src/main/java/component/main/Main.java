package component.main;

import component.logpattern.SystemLogger;

/**
 * Created by wangjianjun on 2017/6/19.
 */
public class Main extends SystemLogger {

    public void fun(){
        logger.debug("TTTTT");
    }

    public static void main(String[] args) {

        Main main = new Main();
        main.fun();
    }
}
