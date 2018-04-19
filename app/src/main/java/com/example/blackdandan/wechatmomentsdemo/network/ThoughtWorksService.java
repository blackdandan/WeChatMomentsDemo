package com.example.blackdandan.wechatmomentsdemo.network;

import com.example.blackdandan.wechatmomentsdemo.mode.Tweet;
import com.example.blackdandan.wechatmomentsdemo.mode.UserInfo;

import java.io.IOException;
import java.util.List;


public interface ThoughtWorksService {
    UserInfo getUserInfo(String username) throws IOException;
    List<Tweet> getUserTweets(String username) throws IOException;
}
