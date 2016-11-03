package com.simank.demogank.com.simank.volley;

import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;

/**
 * Volley的二次封装
 * Created by sx on 2016/11/1.
 */
public class VolleyRequest {

    private  static  StringRequest stringRequest;

    public static void VolleyRequest_GET(String url,String tag,VolleyInterface vif){
        MyApplication.getRequestQueue().cancelAll(tag);
        stringRequest = new StringRequest(Request.Method.GET,url,vif.loadStringListen(),vif.loadErrorListen());

        stringRequest.setTag(tag);
        MyApplication.getRequestQueue().add(stringRequest);



    }


}
