package com.example.hiyoriaya.ygoapp;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        WindowManager windowManager = getWindowManager();
        Display display = windowManager.getDefaultDisplay();

        if(display.getHeight()<display.getWidth()){
            CalcFragment fragment1 = new CalcFragment();
            fragmentTransaction.replace(android.R.id.content,fragment1);
        }else{
            RecordFragment fragment2 = new RecordFragment();
            fragmentTransaction.replace(android.R.id.content,fragment2);
        }
        fragmentTransaction.commit();
    }
}
