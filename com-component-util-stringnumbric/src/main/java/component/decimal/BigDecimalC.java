package component.decimal;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangjianjun on 2017/7/10.
 */
public class BigDecimalC {

    public static void main(String[] args) {
//        func_();
        System.out.println(equalZero_());
    }

    public static void func_(){
        Map<String,Object> map = new HashMap<>();
        map.put("v1","0.000000");
        BigDecimal value =  getValue(map);
        if (value != null && value.compareTo(BigDecimal.ZERO) == 0){
            System.out.println(true);
        }else {
            System.out.println(false);
        }
    }

    private static BigDecimal getValue(Map<String,Object> map){
        if (map == null || map.isEmpty())
            return null;
        Object value = map.values().iterator().next();
        if (value == null)
            return null;
        if (value instanceof Integer)
            return new BigDecimal((Integer) value);
        else if (value instanceof Long)
            return new BigDecimal((Long) value);
        else if (value instanceof Double)
            return new BigDecimal((Double) value);
        else if (value instanceof BigDecimalC)
            return (BigDecimal) value;
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

    private static boolean equalZero_(){

        Object value = 0.000000;
        BigDecimal value_ = null;

        BigDecimal bigDecimal = BigDecimal.valueOf(0);

        if (value instanceof Integer)
            value_ =  new BigDecimal((Integer) value);
        else if (value instanceof Long)
            value_ =  new BigDecimal((Long) value);
        else if (value instanceof Double)
            value_ =  new BigDecimal((Double) value);
        else if (value instanceof BigDecimalC)
            value_ =  (BigDecimal) value;

        BigDecimal bigDecimal_ = value_;

        if (bigDecimal_.compareTo(BigDecimal.ZERO) == 0){
            return true;
        }
        return false;
    }
}
