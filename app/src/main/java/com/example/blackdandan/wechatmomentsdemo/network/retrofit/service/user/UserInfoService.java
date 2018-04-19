package com.example.blackdandan.wechatmomentsdemo.network.retrofit.service.user;

import com.example.blackdandan.wechatmomentsdemo.mode.UserInfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface UserInfoService {
    @GET("/user/{username}")
    Call<UserInfo> getUserInfo(@Path("username") String username);
}
