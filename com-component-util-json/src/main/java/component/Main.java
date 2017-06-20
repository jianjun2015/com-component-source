package component;

import component.entity.User;
import component.fastjson.FastJsonUtil;
import component.gson.GsonUtil;
import component.jackson.JacksonUtil;
import component.json_lib.JsonlibUtil;

import java.io.IOException;

/**
 * Created by wangjianjun on 2017/6/20.
 */
public class Main {

    User user = new User("zhangsan",22,"SH",2);

    public void testJsonlib(){
        JsonlibUtil jsonlibUtil = new JsonlibUtil();
        long start = System.currentTimeMillis();
//        for (int i=0;i<100000;i++){
//            jsonlibUtil.bean2Json(user);
//        }

        String str  =jsonlibUtil.bean2Json(user);
        for (int i=0;i<100000;i++){
            jsonlibUtil.json2Bean(str,User.class);
        }
        System.out.println(System.currentTimeMillis()-start);
    }

    public void testGson(){
        GsonUtil gsonUtil = new GsonUtil();
        long start = System.currentTimeMillis();
//        for (int i=0;i<100000;i++){
//            gsonUtil.ban2Json(user);
//        }

        String str = gsonUtil.ban2Json(user);
        for (int i=0;i<100000;i++){
            gsonUtil.json2Bean(str,User.class);
        }
        System.out.println(System.currentTimeMillis()-start);
    }

    public void testJackson(){
        JacksonUtil jacksonUtil = new JacksonUtil();
        long start = System.currentTimeMillis();
//        for (int i=0;i<100000;i++){
//            try {
//                jacksonUtil.bean2Json(user);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }

        try {
            String string = jacksonUtil.bean2Json(user);
            for (int i=0;i<100000;i++){
                jacksonUtil.json2Bean(string,User.class);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis()-start);
    }

    public void testFastJson(){
        FastJsonUtil fastJsonUtil = new FastJsonUtil();
        long start = System.currentTimeMillis();
//        for (int i=0;i<100000;i++){
//            fastJsonUtil.bean2Json(user);
//        }

        String str = fastJsonUtil.bean2Json(user);
        for (int i=0;i<100000;i++){
            fastJsonUtil.json2Bean(str,User.class);
        }
        System.out.println(System.currentTimeMillis()-start);
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.testJsonlib();//2162 2642
        main.testGson();//2403 2162
        main.testJackson();//7780 11935
        main.testFastJson();//227 271
        //bean转json性能：FastJson > Gson > Json-lib > Jackson
        //json转bean性能：FastJson > Gson > Json-lib > Jackson

    }
}
