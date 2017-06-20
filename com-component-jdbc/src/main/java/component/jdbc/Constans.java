package component.jdbc;

/**
 * Created by wangjianjun on 2017/6/20.
 */
public class Constans {

    public static String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8";
    public static String driverName="com.mysql.jdbc.Driver";
    public static String username="root";
    public static String password="123456";

    public static String getUrl() {
        return url;
    }

    public static void setUrl(String url) {
        Constans.url = url;
    }

    public static String getDriverName() {
        return driverName;
    }

    public static void setDriverName(String driverName) {
        Constans.driverName = driverName;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        Constans.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        Constans.password = password;
    }
}
