package com.example.blackdandan.wechatmomentsdemo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Adapter;
import android.widget.GridView;
import android.widget.ListAdapter;

import java.util.List;

public class TweetImagesView extends GridView {
    public TweetImagesView(Context context) {
        super(context);
    }
    public TweetImagesView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TweetImagesView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec,heightMeasureSpec);
//        ListAdapter adapter = getAdapter();
//        if (adapter == null)return;
//        int count = adapter.getCount();
//        if (count == 0){
//            widthMeasureSpec = 0;
//            heightMeasureSpec = 0;
//        }
//        if (count == 1){
//            widthMeasureSpec = 600;//时间原因不想算了
//            heightMeasureSpec = 300;//时间原因不想算了
//        }
//        if (count>1 && count<4){
//            widthMeasureSpec = 600;
//            heightMeasureSpec = 150;
//        }
//        if (count>3 && count<7){
//            widthMeasureSpec = 600;
//            heightMeasureSpec = 300;
//        }
//        if (count>6){
//            widthMeasureSpec = 600;
//            heightMeasureSpec = 450;
//        }
//        setMeasuredDimension(widthMeasureSpec, heightMeasureSpec);
    }
}
