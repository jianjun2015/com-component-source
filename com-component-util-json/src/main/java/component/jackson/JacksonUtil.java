package component.jackson;

import component.entity.User;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.io.StringWriter;

/**
 * Created by wangjianjun on 2017/6/20.
 */
public class JacksonUtil {

    public static String bean2Json(Object object) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        StringWriter sw = new StringWriter();
        JsonGenerator gen = new JsonFactory().createJsonGenerator(sw);

        mapper.writeValue(gen,object);
        gen.close();
        return sw.toString();
    }

    public static <T> T json2Bean(String jsonStr,Class<T> objClass) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonStr,objClass);
    }

    public static void main(String[] args) throws IOException {
        JacksonUtil jsonUtil = new JacksonUtil();
        User user = new User();
        user.setName("zhangsan");
        user.setAge(17);

        String bean2jsonStr = jsonUtil.bean2Json(user);
        System.out.println(bean2jsonStr);

        User json2BeanUser = jsonUtil.json2Bean(bean2jsonStr,User.class);
        System.out.println(json2BeanUser);


    }
}
