package com.example.hiyoriaya.ygoapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by hiyorineko on 2016/02/05.
 */
public class ThemeList extends Fragment{

    View v;

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
        v = inflater.inflate(R.layout.fragment_profile,container,false);
        return v;
    }

    @Override
    public void onStart(){
        super.onStart();
    }


}
