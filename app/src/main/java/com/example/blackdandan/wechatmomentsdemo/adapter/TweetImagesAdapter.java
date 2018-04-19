package com.example.blackdandan.wechatmomentsdemo.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.blackdandan.wechatmomentsdemo.R;
import com.example.blackdandan.wechatmomentsdemo.imageloader.BitmapCache;
import com.example.blackdandan.wechatmomentsdemo.imageloader.BitmapRequest;
import com.example.blackdandan.wechatmomentsdemo.imageloader.ImageLoaderConfig;
import com.example.blackdandan.wechatmomentsdemo.imageloader.MemoryCache;
import com.example.blackdandan.wechatmomentsdemo.imageloader.SimpleImageLoader;
import com.example.blackdandan.wechatmomentsdemo.view.TweetImagesView;

import java.util.List;
import java.util.Map;

public class TweetImagesAdapter extends BaseAdapter {
    private List<Map<String,String>> images;
    private Context context;
    private ImageLoaderConfig imageLoaderConfig = new ImageLoaderConfig.Builder().setFaildImage(R.drawable.default_profile_image)
            .setCachePolicy(new MemoryCache())
            .setThreadCount(1).build();
    public TweetImagesAdapter(Context context){
        this.context = context;
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

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView ;
        if (convertView == null){
            imageView = new ImageView(context);
        }else {
            imageView = (ImageView) convertView;
        }
        SimpleImageLoader.getInstance(imageLoaderConfig).displayImage(imageView,images.get(position).get("url"));
        return imageView;
    }

}
