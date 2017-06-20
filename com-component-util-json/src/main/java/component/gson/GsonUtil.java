package component.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import component.entity.User;

/**
 * Created by wangjianjun on 2017/6/20.
 */
public class GsonUtil {

    public static String ban2Json(Object object){
        Gson gson = new GsonBuilder().create();
        return gson.toJson(object);
    }

    public static <T> T json2Bean(String jsonStr,Class<T> objClass){
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(jsonStr,objClass);
    }

    public static String jsobFormat(String uglyJsonStr){

        Gson gson = new GsonBuilder().create();
        JsonParser jp = new JsonParser();
        JsonElement je = jp.parse(uglyJsonStr);

        String prettyJsonStr = gson.toJson(je);

        return prettyJsonStr;
    }

    public static void main(String[] args) {
        GsonUtil jsonUtil = new GsonUtil();
        User user = new User();
        user.setName("zhangsan");
        user.setAge(17);

        String bean2jsonStr = jsonUtil.ban2Json(user);
        System.out.println(bean2jsonStr);

        User json2BeanUser = jsonUtil.json2Bean(bean2jsonStr,User.class);
        System.out.println(json2BeanUser);

        String bean2jsonPreStr = jsonUtil.jsobFormat(bean2jsonStr);
        System.out.println(bean2jsonPreStr);
    }

}
