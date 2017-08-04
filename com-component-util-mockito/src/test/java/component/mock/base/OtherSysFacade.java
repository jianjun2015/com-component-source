package component.mock.base;

/**
 * Created by wangjianjun on 2017/8/4.
 */
public class OtherSysFacade {

    public String getMsg(String msg){
        return "msg+++";
    }

    public String oper(String  type){
        return "oper+++++";
    }

    public OtherResult getResult(int arg){
        return null;
    }

    public String exceptionFun(){return "";}
}
