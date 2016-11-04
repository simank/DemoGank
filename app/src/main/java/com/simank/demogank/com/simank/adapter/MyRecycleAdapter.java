package com.simank.demogank.com.simank.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.toolbox.ImageLoader;
import com.simank.demogank.R;
import com.simank.demogank.com.simank.ImageUtil.BitmapCache;
import com.simank.demogank.com.simank.bean.GankItem;
import com.simank.demogank.com.simank.volley.MyApplication;

import java.util.List;

/**
 * Created by sx on 2016/11/3.
 */
public class MyRecycleAdapter extends RecyclerView.Adapter<MyHolder>{

    private Context mContext;

    private List<GankItem> list;

    private LayoutInflater mInflater;

    private ImageLoader loader;

    private ItemOnClickListener itemOnClickListener;

    public MyRecycleAdapter(Context context, List<GankItem> list){
        this.mContext = context;
        this.list = list;
        mInflater = LayoutInflater.from(context);
        loader = new ImageLoader(MyApplication.getRequestQueue(), new BitmapCache());

    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, final int viewType) {

        final View view = mInflater.inflate(R.layout.item_layout,parent,false);
        MyHolder holder = new MyHolder(view);
        if(itemOnClickListener != null){
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemOnClickListener.onItemClickListener(v,viewType);
                }
            });


            view.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    itemOnClickListener.onItemLongClickListener(v,viewType);

                    return false;
                }
            });
        }





        return holder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {

        holder.title_text.setText(list.get(position).getType());
        holder.imageView.setDefaultImageResId(R.mipmap.ic_launcher);
        holder.imageView.setErrorImageResId(R.mipmap.ic_launcher);
        if(list.get(position).getImages() != null){
            holder.imageView.setImageUrl(list.get(position).getImages()+"?imageView2/0/w/100",loader);
        }
        holder.url_text.setText(list.get(position).getUrl());
        holder.desc_text.setText(list.get(position).getDesc());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setItemOnClickListener(ItemOnClickListener listener){
        this.itemOnClickListener = listener;

    }



}
