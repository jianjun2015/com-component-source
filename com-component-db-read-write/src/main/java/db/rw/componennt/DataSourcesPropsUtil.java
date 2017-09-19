package db.rw.componennt;

import db.rw.entity.DsInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;


/**
 * Created by wangjianjun on 2017/9/11.
 */
public class DataSourcesPropsUtil extends PropsUtilBase {

    private static Map<String,DsInfo> dsMap = new HashMap<>();

    private DataSourcesPropsUtil() {
    }

    public static void init() {

        InputStream is = null;
        BufferedReader bf = null;

        try {
            is = DataSourcesPropsUtil.class.getClassLoader().getResourceAsStream("props/db.properties");
            Properties prop = new Properties();
            bf = new BufferedReader(new InputStreamReader(is));
            prop.load(bf);
            Map<String, List<Pair>> pairMap = groupByPrefix(prop);
            for (Map.Entry<String, List<Pair>> entry : pairMap.entrySet()) {
                dsMap.put(entry.getKey(), buildDataSource(entry.getKey(), entry.getValue()));
            }
        } catch (IOException e) {
            throw new RuntimeException("初始化DataSourcePropsUtils出错:" + e.getMessage(), e);
        }finally {
            try {
                if (is != null)
                    is.close();
                if (bf!=null)
                    bf.close();
            } catch (IOException e) {
                System.out.println("流出现异常...");
            }
        }
    }

    private static DsInfo buildDataSource(String prefix, List<Pair> pairs){
        DsInfo dsInfo = new DsInfo();
        dsInfo.setDsName(prefix);
        dsInfo.setDsType("mysql");
        for (Pair pair:pairs){
            if (Objects.equals(pair.key,prefix.concat(".jdbc"))){
                dsInfo.setJdbc(pair.value);
            }else if (Objects.equals(pair.key,prefix.concat(".username"))){
                dsInfo.setJdbc(pair.value);
            }else if (Objects.equals(pair.key,prefix.concat(".password"))){
                dsInfo.setJdbc(pair.value);
            }
        }

        return dsInfo;
    }

    public static DsInfo getDsInfoByName(String name){
        return dsMap.get(name);
    }

    public static List<DsInfo> getAll(){
        return new ArrayList(dsMap.values());
    }
}
