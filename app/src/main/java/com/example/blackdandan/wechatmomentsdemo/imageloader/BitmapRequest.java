package com.example.blackdandan.wechatmomentsdemo.imageloader;

import android.widget.ImageView;

import java.lang.ref.SoftReference;

public class BitmapRequest  implements Comparable<BitmapRequest> {
    //持有imageview的软引用
    private SoftReference<ImageView> imageViewSoft;
    //图片路径
    private String imageUrl;
    //MD5的图片路径
    private String imageUriMD5;
     //下载完成监听
    public SimpleImageLoader.ImageListener imageListener;

    private  DisplayConfig displayConfig;
    public BitmapRequest(ImageView imageView,String imageUrl,DisplayConfig displayConfig,
                         SimpleImageLoader.ImageListener imageListener) {
        this.imageViewSoft=new SoftReference<ImageView>(imageView);
        //设置可见的Image的Tag，要下载的图片路径
        imageView.setTag(imageUrl);
        this.imageUrl=imageUrl;
        this.imageUriMD5= MD5Utils.getMD5String(imageUrl);
        if(displayConfig!=null)
        {
            this.displayConfig=displayConfig;
        }
        this.imageListener = imageListener;
    }

    //加载策略
    private LoadPolicy loadPolicy= SimpleImageLoader.getInstance().getConfig().getLoadPolicy();
    /**
     * 编号
     */
    private int serialNo;


    public int getSerialNO() {
        return serialNo;
    }

    public void setSerialNO(int serialNo) {
        this.serialNo = serialNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BitmapRequest that = (BitmapRequest) o;

        if (serialNo != that.serialNo) return false;
        return loadPolicy != null ? loadPolicy.equals(that.loadPolicy) : that.loadPolicy == null;

    }

    @Override
    public int hashCode() {
        int result = loadPolicy != null ? loadPolicy.hashCode() : 0;
        result = 31 * result + serialNo;
        return result;
    }
    public ImageView getImageView()
    {
        return  imageViewSoft.get();
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getImageUriMD5() {
        return imageUriMD5;
    }

    public DisplayConfig getDisplayConfig() {
        return displayConfig;
    }

    public LoadPolicy getLoadPolicy() {
        return loadPolicy;
    }

    @Override
    public int compareTo(BitmapRequest o) {
        return loadPolicy.compareTo(o,this);
    }
}