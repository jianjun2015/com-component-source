package com.dubbo.demo.facade;

import java.util.List;

/**
 * Created by wangjianjun on 2017/7/20.
 */
public interface DemoService {

    String showMsg(String msg);

    List<String> getPermissions(Long id);
}
