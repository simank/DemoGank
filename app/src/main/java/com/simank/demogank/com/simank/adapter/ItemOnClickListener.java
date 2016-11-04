package com.simank.demogank.com.simank.adapter;

import android.view.View;

/**
 *
 * recycleView的监听器
 * Created by sx on 2016/11/4.
 */
public interface ItemOnClickListener {


    void onItemClickListener(View view, int position);

     void onItemLongClickListener(View view,int position);

}
