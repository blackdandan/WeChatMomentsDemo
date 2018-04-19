package com.example.blackdandan.wechatmomentsdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.blackdandan.wechatmomentsdemo.mode.Tweet;
import com.example.blackdandan.wechatmomentsdemo.network.ThoughtWorksService;
import com.example.blackdandan.wechatmomentsdemo.network.servicefactory.ServiceFactory;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ThoughtWorksService service = ServiceFactory.getRetrofitService();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("do===="+service.getUserInfo("jsmith"));
                    List<Tweet> tweets =  service.getUserTweets("jsmith");
                    System.out.println("do===="+tweets.size());
                    Tweet tweet = tweets.get(0);
                    System.out.println("do===="+tweet.getContent());
                    System.out.println("do===="+tweet.getSender().toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
