package com.example.blackdandan.wechatmomentsdemo.activity.moment;

import com.example.blackdandan.wechatmomentsdemo.activity.BasePresenter;
import com.example.blackdandan.wechatmomentsdemo.activity.BaseView;
import com.example.blackdandan.wechatmomentsdemo.mode.Tweet;
import com.example.blackdandan.wechatmomentsdemo.mode.UserInfo;

import java.util.List;

public final class MomentContract {
    private MomentContract(){}
    public interface Presenter extends BasePresenter {
        void loadSelfInfo();//加载自己的信息
        void loadSomeTweets();//加载合适数量的推文

    }
    public interface View extends BaseView {
        void startLoadAnimation();//显示加载动画
        void endLoadAnimation();//结束加载动画
        void updateTweets(List<Tweet> tweets);//刷新推文
        void showSelfInfo(UserInfo userInfo);//展示自己的信息
    }

}
