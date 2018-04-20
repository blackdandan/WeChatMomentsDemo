package com.example.blackdandan.wechatmomentsdemo.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.blackdandan.wechatmomentsdemo.R;
import com.example.blackdandan.wechatmomentsdemo.imageloader.ImageLoaderConfig;
import com.example.blackdandan.wechatmomentsdemo.imageloader.MemoryCache;
import com.example.blackdandan.wechatmomentsdemo.imageloader.SimpleImageLoader;
import com.example.blackdandan.wechatmomentsdemo.util.DensityUtil;

import java.util.List;
import java.util.Map;

import static com.example.blackdandan.wechatmomentsdemo.App.MAX_POOL_SIZE;

public class TweetImagesAdapter extends BaseAdapter {
    private List<Map<String,String>> images;
    private Context context;
    private ImageLoaderConfig imageLoaderConfig = new ImageLoaderConfig.Builder().setFaildImage(R.drawable.default_profile_image)
            .setCachePolicy(new MemoryCache())
            .setThreadCount(MAX_POOL_SIZE).build();
    public TweetImagesAdapter(Context context){
        this.context = context;
        tweetImageWidth_9 = DensityUtil.dp2px(context,55);
        int padding = DensityUtil.dp2px(context,context.getResources().getDimension(R.dimen.base_content_padding));
        tweetImageWidth_1 = tweetImageWidth_9 * 3 +padding *2;//三倍的九张图模式的宽+padding
        layoutParams_1 = new AbsListView.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                tweetImageWidth_1);
        layoutParams_9 = new AbsListView.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                tweetImageWidth_9);
    }

    public void setImages(List<Map<String,String>> images) {
        this.images = images;
    }

    @Override
    public int getCount() {
        return images == null?0:images.size();
    }

    @Override
    public Object getItem(int position) {
        if (images == null)return null;
        return images.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    int tweetImageWidth_9;//九张图模式下每张图的长宽
    int tweetImageWidth_1;//一张图的时候的宽

    AbsListView.LayoutParams layoutParams_9;
    AbsListView.LayoutParams layoutParams_1;
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        System.out.println("do====images adapter:"+getCount());
        ImageView imageView ;
        if (convertView == null){
            imageView = new ImageView(context);
            imageView.setImageResource(R.drawable.ic_image_default);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setBackgroundColor(context.getResources().getColor(R.color.color_white));
            if (getCount()==1){
                imageView.setLayoutParams(layoutParams_1);
            }else {
                imageView.setLayoutParams(layoutParams_9);
            }


        }else {
            imageView = (ImageView) convertView;
        }
//        SimpleImageLoader.getInstance(imageLoaderConfig).displayImage(imageView,images.get(position).get("url"));
        System.out.println("do====image:"+images.get(position).get("url"));
        Glide.with(context)
                .load(images.get(position).get("url")).into(imageView);
        return imageView;
    }

}
