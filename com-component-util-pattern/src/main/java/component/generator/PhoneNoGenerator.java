package component.generator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangjianjun on 2017/7/10.
 */
public class PhoneNoGenerator {



    private static String[] telFirst="134,135,136,137,138,139,150,151,152,157,158,159,130,131,132,155,156,133,153,189,188,170,171".split(",");

    private static int getNum(int start,int end) {
        return (int)(Math.random()*(end-start+1)+start);
    }

    private static String getTel() {
        int index=getNum(0,telFirst.length-1);
        String first=telFirst[index];
        String second=String.valueOf(getNum(0,9999)+10000).substring(1);
        String thrid=String.valueOf(getNum(0,9999)+10000).substring(1);

        return first+second+thrid;
    }

    /**
     * 生成手机号
     * @return
     */
    public static String getPhoneNo(){
        return getTel();
    }

    /**
     * 批量生成手机号
     * @param howMany
     * @return
     */
    public static List getPhoneNos(int howMany){

        List list = new ArrayList();
        for (int i=0;i<howMany;i++){
            list.add(getTel());
        }

        return list;
    }

}
