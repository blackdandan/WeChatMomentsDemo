package com.example.blackdandan.wechatmomentsdemo.imageloader;

import android.graphics.Bitmap;
import android.widget.ImageView;

public class SimpleImageLoader {
    //配置
    private ImageLoaderConfig config;
    //请求队列
    private RequestQueue mRequestQueue;
    //单例对象
    private static volatile  SimpleImageLoader mInstance;
    private SimpleImageLoader()
    {

    }
    private SimpleImageLoader(ImageLoaderConfig imageLoaderConfig)
    {
        this.config=imageLoaderConfig;
        mRequestQueue=new RequestQueue(config.getThreadCount());
        //开启请求队列
        mRequestQueue.start();
    }

    /**
     * 获取单例方法
     * 第一次调用
     * @param config
     * @return
     */
    public  static SimpleImageLoader getInstance(ImageLoaderConfig config)
    {
        if(mInstance==null)
        {
            synchronized (SimpleImageLoader.class)
            {
                if(mInstance==null)
                {
                    mInstance=new SimpleImageLoader(config);
                }
            }

        }
        return  mInstance;
    }

    /**
     * 第二次获取单例
     * @return
     */
    public static SimpleImageLoader getInstance()
    {
        if(mInstance==null)
        {
            throw  new UnsupportedOperationException("没有初始化");
        }
        return mInstance;
    }

    /**
     *暴露获取图片
     * @param imageView
     * @param uri  http:   file 开头
     */
    public  void displayImage(ImageView imageView,String uri)
    {
        displayImage(imageView,uri,null,null);
    }

    /**
     * 重载
     * @param imageView
     * @param uri
     * @param displayConfig
     * @param imageListener
     */
    public  void displayImage(ImageView imageView, String uri
            , DisplayConfig displayConfig,ImageListener imageListener)
    {
        //实例化一个请求
        BitmapRequest bitmapRequest=new BitmapRequest(imageView,uri,displayConfig,imageListener);
        //添加到队列里面
        mRequestQueue.addRequest(bitmapRequest);
    }
    public static  interface ImageListener{
        /**
         *
         * @param imageView
         * @param bitmap
         * @param uri
         */
        void onComplete(ImageView imageView, Bitmap bitmap, String uri);
    }

    /**
     * 拿到全局配置
     * @return
     */
    public ImageLoaderConfig getConfig() {
        return config;
    }
}