package com.example.hiyoriaya.ygoapp;

import android.content.Context;
import android.content.Intent;
import android.nfc.NfcAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 基底クラスです。
 * このActivity上で各Fragmentを遷移させます。
 * 状態保存用の変数をstaticで持たせてあります。
 *
 * メソッド
 * loadData:ローカルデータのkeys.txtを読み込んでListのkeysに格納します。
 * openDuelist:ListViewから選択されたインデックスを受け取ってRecordActivityに遷移します。
 */

public class MainActivity extends FragmentActivity{

    ViewPager viewPager;
    static Context context;
    static List<String> keys;
    static int select;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        keys = new ArrayList<String>();
        loadData();
        viewPager = (ViewPager)findViewById(R.id.pager);
        viewPager.setOffscreenPageLimit(3);
        viewPager.setAdapter(new MyFragmentStatePagerAdapter(getSupportFragmentManager()));
        viewPager.setCurrentItem(2);


    }

    public static void openDueList(int idx){
        select = idx;
        context.startActivity(new Intent(context, RecordActivity.class));
    }

    public static void loadData(){
        try{
            InputStream in = context.openFileInput("keys.txt");
            BufferedReader reader =
            new BufferedReader(new InputStreamReader(in,"UTF-8"));
            String s;
            while((s = reader.readLine())!= null){
                keys.add(s+"\n");
                }
            reader.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

}