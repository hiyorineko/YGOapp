package com.example.hiyoriaya.ygoapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

/**
 * Created by hiyorineko on 2016/02/01.
 */
public class EnemyLists extends Fragment implements View.OnClickListener{

    ListView enemyList;
    Button addDuelist;

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_enemylists,container,false);
        findView(v);
        return v;
    }

    @Override
    public void onStart(){
        super.onStart();
    }

    public void findView(View v){
        enemyList = (ListView)v.findViewById(R.id.enemyLists);
        enemyList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //RecordFragmentに飛ぶ

            }
        });
        addDuelist = (Button)v.findViewById(R.id.addduelist);
        addDuelist.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }
}
