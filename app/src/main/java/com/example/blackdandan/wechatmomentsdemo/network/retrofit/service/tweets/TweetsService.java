package com.example.blackdandan.wechatmomentsdemo.network.retrofit.service.tweets;

import com.example.blackdandan.wechatmomentsdemo.mode.Tweet;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface TweetsService {
    @GET("/user/{username}/tweets")
    Call<List<Tweet>> getUserTweets(@Path("username") String username);
}
