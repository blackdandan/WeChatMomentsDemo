package com.example.blackdandan.wechatmomentsdemo.imageloader;

import java.io.IOException;
import java.io.OutputStream;

public class IOUtil {
    public static void closeQuietly(OutputStream outputStream){
        try {
            if (outputStream!=null){
                outputStream.close();
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
