package com.example.hiyoriaya.ygoapp;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by hiyorineko on 2016/02/01.
 */
public class RecordFragment extends Fragment {

    /**
     * 対戦相手名:デッキ名:使用デッキ:勝率
     *
     */
    static String[][][] enemydata;


    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_record,container,false);
    }

    @Override
    public void onStart(){
        super.onStart();
        readSave();
    }

    public void readSave(){

    }
}
