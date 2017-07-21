package com.dubbo.demo.facade.impl;

import com.dubbo.demo.facade.DemoService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangjianjun on 2017/7/20.
 */
@Service("DemoService")
public class DemoServiceImpl implements DemoService {
    @Override
    public String showMsg(String msg) {
        StringBuilder sb = new StringBuilder("The msg is:");
        sb.append(msg);
        System.out.println(sb.toString());
        return sb.toString();
    }

    @Override
    public List<String> getPermissions(Long id) {

        List<String> demo = new ArrayList<String>();
        demo.add(String.format("Permission_%d", id - 1));
        demo.add(String.format("Permission_%d", id));
        demo.add(String.format("Permission_%d", id + 1));
        return demo;
    }
}
