package component.form2list;

import java.math.BigDecimal;

/**
 * Created by wangjianjun on 2017/6/20.
 */
public class NumberUtil {

    @SuppressWarnings("unused")
    private static BigDecimal toBigDecimal(String s) {
        try {
            return new BigDecimal(s);
        } catch(Exception e) {
            return new BigDecimal(0);
        }
    }

    @SuppressWarnings("unused")
    public static int toInt(String value, int defaultInt) {
        int result = 0;
        try {
            result = Integer.parseInt(value);
        } catch(NumberFormatException e) {
            result = defaultInt;
        }
        return result;
    }

    @SuppressWarnings("unused")
    public static boolean toBoolean(String value, boolean defaultBoolean) {
        boolean result;
        try {
            result = Boolean.parseBoolean(value);
        } catch(NumberFormatException e) {
            result = defaultBoolean;
        }
        return result;
    }

    @SuppressWarnings("unused")
    public static Byte toByte(String value, Byte defaultByte) {
        Byte result = 0;
        try {
            result = Byte.parseByte(value);
        } catch(NumberFormatException e) {
            result = defaultByte;
        }
        return result;
    }

    @SuppressWarnings("unused")
    public static Long toLong(String value, Long defaultLong) {
        Long result;
        try {
            result = Long.parseLong(value);
        } catch(NumberFormatException e) {
            result = defaultLong;
        }
        return result;
    }

    @SuppressWarnings("unused")
    public static Float toFloat(String value, Float defaultFloat) {
        Float result;
        try {
            result = Float.parseFloat(value);
        } catch(NumberFormatException e) {
            result = defaultFloat;
        }
        return result;
    }

    @SuppressWarnings("unused")
    public static Double toDouble(String value, Double defaultDouble) {
        Double result;
        try {
            result = Double.parseDouble(value);
        } catch(NumberFormatException e) {
            result = defaultDouble;
        }
        return result;
    }
}
