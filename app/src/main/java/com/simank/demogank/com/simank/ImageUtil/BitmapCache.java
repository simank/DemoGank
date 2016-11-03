package com.simank.demogank.com.simank.ImageUtil;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

import com.android.volley.toolbox.ImageLoader;

/**
 *
 * 图片的缓存
 * Created by sx on 2016/11/3.
 */
public class BitmapCache implements ImageLoader.ImageCache {


    private LruCache<String,Bitmap> mLruCache;

    private int max = 10*1024*1024;


    public BitmapCache() {
        mLruCache = new LruCache<String,Bitmap>(max){
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getRowBytes()*value.getHeight();
            }
        };
    }

    @Override
    public Bitmap getBitmap(String url) {


        return mLruCache.get(url);
    }

    @Override
    public void putBitmap(String url, Bitmap bitmap) {
            mLruCache.put(url,bitmap);
    }
}
