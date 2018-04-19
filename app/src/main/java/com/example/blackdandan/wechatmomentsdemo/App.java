package com.example.blackdandan.wechatmomentsdemo;

import android.app.Application;

import com.example.blackdandan.wechatmomentsdemo.imageloader.ImageLoaderConfig;
import com.example.blackdandan.wechatmomentsdemo.imageloader.MemoryCache;
import com.example.blackdandan.wechatmomentsdemo.imageloader.SimpleImageLoader;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App extends Application{
    public static final int MAX_POOL_SIZE = Runtime.getRuntime().availableProcessors() -1;
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(MAX_POOL_SIZE);

    @Override
    public void onCreate() {
        super.onCreate();
    }
    public static void execute(Runnable runnable){
        EXECUTOR.execute(runnable);
    }
}
