package thread.multiply.threadlocal.case_;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * ThreadLocal 解决数据库连接问题
 * Created by wangjianjun on 2017/8/18.
 */
public class DBConn {

    private static ThreadLocal<Connection> connectionHolder
            = new ThreadLocal<Connection>(){
        @Override
        protected Connection initialValue() {
            try {
                return DriverManager.getConnection("url");
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return null;
        }
    };

    public static Connection getConn(){
        return connectionHolder.get();
    }
}
