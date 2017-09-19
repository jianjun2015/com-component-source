package com.concurrency.componennt;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * Created by wangjianjun on 2017/9/11.
 */
public class PropsUtilBase {

    protected static Map<String, List<Pair>> groupByPrefix(Properties prop) {
        Map<String, List<Pair>> map = new HashMap();
        for (String propertyName : prop.stringPropertyNames()) {
            String prefix = StringUtils.substringBefore(propertyName, ".");
            if (map.get(prefix) == null)
                map.put(prefix, new ArrayList<Pair>());
            map.get(prefix).add(new Pair(propertyName, prop.getProperty(propertyName)));
        }
        return map;
    }

    protected static class Pair {
        String key;
        String value;

        public Pair(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }
}
