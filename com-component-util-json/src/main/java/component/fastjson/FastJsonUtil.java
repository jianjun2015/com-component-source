package component.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import component.entity.User;

/**
 * Created by wangjianjun on 2017/6/20.
 */
public class FastJsonUtil {

    public static String bean2Json(Object obj){
        return JSON.toJSONString(obj);
    }

    public static <T> T json2Bean(String jsonStr,Class<T> objClass){
        return JSON.parseObject(jsonStr, objClass);
    }

    public static void main(String[] args) {
        FastJsonUtil jsonUtil = new FastJsonUtil();
        User user = new User();
        user.setName("zhangsanL");
        user.setAge(17);

        String bean2jsonStr = jsonUtil.bean2Json(user);
        System.out.println(bean2jsonStr);

        User json2BeanUser = jsonUtil.json2Bean(bean2jsonStr, User.class);
        System.out.println(json2BeanUser);

    }
}
