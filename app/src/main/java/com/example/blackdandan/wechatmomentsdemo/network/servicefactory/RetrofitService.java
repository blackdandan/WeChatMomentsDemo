package com.example.blackdandan.wechatmomentsdemo.network.servicefactory;

import com.example.blackdandan.wechatmomentsdemo.mode.Tweet;
import com.example.blackdandan.wechatmomentsdemo.mode.UserInfo;
import com.example.blackdandan.wechatmomentsdemo.network.NetworkConstant;
import com.example.blackdandan.wechatmomentsdemo.network.ThoughtWorksService;
import com.example.blackdandan.wechatmomentsdemo.network.retrofit.service.tweets.TweetsService;
import com.example.blackdandan.wechatmomentsdemo.network.retrofit.service.user.UserInfoService;

import java.io.IOException;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 使用Retrofit掉接口
 */
public class RetrofitService implements ThoughtWorksService{
    private Retrofit retrofit;
    protected RetrofitService (){
        retrofit = new Retrofit.Builder().baseUrl(NetworkConstant.THOUGHT_WORKS_BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Override
    public UserInfo getUserInfo(String username) throws IOException {
        return retrofit.create(UserInfoService.class).getUserInfo(username).execute().body();
    }

    @Override
    public List<Tweet> getUserTweets(String username) throws IOException {
        return retrofit.create(TweetsService.class).getUserTweets(username).execute().body();
    }
}
