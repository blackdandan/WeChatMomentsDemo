package com.example.blackdandan.wechatmomentsdemo.imageloader;

/**
 * 后进先加载
 */
public class ReversePolicy implements LoadPolicy {
    @Override
    public int compareTo(BitmapRequest request1, BitmapRequest request2) {
        return request2.getSerialNO() - request1.getSerialNO();
    }

}