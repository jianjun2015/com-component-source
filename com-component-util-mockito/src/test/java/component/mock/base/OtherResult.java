package component.mock.base;

/**
 * Created by wangjianjun on 2017/8/4.
 */
public class OtherResult {

    public String name;
    public String passwd;

    public OtherResult(String name, String passwd) {
        this.name = name;
        this.passwd = passwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    @Override
    public String toString() {
        return "OtherResult{" +
                "name='" + name + '\'' +
                ", passwd='" + passwd + '\'' +
                '}';
    }
}
