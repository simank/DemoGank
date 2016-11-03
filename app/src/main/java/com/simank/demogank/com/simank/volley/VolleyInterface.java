package com.simank.demogank.com.simank.volley;

import android.content.Context;

import com.android.volley.Response;
import com.android.volley.VolleyError;

/**
 *
 * Volley的两个监听器的封装对象
 *
 * Created by sx on 2016/11/1.
 */
public abstract class VolleyInterface {

    private Response.Listener<String> listener_string;

    private Response.ErrorListener errorListener;

    private Context context;

    public VolleyInterface(Context context){
        this.context = context;
    }

    public abstract void OnSuccess(String sucMes);

    public abstract  void OnEeeor(String errMes);

    public Response.Listener<String> loadStringListen(){
        listener_string = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                OnSuccess(response);
            }
        };

        return listener_string;
    }

    public Response.ErrorListener loadErrorListen(){
        errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                OnEeeor(error.toString());
            }
        };

        return errorListener;
    }




}
