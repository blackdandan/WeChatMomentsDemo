package com.example.blackdandan.wechatmomentsdemo.imageloader;

import android.widget.ImageView;

class ImageViewHelper {
    public static int getImageViewWidth(ImageView imageView) {
        return imageView==null?0:imageView.getWidth();
    }

    public static int getImageViewHeight(ImageView imageView) {
        return imageView==null?0:imageView.getHeight();
    }
}
