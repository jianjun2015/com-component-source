package com.base.util.other;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author houjun
 */
@Component
public class AppCtxUtils {

    private static ApplicationContext appCtx;


    public static ApplicationContext getAppCtx() {
        assertContextInjected();
        return appCtx;
    }

    @SuppressWarnings("unchecked")
    public static <T> T getBean(Class<T> clazz) {
        assertContextInjected();

        return appCtx.getBean(clazz);
    }

    public static <T> T getBean(String beanName) {
        assertContextInjected();
        return (T) appCtx.getBean(beanName);
    }

    public static <T> T getBean(String beanName, Class<T> clazz) {
        assertContextInjected();
        return appCtx.getBean(beanName, clazz);
    }

    private static void assertContextInjected() {
        if (appCtx == null) {
            throw new IllegalStateException("applicaitonContext未注入!");
        }
    }

    public static void init(ApplicationContext appCtx2) {
        appCtx = appCtx2;
    }

    private AppCtxUtils() {

    }
}
