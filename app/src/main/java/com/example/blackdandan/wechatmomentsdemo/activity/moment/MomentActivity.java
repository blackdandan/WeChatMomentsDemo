package com.example.blackdandan.wechatmomentsdemo.activity.moment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.blackdandan.wechatmomentsdemo.R;
import com.example.blackdandan.wechatmomentsdemo.mode.Tweet;
import com.example.blackdandan.wechatmomentsdemo.mode.UserInfo;

import java.util.List;

public class MomentActivity extends AppCompatActivity implements MomentContract.View {
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;
    private MomentContract.Presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new MomentPresenter();

        initView();//初始化视图
        presenter.loadSelfInfo();
        presenter.loadSomeTweets();

    }
    private void initView(){
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("");
        toolbar.setNavigationIcon(R.drawable.ic_chevron_left);
        setSupportActionBar(toolbar);
        swipeRefreshLayout = findViewById(R.id.swipe_layout);
        recyclerView = findViewById(R.id.recycler);
    }


    @Override
    public void startLoadAnimation() {

    }

    @Override
    public void endLoadAnimation() {

    }

    @Override
    public void updateTweets(List<Tweet> tweets) {

    }

    @Override
    public void showSelfInfo(UserInfo userInfo) {

    }
}
