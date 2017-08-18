package thread.multiply.threadlocal.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 将创建和关闭封装到一个方法也可以解决问题
 * Created by wangjianjun on 2017/8/18.
 */
public class ConnectManager_ {

    private Connection connection = null;

    public Connection openConnection(){
        if (connection == null)
            try {
                connection = DriverManager.getConnection("");
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return connection;
    }

    public void closeConnection(){
        if (connection != null)
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
}
