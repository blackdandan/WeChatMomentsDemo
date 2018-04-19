package com.example.blackdandan.wechatmomentsdemo.activity.moment;

import android.os.Handler;
import android.os.Message;

import com.example.blackdandan.wechatmomentsdemo.App;
import com.example.blackdandan.wechatmomentsdemo.mode.Tweet;
import com.example.blackdandan.wechatmomentsdemo.mode.UserInfo;
import com.example.blackdandan.wechatmomentsdemo.network.ServiceAgent;
import com.example.blackdandan.wechatmomentsdemo.network.ThoughtWorksService;

import java.io.IOException;
import java.util.List;

public class MomentPresenter implements MomentContract.Presenter {
    private static final String USER_NAME = "jsmith";
    private MomentContract.View view;

    private static final int ERROR = -1;//异常
    private static final int SELF_INFO = 0;//加载自己ok
    private static  final int TWEETS = 1;//加载推文ok
    private UserInfo selfInfo;//自己的信息;
    private List<Tweet> tweets;//推文
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case ERROR:
                    //TODO
                    break;
                case SELF_INFO://刷新自己
                    view.showSelfInfo(selfInfo);
                    break;
                case TWEETS://刷新推文
                    view.updateTweets(tweets);
                    break;
            }
            super.handleMessage(msg);
        }
    };
    public MomentPresenter(MomentContract.View view){
        this.view = view;
    }
    @Override
    public void loadSelfInfo() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    selfInfo = ServiceAgent.getInstance().getUserInfo(USER_NAME);
                    System.out.println("do====MomentPresenter.selfInfo:"+selfInfo.toString());
                    handler.sendEmptyMessage(SELF_INFO);
                } catch (IOException e) {
                    handler.sendEmptyMessage(ERROR);
                    e.printStackTrace();
                }
            }
        };
        App.execute(runnable);
    }

    @Override
    public void loadSomeTweets() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    tweets = ServiceAgent.getInstance().getUserTweets(USER_NAME);
                    handler.sendEmptyMessage(TWEETS);
                } catch (IOException e) {
                    handler.sendEmptyMessage(ERROR);
                    e.printStackTrace();
                }
            }
        };
        App.execute(runnable);
    }
}
