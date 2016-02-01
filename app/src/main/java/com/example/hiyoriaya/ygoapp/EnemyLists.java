package com.example.hiyoriaya.ygoapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by hiyorineko on 2016/02/01.
 */
public class EnemyLists extends Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_enemylists,container,false);
    }

    @Override
    public void onStart(){
        super.onStart();
    }
}
