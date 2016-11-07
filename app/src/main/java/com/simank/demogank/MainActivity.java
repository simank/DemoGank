package com.simank.demogank;

import android.graphics.Color;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.simank.demogank.com.simank.JsonUtil.StringToBean;
import com.simank.demogank.com.simank.adapter.ItemOnClickListener;
import com.simank.demogank.com.simank.adapter.MyRecycleAdapter;
import com.simank.demogank.com.simank.bean.GankItem;
import com.simank.demogank.com.simank.volley.VolleyInterface;
import com.simank.demogank.com.simank.volley.VolleyRequest;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private List<GankItem> list;
    //添加swiperefreshlayout来实现recycleView的下拉刷新事件
    private SwipeRefreshLayout swipeRefreshLayout;

    private ListView left_menu_Listview;

    private DrawerLayout drawerLayout;

    private Toolbar mToolBar;

    private String[] str = new String[]{"menu01","menu02","menu03"};

    private ActionBarDrawerToggle mToggle;

    private ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        //
        //设置toolbar的标题
        mToolBar.setTitle("my toolBar");
        mToolBar.setTitleTextColor(Color.BLUE);//设置title的颜色

        setSupportActionBar(mToolBar);
        getSupportActionBar().setHomeButtonEnabled(true);//设置返回键可用
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mToggle = new ActionBarDrawerToggle(this, drawerLayout, mToolBar, R.string.open, R.string.close) {

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                Toast.makeText(MainActivity.this, "menu_main open", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                Toast.makeText(MainActivity.this, "menu_main close", Toast.LENGTH_SHORT).show();
            }
        };
        mToggle.syncState();
        drawerLayout.addDrawerListener(mToggle);


        //设置菜单列表
        mAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, str);
        left_menu_Listview.setAdapter(mAdapter);

        String url = "http://gank.io/api/data/Android/10/1";

        VolleyInterface vif = new VolleyInterface(MainActivity.this) {
            @Override
            public void OnSuccess(String sucMes) {

                list = StringToBean.parseToObjest(sucMes);

                MyRecycleAdapter mAdapter = new MyRecycleAdapter(MainActivity.this, list);

                mAdapter.setItemOnClickListener(new ItemOnClickListener() {
                    @Override
                    public void onItemClickListener(View view, int position) {
                        Toast.makeText(MainActivity.this,"test OnclickListener",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onItemLongClickListener(View view, int position) {
                        Toast.makeText(MainActivity.this,"test OnLongclickListener",Toast.LENGTH_SHORT).show();
                    }
                });
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


        //设置swipeRefreshLayout的设置
        //设置圆形动画颜色
        swipeRefreshLayout.setColorSchemeColors(Color.RED,Color.BLUE,Color.GREEN,Color.BLACK);
        //设置下拉刷新事件
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                    Toast.makeText(MainActivity.this,"下拉刷新事件",Toast.LENGTH_SHORT).show();
                    swipeRefreshLayout.setRefreshing(false);

            }
        });

    }

    private void initView() {

        //初始化控件

        recyclerView = (RecyclerView) findViewById(R.id.recycleView);

        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);

        drawerLayout = (DrawerLayout) findViewById(R.id.myDrawer);

        mToolBar = (Toolbar) findViewById(R.id.myTool);

        left_menu_Listview = (ListView) findViewById(R.id.left_menu_listview);


    }
}
