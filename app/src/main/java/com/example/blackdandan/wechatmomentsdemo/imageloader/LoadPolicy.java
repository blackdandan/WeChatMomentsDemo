package com.example.blackdandan.wechatmomentsdemo.imageloader;

public interface LoadPolicy {
    /**
     * 两个BitmapRequest进行比较
     * @param request1
     * @param request2
     * @return 小于0，request1 < request2，大于0，request1 > request2，等于
     */
    public int compareTo(BitmapRequest request1, BitmapRequest request2);
}


