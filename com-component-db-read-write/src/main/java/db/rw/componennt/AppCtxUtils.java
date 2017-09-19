package db.rw.componennt;

import org.springframework.context.ApplicationContext;

/**
 * Created by wangjianjun on 2017/9/11.
 */
public class AppCtxUtils {

    private static ApplicationContext appCtx;

    public static ApplicationContext getAppCtx() {
        assertContextInjected();
        return appCtx;
    }

    public static <T> T getBean(Class<T> clazz){
        assertContextInjected();
        return appCtx.getBean(clazz);
    }

    public static <T> T getBean(String beanName){
        assertContextInjected();
        return (T) appCtx.getBean(beanName);
    }

    public static <T> T getBean(String beanName,Class<T> clazz){
        assertContextInjected();
        return appCtx.getBean(beanName,clazz);
    }

    private static void assertContextInjected() {
        if (appCtx == null) {
            throw new IllegalStateException("applicaitonContext未注入!");
        }
    }

    public static void init(ApplicationContext appCtx2){
        appCtx = appCtx2;
    }

    private AppCtxUtils(){}
}
