package com.example.hiyoriaya.ygoapp;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hiyorineko on 2016/02/01.
 */
public class EnemyLists extends Fragment implements View.OnClickListener{
    private static String[] lists;
    static ListView enemyList;
    Button addDuelist;
    List<String> enemynames;/** id,Name.duelkaisuu */

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_enemylists,container,false);
        findView(v,container);
        loaddata();
        return v;
    }

    @Override
    public void onStart(){
        super.onStart();
    }

    public void findView(View v, final ViewGroup container){
        lists = new String[3];
        lists[0] = "a";
        lists[1] = "b";
        lists[2] = "c";
        enemyList = (ListView)v.findViewById(R.id.enemyLists);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(v.getContext(),android.R.layout.simple_expandable_list_item_1,lists);
        enemyList.setAdapter(arrayAdapter);

        enemyList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //リスト選択時の
            }
        });


        addDuelist = (Button)v.findViewById(R.id.addduelist);
        addDuelist.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //EnemyListを追加するFragment or 処理
        DialogFragment newFragment = new AddDuelistDialog();
        newFragment.show(getFragmentManager(),"");

    }

    public void loaddata(){
        //保存されている敵データを読み込む。
    }
}
