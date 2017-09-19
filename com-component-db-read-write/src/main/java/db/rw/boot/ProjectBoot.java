package db.rw.boot;

import db.rw.componennt.AppCtxUtils;
import db.rw.componennt.DataSourcesPropsUtil;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.util.logging.Logger;

/**
 * 项目启动时候加载
 * Created by wangjianjun on 2017/9/11.
 */
public class ProjectBoot implements ApplicationListener<ContextRefreshedEvent>{

    Logger logger = Logger.getLogger("ProjectBoot");

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        logger.info("加载启动类ProjectBoot...");
        if (event.getApplicationContext().getParent() == null){//保证只加载一次
            logger.info("初始化AppCtxUtils...");
            AppCtxUtils.init(event.getApplicationContext());
            logger.info("初始化DataSourcesPropsUtil...");
            DataSourcesPropsUtil.init();
        }
    }
}
