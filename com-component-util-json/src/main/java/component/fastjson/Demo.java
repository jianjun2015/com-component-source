package component.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * Created by wangjianjun on 2017/11/23.
 */
public class Demo {

    public static void main(String[] args) {

        String partnerInfoStrs = "[{\"partnerId\":\"张三\"，\"partnerRole\":\"付款方\"},{\"partnerId\":\"恒大普惠\"，\"partnerRole\":\"收款方\"}]";

        partnerInfoStrs = "[{'partnerId':'张三','partnerRole':'付款方'},{'partnerId':'恒大普惠','partnerRole':'收款方'}]";

//        partnerInfoStrs = "{'partnerId':'张三','partnerRole':'付款方'}";

        //{"age":17,"name":"zhangsanL"}

//        PartnerUnit partnerUnit = JSON.parseObject(partnerInfoStrs, PartnerUnit.class);
//
//        System.out.println(partnerUnit);


//        List<PartnerUnit> jsonArray = JSONArray.parseArray(partnerInfoStrs,PartnerUnit.class);
//
//        System.out.println(jsonArray);

        try {
            List<PartnerUnit> jsonArray = JSONArray.parseArray(partnerInfoStrs,PartnerUnit.class);

            System.out.println(jsonArray);
        }catch (JSONException e){
            System.out.println(e.getMessage());
        }

    }
}
class PartnerUnit{
    private String partnerId;
    private String partnerRole;

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public String getPartnerRole() {
        return partnerRole;
    }

    public void setPartnerRole(String partnerRole) {
        this.partnerRole = partnerRole;
    }

    @Override
    public String toString() {
        return "PartnerUnit{" +
                "partnerId='" + partnerId + '\'' +
                ", partnerRole='" + partnerRole + '\'' +
                '}';
    }
}

