package com.example.blackdandan.wechatmomentsdemo.network;

import com.example.blackdandan.wechatmomentsdemo.mode.Tweet;
import com.example.blackdandan.wechatmomentsdemo.mode.UserInfo;
import com.example.blackdandan.wechatmomentsdemo.network.servicefactory.ServiceFactory;

import java.io.IOException;
import java.util.List;

/**
 * 可以增加线程池执行,异步通讯机制
 */
public class ServiceAgent {
    private static ServiceAgent instance = null;
    private ThoughtWorksService service;
    private ServiceAgent(){
        service = ServiceFactory.getRetrofitService();
    }
    public static ServiceAgent getInstance(){
        if (instance == null){
            synchronized (ServiceAgent.class){
                if (instance == null){
                    instance = new ServiceAgent();
                }
            }
        }
        return instance;
    }

    public UserInfo getUserInfo(String username) throws IOException {
        return service.getUserInfo(username);
    }

    public List<Tweet> getUserTweets(String username) throws IOException {
        return service.getUserTweets(username);
    }
}
