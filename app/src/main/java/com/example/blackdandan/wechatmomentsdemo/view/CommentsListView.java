package com.example.blackdandan.wechatmomentsdemo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.blackdandan.wechatmomentsdemo.R;
import com.example.blackdandan.wechatmomentsdemo.util.DensityUtil;

/**
 * 推文的评论列表view
 */
public class CommentsListView extends ListView {
    public CommentsListView(Context context) {
        super(context);
        init(context);
    }

    public CommentsListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CommentsListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        int padding = DensityUtil.dp2px(context,getResources().getDimension(R.dimen.base_content_padding));
        commentHeight = DensityUtil.sp2px(context,getResources().getDimension(R.dimen.comment_text)) +padding;
    }

    int commentHeight;
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        ListAdapter adapter = getAdapter();
        int width = 0;
        int height = 0;
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        if (adapter == null){
            width = 0;
            height = 0;
        }else {
            int count = adapter.getCount();
            if (count == 0){
                width = 0;
                height = 0;
            }else {
                width = 800;
                height = commentHeight * count;
            }
        }
        widthMeasureSpec = MeasureSpec.makeMeasureSpec(width,widthMode);
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(height,heightMode);

       setMeasuredDimension(widthMeasureSpec,heightMeasureSpec);
    }
}
