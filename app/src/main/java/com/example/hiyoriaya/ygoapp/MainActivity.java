package com.example.hiyoriaya.ygoapp;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity{

    ViewPager viewPager;
    static Context context;
    static List<String> saves;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        saves = new ArrayList<String>();
        loadData();
        viewPager = (ViewPager)findViewById(R.id.pager);
        viewPager.setOffscreenPageLimit(3);
        viewPager.setAdapter(new MyFragmentStatePagerAdapter(getSupportFragmentManager()));
    }

    public static void openDueList(int idx){
        // インテントの生成
        context.startActivity(new Intent(context, RecordActivity.class));
    }

    public void loadData(){
        try{
            InputStream in = openFileInput("save.txt");
            BufferedReader reader =
            new BufferedReader(new InputStreamReader(in,"UTF-8"));
            String s;
            int id = 0;
            while((s = reader.readLine())!= null){
                saves.add(id+","+s);
                id++;
                }
            reader.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}