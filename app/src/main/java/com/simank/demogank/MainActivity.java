package com.simank.demogank;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.simank.demogank.com.simank.JsonUtil.StringToBean;
import com.simank.demogank.com.simank.adapter.MyRecycleAdapter;
import com.simank.demogank.com.simank.bean.GankItem;
import com.simank.demogank.com.simank.volley.VolleyInterface;
import com.simank.demogank.com.simank.volley.VolleyRequest;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    private RecyclerView recyclerView;

    private List<GankItem> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        String url = "http://gank.io/api/data/Android/10/1";

        VolleyInterface vif = new VolleyInterface(MainActivity.this) {
            @Override
            public void OnSuccess(String sucMes) {

                list = StringToBean.parseToObjest(sucMes);

                MyRecycleAdapter mAdapter = new MyRecycleAdapter(MainActivity.this, list);

                recyclerView.setAdapter(mAdapter);
            }

            @Override
            public void OnEeeor(String errMes) {
                Toast.makeText(MainActivity.this, errMes, Toast.LENGTH_SHORT).show();

            }
        };

        VolleyRequest.VolleyRequest_GET(url, "GET_MES", vif);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    private void initView() {

        //初始化控件
        textView = (TextView) findViewById(R.id.textView);
        recyclerView = (RecyclerView) findViewById(R.id.recycleView);

    }
}
