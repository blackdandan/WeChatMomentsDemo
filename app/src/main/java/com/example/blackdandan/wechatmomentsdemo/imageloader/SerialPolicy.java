package com.example.blackdandan.wechatmomentsdemo.imageloader;

/**
 * 先进先加载
 */
public class SerialPolicy implements LoadPolicy {
    @Override
    public int compareTo(BitmapRequest request1, BitmapRequest request2) {
        return request1.getSerialNO() - request2.getSerialNO();
    }
}