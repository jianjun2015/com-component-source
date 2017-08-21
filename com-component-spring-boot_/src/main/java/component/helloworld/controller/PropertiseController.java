package component.helloworld.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangjianjun on 2017/6/16.
 */
@RestController
public class PropertiseController {

    @Value(value = "${woniu.secret}")
    private String uuid;

    @Value(value = "${woniu.number}")
    private int randomId;

    @Value(value = "${woniu.limitnumber}")
    private int limitnumber;

    @RequestMapping("/propertise")
    public Map<String,Object> Index(){

        Map<String,Object> map = new HashMap<>();
        map.put("uuid",uuid);
        map.put("randomId",randomId);
        map.put("limitnumber",limitnumber);

        return map;
    }
}
