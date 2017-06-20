package component.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by wangjianjun on 2017/6/20.
 */
public class Main {

    public static void main(String[] args) {

        String sql = "select * from country";
        DBHelper dbHelper = new DBHelper(sql);
        try {
            ResultSet resultSet = dbHelper.pst.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String countryName = resultSet.getString("countryname");
                String countryCode = resultSet.getString("countryCode");

                System.out.println(id+" "+countryName+" "+" "+countryCode);
            }

            resultSet.close();
            dbHelper.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
