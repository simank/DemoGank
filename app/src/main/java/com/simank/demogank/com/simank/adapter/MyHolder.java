package com.simank.demogank.com.simank.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;
import com.simank.demogank.R;

/**
 * Created by sx on 2016/11/3.
 */
public class MyHolder extends RecyclerView.ViewHolder{

     NetworkImageView imageView;

     TextView title_text;

     TextView desc_text;

     TextView url_text;


    public MyHolder(View itemView) {


        super(itemView);
        imageView = (NetworkImageView) itemView.findViewById(R.id.imageMain);
        title_text = (TextView) itemView.findViewById(R.id.title_item);
        desc_text = (TextView) itemView.findViewById(R.id.desc_item);
        url_text = (TextView) itemView.findViewById(R.id.url_item);



    }
}
