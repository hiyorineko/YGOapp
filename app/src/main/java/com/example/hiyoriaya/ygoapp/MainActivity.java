package com.example.hiyoriaya.ygoapp;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.WindowManager;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnListChangeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onListSelectedChanged(String s) {
        FragmentManager fragmentManager = getFragmentManager();
        ContentFragment cf1 =(ContentFragment)fragmentManager.findFragmentByTag("contentFragment");
        if(cf1==null || !cf1.isVisible()){
            Toast.makeText(getBaseContext(),s,Toast.LENGTH_SHORT).show();
        }else{
            cf1.setText(s);
        }
    }


}
