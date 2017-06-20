package component.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by wangjianjun on 2017/6/20.
 */
public class DBHelper {

    public Connection conn = null;
    public PreparedStatement pst = null;

    public DBHelper(String sql) {

        try {
            Class.forName(Constans.driverName);
            conn = DriverManager.getConnection(
                    Constans.url,
                    Constans.getUsername(),
                    Constans.getPassword());

            pst = conn.prepareStatement(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close(){

        try {
            if (this.pst != null) {
                this.pst.close();
            }
            if (this.conn != null){
                this.conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
