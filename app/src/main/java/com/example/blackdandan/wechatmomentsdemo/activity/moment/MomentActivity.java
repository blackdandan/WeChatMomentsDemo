package com.example.blackdandan.wechatmomentsdemo.activity.moment;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import com.example.blackdandan.wechatmomentsdemo.R;
import com.example.blackdandan.wechatmomentsdemo.adapter.TweetListAdapter;
import com.example.blackdandan.wechatmomentsdemo.mode.Tweet;
import com.example.blackdandan.wechatmomentsdemo.mode.UserInfo;

import java.util.List;

public class MomentActivity extends AppCompatActivity implements MomentContract.View {
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;
    TweetListAdapter adapter;
    private MomentContract.Presenter presenter;
    LinearLayoutManager layoutManager;
    SwipeRefreshLayout.OnRefreshListener onRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            startLoadAnimation();
            presenter.loadFirstFiveTweets();
            endLoadAnimation();
        }
    };
    RecyclerView.OnScrollListener onScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            int lastVisibleitemPosition = layoutManager.findLastVisibleItemPosition();
            if (lastVisibleitemPosition+1 == adapter.getItemCount()){
                recyclerView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        presenter.loadFiveTweets();
                    }
                },1000);

            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new MomentPresenter(this);

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
        adapter = new TweetListAdapter(this);
        recyclerView.setAdapter(adapter);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addOnScrollListener(onScrollListener);
        swipeRefreshLayout.setOnRefreshListener(onRefreshListener);
        swipeRefreshLayout.setOnChildScrollUpCallback(new SwipeRefreshLayout.OnChildScrollUpCallback() {
            @Override
            public boolean canChildScrollUp(@NonNull SwipeRefreshLayout parent, @Nullable View child) {
                System.out.println("do====onChildScrollUp");
                return false;
            }
        });
    }


    @Override
    public void startLoadAnimation() {
        swipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void endLoadAnimation() {
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void updateTweets(List<Tweet> tweets) {
        System.out.println("do====MomentActivity.updateTweets");
        adapter.setTweets(tweets);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showSelfInfo(UserInfo userInfo) {
        System.out.println("do====MomentActivity.showSelfInfo:"+userInfo.getProfile_image());
        adapter.setSelfInfo(userInfo);
        adapter.notifyDataSetChanged();
    }
}
