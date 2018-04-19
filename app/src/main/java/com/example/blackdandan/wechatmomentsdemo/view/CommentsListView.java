package com.example.blackdandan.wechatmomentsdemo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListAdapter;
import android.widget.ListView;

public class CommentsListView extends ListView {
    public CommentsListView(Context context) {
        super(context);
    }

    public CommentsListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CommentsListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        ListAdapter adapter = getAdapter();
        if (adapter == null){
            widthMeasureSpec = 0;
            heightMeasureSpec = 0;
        }
        int count = adapter.getCount();
        if (count == 0){
            widthMeasureSpec = 0;
            heightMeasureSpec = 0;
        }else {
            widthMeasureSpec = 800;
            heightMeasureSpec = 40 * count;
        }
       setMeasuredDimension(widthMeasureSpec,heightMeasureSpec);
    }
}
