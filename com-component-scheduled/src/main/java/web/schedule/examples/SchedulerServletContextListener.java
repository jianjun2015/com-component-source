package web.schedule.examples;

import it.sauronsoftware.cron4j.Scheduler;
import it.sauronsoftware.cron4j.TaskCollector;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by wangjianjun on 2017/9/14.
 */
public class SchedulerServletContextListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent event) {
        ServletContext context = event.getServletContext();
        // 1. Creates the scheduler.
        Scheduler scheduler = new Scheduler();
        // 2. Registers a custom task collector.
        TaskCollector collector = new MyTaskCollector();
        scheduler.addTaskCollector(collector);
        // 3. Starts the scheduler.
        scheduler.start();
        // 4. Registers the scheduler.
        context.setAttribute(Constants.SCHEDULER, scheduler);
    }

    public void contextDestroyed(ServletContextEvent event) {
        ServletContext context = event.getServletContext();
        // 1. Retrieves the scheduler from the context.
        Scheduler scheduler = (Scheduler) context.getAttribute(Constants.SCHEDULER);
        // 2. Removes the scheduler from the context.
        context.removeAttribute(Constants.SCHEDULER);
        // 3. Stops the scheduler.
        scheduler.stop();
    }
}
