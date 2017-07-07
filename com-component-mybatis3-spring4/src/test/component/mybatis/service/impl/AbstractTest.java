package component.mybatis.service.impl;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

/**
 * Created by wangjianjun on 2017/7/7.
 */
public class AbstractTest {

    @Autowired
    private ApplicationContext appCtx;

    @Before
    public void setUp() throws Exception {
//        AppCtxUtils.init(appCtx);

    }
}
