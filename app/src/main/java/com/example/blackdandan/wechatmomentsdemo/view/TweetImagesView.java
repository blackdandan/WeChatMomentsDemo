package com.example.blackdandan.wechatmomentsdemo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;
import android.widget.ListAdapter;

import com.example.blackdandan.wechatmomentsdemo.R;
import com.example.blackdandan.wechatmomentsdemo.util.DensityUtil;

/**
 * 推文九宫格图片View
 */
public class TweetImagesView extends GridView {
    public TweetImagesView(Context context) {
        super(context);
        init(context);
    }
    int tweetImageHeight_9;//九张图模式下每行图的纵向长度
    int tweetImageWidth_1;//一张图的时候的宽
    int grid_width;//一张图的时候的宽
    private void init(Context context) {

        int padding = DensityUtil.dp2px(context,context.getResources().getDimension(R.dimen.base_content_padding));
        tweetImageHeight_9 = DensityUtil.dp2px(context,context.getResources().getDimension(R.dimen.tweet_width_height_9))+ padding *2;
        tweetImageWidth_1 = tweetImageHeight_9 * 3 +padding *8;//三倍的九张图模式的宽+padding
        grid_width = tweetImageHeight_9 * 3 +padding *8;//三倍的九张图模式的宽+padding

    }

    public TweetImagesView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public TweetImagesView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec,heightMeasureSpec);
        ListAdapter adapter = getAdapter();
        int height = 0;
        int width = 0;
        if (adapter == null)return;
        int count = adapter.getCount();
        System.out.println("do====images view:count:"+count);
        if (count == 0){
            height = 0;
            width = 0;
        }
        if (count == 1){
            width = grid_width;//时间原因不想算了
            height = tweetImageWidth_1;//时间原因不想算了
            this.setNumColumns(1);
        }else {
            this.setNumColumns(3);
            this.setColumnWidth(tweetImageHeight_9);
        }
        if (count>1 && count<4){
            width = grid_width;
            height = tweetImageHeight_9;
        }
        if (count>3 && count<7){
            width = grid_width;
            height = tweetImageHeight_9 *2;
        }
        if (count>6){
            width = grid_width;
            height = tweetImageHeight_9 *3;
        }
        System.out.println("do====grid width:"+width+"   grid width:"+grid_width);
        System.out.println("do====grid height:"+height +"   th:"+tweetImageHeight_9);
        widthMeasureSpec = MeasureSpec.makeMeasureSpec(width,MeasureSpec.EXACTLY);
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(height,MeasureSpec.EXACTLY);
        setMeasuredDimension(widthMeasureSpec, heightMeasureSpec);
    }
}
