package com.simank.demogank.com.simank.JsonUtil;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.simank.demogank.com.simank.bean.GankItem;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 将results部分转化为Bean对象
 * Created by sx on 2016/11/3.
 */
public class StringToBean {


    public StringToBean() {

    }

    public static List<GankItem> parseToObjest(String jsonString){

        List<GankItem> list;

        JSONObject object = JSON.parseObject(jsonString);
        String ArrayString = object.getString("results");

        list = new ArrayList<GankItem>(JSON.parseArray(ArrayString,GankItem.class));

        for(int i = 0;i<list.size();i++){
            if(list.get(i).getImages()!= null){
                String temp = list.get(i).getImages().substring(2,list.get(i).getImages().length()-2);
                list.get(i).setImages(temp);
            }
        }


        return list;
    }


}
