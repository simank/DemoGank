package com.simank.demogank.com.simank.volley;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by sx on 2016/11/1.
 */
public class MyApplication extends Application {


    private static RequestQueue queue ;
    @Override
    public void onCreate() {
        super.onCreate();

        queue = Volley.newRequestQueue(getApplicationContext());

    }


    public static RequestQueue getRequestQueue(){

        return queue;


    }
}
