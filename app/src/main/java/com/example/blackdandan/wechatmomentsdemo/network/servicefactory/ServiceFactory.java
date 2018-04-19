package com.example.blackdandan.wechatmomentsdemo.network.servicefactory;

import com.example.blackdandan.wechatmomentsdemo.network.ThoughtWorksService;

/**
 * 网络工具解耦
 */
public class ServiceFactory {
    public static ThoughtWorksService getRetrofitService(){
        return new RetrofitService();
    }
}
