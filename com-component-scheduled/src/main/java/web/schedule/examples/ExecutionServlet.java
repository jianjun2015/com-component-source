package web.schedule.examples;

import it.sauronsoftware.cron4j.Scheduler;
import it.sauronsoftware.cron4j.TaskExecutor;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wangjianjun on 2017/9/14.
 */
public class ExecutionServlet  extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // Retrieves the servlet context.
        ServletContext context = getServletContext();
        // Retrieves the scheduler.
        Scheduler scheduler = (Scheduler) context
                .getAttribute(Constants.SCHEDULER);
        // Retrieves the executors.
        TaskExecutor[] executors = scheduler.getExecutingTasks();
        // Registers the executors in the request.
        req.setAttribute("executors", executors);
        // Action requested?
        String action = req.getParameter("action");
        if ("pause".equals(action)) {
            String id = req.getParameter("id");
            TaskExecutor executor = find(executors, id);
            if (executor != null && executor.isAlive() && !executor.isStopped()
                    && executor.canBePaused() && !executor.isPaused()) {
                executor.pause();
            }
        } else if ("resume".equals(action)) {
            String id = req.getParameter("id");
            TaskExecutor executor = find(executors, id);
            if (executor != null && executor.isAlive() && !executor.isStopped()
                    && executor.canBePaused() && executor.isPaused()) {
                executor.resume();
            }
        } else if ("stop".equals(action)) {
            String id = req.getParameter("id");
            TaskExecutor executor = find(executors, id);
            if (executor != null && executor.isAlive()
                    && executor.canBeStopped() && !executor.isStopped()) {
                executor.stop();
            }
        }
        // Layout.
        String page = "ongoing.jsp";
        RequestDispatcher dispatcher = req.getRequestDispatcher(page);
        dispatcher.include(req, resp);
    }

    private TaskExecutor find(TaskExecutor[] executors, String id) {
        if (id == null) {
            return null;
        }
        for (int i = 0; i < executors.length; i++) {
            String aux = executors[i].getGuid();
            if (aux.equals(id)) {
                return executors[i];
            }
        }
        return null;
    }
}
