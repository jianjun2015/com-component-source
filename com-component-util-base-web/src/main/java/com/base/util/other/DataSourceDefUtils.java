package com.base.util.other;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by houjun on 2017-4-24.
 */
public class DataSourceDefUtils {

    private static Map<String, DataSourceDef> dsMap = new HashMap();

    private DataSourceDefUtils() {

    }

    public static void init() {
        InputStream in = null;
        BufferedReader bf = null;
        try {
            in = DataSourceDefUtils.class.getClassLoader().getResourceAsStream("datasourcedef.properties");
            Properties prop = new Properties();
            bf = new BufferedReader(new InputStreamReader(in, "UTF-8"));
            prop.load(bf);
            Map<String, List<Pair>> pairMap = groupByPrefix(prop);
            for (Map.Entry<String, List<Pair>> entry : pairMap.entrySet()) {
                dsMap.put(entry.getKey(), buildDataSourceDef(entry.getKey(), entry.getValue()));
            }

        } catch (Exception e) {
            throw new RuntimeException("初始化DataSourceDefUtils出错:" + e.getMessage(), e);
        } finally {
            try {
                if (in != null)
                    in.close();
            } catch (IOException e) {
            }
            try {
                if (bf != null)
                    bf.close();
            } catch (IOException e) {

            }
        }
    }

    private static DataSourceDef buildDataSourceDef(String prefix, List<Pair> pairs) {
        DataSourceDef ds = new DataSourceDef();
        ds.setDsName(prefix);
        ds.setDsType(DatabaseType.mysql);
        ds.setCreateTime(new Date());
        ds.setModifyTime(new Date());
        for (Pair p : pairs) {
            if (Objects.equals(p.key, prefix.concat(".jdbc")))
                ds.setJdbcUrl(p.value);
            else if (Objects.equals(p.key, prefix.concat(".username")))
                ds.setDsUserName(p.value);
            else if (Objects.equals(p.key, prefix.concat(".password")))
                ds.setDsPassword(p.value);
        }
        return ds;
    }

    private static Map<String, List<Pair>> groupByPrefix(Properties prop) {
        Map<String, List<Pair>> map = new HashMap();
        for (String propertyName : prop.stringPropertyNames()) {
            String prefix = StringUtils.substringBefore(propertyName, ".");
            if (map.get(prefix) == null)
                map.put(prefix, new ArrayList<Pair>());
            map.get(prefix).add(new Pair(propertyName, prop.getProperty(propertyName)));
        }
        return map;
    }

    public static DataSourceDef getDataSource(String dsName) {
        return dsMap.get(dsName);
    }

    public static List<DataSourceDef> getAll() {
        return new ArrayList(dsMap.values());
    }


    private static class Pair {
        String key;
        String value;

        public Pair(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }
}
