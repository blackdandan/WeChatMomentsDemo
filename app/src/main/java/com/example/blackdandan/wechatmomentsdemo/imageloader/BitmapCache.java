package com.example.blackdandan.wechatmomentsdemo.imageloader;

import android.graphics.Bitmap;

public interface BitmapCache {
    /**
     * 缓存bitmap
     */
    void put(BitmapRequest request, Bitmap bitmap);
    /**
     * 通过请求取Bitmap
     */
    Bitmap get(BitmapRequest request);
    /**
     * 移除缓存
     */
    void remove(BitmapRequest request);
}
