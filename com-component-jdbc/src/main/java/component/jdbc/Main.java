package component.jdbc;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangjianjun on 2017/6/20.
 */
public class Main {

    public static void main(String[] args) {
//        testJDBC();
//        f_function();
        func_equal();
    }

    public static void testJDBC(){

        String sql = "select *  from test";

        DBHelper dbHelper = new DBHelper(sql);
        try {
            ResultSet resultSet = dbHelper.pst.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                Double countryName = resultSet.getDouble("balance");
                String countryCode = resultSet.getString("name");

                System.out.println(id+" "+countryName+" "+" "+countryCode);
            }

            resultSet.close();
            dbHelper.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void f_function() {

        String sql = "select balance+balance as bb from test";
        sql = "\n" +
                "SELECT (SELECT case when SUM(settlement_capital) is NULL then 0 else SUM(settlement_capital) end FROM t_amc_fund_detail \n" +
                "WHERE product_id in (SELECT product_id FROM t_fis_current_honor_order WHERE prod_value_date='2017-07-07')) - (\n" +
                "SELECT case when sum(investment_amount) is NULL then 0 else sum(investment_amount) end FROM t_fis_current_honor_order \n" +
                "WHERE product_id in (SELECT product_id FROM t_fis_current_honor_order WHERE prod_value_date='2017-07-07') AND STATUS=3)";
        DBHelper dbHelper = new DBHelper(sql);
        try {
            ResultSet resultSet = dbHelper.pst.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            while (resultSet.next()){

                Map<String, Object> resultRow = new HashMap<>(Math.max(16, (int) (metaData.getColumnCount() / 0.75) + 1));
                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    resultRow.put(metaData.getColumnName(i).toLowerCase(), resultSet.getObject(i));
                }


                Object obj = resultSet.getObject(1);
                System.out.println(obj);
                equalZero(resultRow);
            }

            resultSet.close();
            dbHelper.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private static void func_equal(){

        BigDecimal value = BigDecimal.valueOf(0.000000);
        if (value.compareTo(BigDecimal.ZERO) == 0){
            System.out.println(true);
        }
    }

    private static BigDecimal getValue(Map<String, Object> map){

        if (map == null)
            return null;

        Object value = map.values().iterator().next();

        if (value instanceof Integer) {
            System.out.println("Integer");
            return new BigDecimal((Integer) value);
        }
        else if (value instanceof Long) {
            System.out.println("Long");
            return new BigDecimal((Long) value);
        }
        else if (value instanceof Double) {
            System.out.println("Double");
            return new BigDecimal((Double) value);
        }
        else if (value instanceof BigDecimal) {
            System.out.println("BigDecimal");
            return (BigDecimal) value;
        }
        else
            return BigDecimal.valueOf(-1);
    }

    private static boolean equalZero(Map<String, Object> map){
        BigDecimal value = getValue(map);
        if (value != null && value.compareTo(BigDecimal.ZERO) == 0) {
            System.out.println(true);
            return true;
        }

        System.out.println(false);
        return false;
    }
}
