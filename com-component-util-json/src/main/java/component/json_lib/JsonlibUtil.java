package component.json_lib;

import component.entity.User;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangjianjun on 2017/6/20.
 */
public class JsonlibUtil {

    public String bean2Json(Object object){
        JSONObject jsonObject = JSONObject.fromObject(object);
        return jsonObject.toString();
    }

    public <T> T json2Bean(String jsonStr,Class<T> objClass){
        return (T)JSONObject.toBean(JSONObject.fromObject(jsonStr),objClass);
    }

    public List bean2JsonArr(Object obj){
        JSONArray jsonArr = JSONArray.fromObject(obj);

        List list = new ArrayList();
        for (Object json : jsonArr) {
            String jsonStr = json.toString();
            if(this.isString(jsonStr)){
                list.add(jsonStr);
            }
            if(this.isJson(jsonStr)){
                list.add(this.bean2Json(jsonStr.toString()));
            }
            if(this.isJsonArray(jsonStr)){
                list.add(this.bean2JsonArr(jsonStr.toString()));
            }
        }
        return list;
    }

    public boolean isJson(String s) {
        boolean flag = true;
        try {
            JSONObject.fromObject(s);
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    public boolean isJsonArray(String s) {
        boolean flag = true;
        try {
            JSONArray.fromObject(s);
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    public boolean isString(String s) {
        return !this.isJson(s) && !this.isJsonArray(s);
    }

    public static void main(String[] args) {
        JsonlibUtil jsonUtil = new JsonlibUtil();
        User user = new User();
        user.setName("zhangsan");
        user.setAge(17);

        String bean2jsonStr = jsonUtil.bean2Json(user);
        System.out.println(bean2jsonStr);

        User json2BeanUser = jsonUtil.json2Bean(bean2jsonStr,User.class);
        System.out.println(json2BeanUser);

        List<User> json2BeanUserList = jsonUtil.bean2JsonArr(user);
        System.out.println(json2BeanUserList);

    }
}
