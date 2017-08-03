package com.base.util.other;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.collections.map.MultiValueMap;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by houjun on 2016-2-24.
 */
public class InsUtils {
    private InsUtils() {
    }

    public static List<String> toList(String str) {
        return toList(str, ",");
    }

    public static List<String> toList(String str, String separator) {
        Args.notNull(separator, "separator");
        if (StringUtils.isBlank(str))
            return new ArrayList();

        List<String> list = new ArrayList();
        String[] ss = StringUtils.split(str, separator);
        if (ss != null) {
            for (String s : ss)
                list.add(s.trim());
        }
        return list;
    }

    public static String toStr(Collection<String> collection) {
        if (collection == null || collection.isEmpty())
            return null;

        return StringUtils.join(collection, ",");
    }

    public static <T> T nvl(T t1, T t2) {
        if (t1 != null)
            return t1;
        return t2;
    }

    public static <T> List<List<T>> group(List<T> list, int count) {
        if (count < 1)
            throw new IllegalArgumentException("count的值应大于或等于1");

        if (list == null)
            return new ArrayList();

        List<List<T>> results = new ArrayList();
        int position = 0;
        while (true) {
            if (list.size() > (position + count)) {
                results.add(new ArrayList(list.subList(position, position + count)));
                position = position + count;
            } else {
                results.add(new ArrayList(list.subList(position, list.size())));
                break;
            }
        }
        return results;
    }

    public static Date toDate(String dateStr, String format) {
        Args.notNull(format, "format");
        if (StringUtils.isBlank(dateStr))
            return null;
        try {
            return DateUtils.parseDate(dateStr, format);
        } catch (ParseException e) {
            throw new RuntimeException(String.format("解析时间出错,%s:%s", dateStr, format));//NOSONAR
        }
    }

    public static String getDateStr(Date d, String format) {
        if (d == null)
            return null;
        return new SimpleDateFormat(format).format(d);
    }

    public static String getCurrDateStr() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    public static String addPropertyToJsonStr(String jsonStr, String propertyKey, Object propertyValue) {
        JSONObject jo = new JSONObject();
        if (StringUtils.isNotBlank(jsonStr))
            jo = JSON.parseObject(jsonStr);

        jo.put(propertyKey, propertyValue);
        return jo.toJSONString();
    }

    public static Object getProperty(String jsonStr, String propertyKey) {
        if (StringUtils.isBlank(jsonStr))
            return null;
        JSONObject jo = JSON.parseObject(jsonStr);
        return jo.get(propertyKey);
    }


    public static <T> List<T> extractFields(List list, String fieldName, Class<T> clazz) {
        Args.notNull(fieldName, "fieldName");
        Args.notNull(clazz, "clazz");
        if (list == null)
            return new ArrayList<>();
        Set<T> result = new HashSet<>();
        for (Object o : list) {
            result.add(getPropertyValue(o, fieldName, clazz));
        }

        return new ArrayList<>(result);
    }

    public static <K, V> Map<K, List<V>> toMultiValueMap(List<V> list, String keyPropertyName, Class<K> keyClazz) {
        Args.notNull(keyPropertyName, "keyPropertyName");
        if (list == null)
            return new HashMap<>();
        MultiValueMap map = new MultiValueMap();
        for (V v : list) {
            map.put(getPropertyValue(v, keyPropertyName, keyClazz), v);
        }
        return map;
    }

    public static <K, V> Map<K, V> toMap(List<V> list, String keyPropertyName, Class<K> keyClazz) {
        Args.notNull(keyPropertyName, "keyPropertyName");
        if (list == null)
            return new HashMap<>();
        Map map = new HashMap();
        for (V v : list) {
            map.put(getPropertyValue(v, keyPropertyName, keyClazz), v);
        }
        return map;
    }

    private static <T> T getPropertyValue(Object bean, String keyPropertyName, Class<T> clazz) {
        try {
            return clazz.cast(PropertyUtils.getProperty(bean, keyPropertyName));
        } catch (Exception e) {
            throw new RuntimeException(e); //NOSONAR
        }
    }

    public static String filterEmoji(String str) {
        if (str == null)
            return str;
        return str.replaceAll("[\\ud800\\udc00-\\udbff\\udfff\\ud800-\\udfff]", "*");
    }

    public static String toJsonStr(Map<String, String> map) {
        if (map == null)
            return null;
        JSONObject jo = new JSONObject();
        for (Map.Entry<String, String> entry : map.entrySet())
            jo.put(entry.getKey(), entry.getValue());
        return jo.toJSONString();
    }

    public static Map<String, String> toMap(String jsonStr) {
        if (jsonStr == null)
            return null;
        JSONObject jo = JSON.parseObject(jsonStr);
        Map<String, String> map = new HashMap<>();
        for (Map.Entry entry : jo.entrySet()) {
            map.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()));
        }
        return map;
    }

    public static <K, V> Map<K, V> asMap(K key, V value) {
        Map<K, V> map = new HashMap();
        map.put(key, value);
        return map;
    }

    public static <T> T getOne(Collection<T> col) {
        if (col == null)
            return null;
        return col.iterator().next();
    }

    public static int randomInt(int max) {
        return RandomUtils.nextInt(0, max);
    }

    public static String genUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**随机一个指定长度的数字字符串*/
    public static String randomNumeric(int count) {
        return RandomStringUtils.randomNumeric(count);
    }

    /**随机一个指定长度的字母字符串*/
    public static String randomStr(int count) {
        return RandomStringUtils.randomAlphabetic(count);
    }

    /**随机一个指定长度的字符数字字符串*/
    public static  String randomAlphanumeric(int count){
        return RandomStringUtils.randomAlphanumeric(count);
    }
}
