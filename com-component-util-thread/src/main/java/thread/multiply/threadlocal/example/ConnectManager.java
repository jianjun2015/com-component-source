package thread.multiply.threadlocal.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 在单线程内么有问题
 * 但是在多线程环境则会出现问题，因为创建连接和关闭连接都没有线程同步
 * 多线程环境：会创建多个连接，操作数据库；也会出现创建连接和关闭连接出现在不同线程，因为connection是共享变量
 * 处于安全考虑：需要对创建连接和关闭连接加线程同步
 * Created by wangjianjun on 2017/8/18.
 */
public class ConnectManager {

    private static Connection connection = null;

    public static Connection openConnection(){
        if (connection == null)
            try {
                connection = DriverManager.getConnection("");
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return connection;
    }

    public static void closeConnection(){
        if (connection != null)
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
}
