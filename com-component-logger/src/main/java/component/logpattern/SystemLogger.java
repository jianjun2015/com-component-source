package component.logpattern;


import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by wangjianjun on 2017/6/19.
 */
public class SystemLogger {

    protected Logger logger;

    public SystemLogger(){
        logger = LoggerFactory.getLogger(this.getClass());
    }

    public void debugInfo(String methodName,Object req,Object resp){

        StringBuilder sb = new StringBuilder();
        sb.append("###接口名:" + methodName).append(System.lineSeparator());
        sb.append("####请求数据:").append(JSON.toJSONString(req));
        sb.append(System.lineSeparator());
        sb.append("####响应数据:").append(resp == null ? "" : JSON.toJSONString(resp));
        sb.append(System.lineSeparator());
        logger.debug(sb.toString());
    }
}
