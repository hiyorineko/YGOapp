package com.example.hiyoriaya.ygoapp;

import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.widget.Toast;
import android.support.v4.app.FragmentActivity;

public class MainActivity extends FragmentActivity implements OnListChangeListener {

    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager)findViewById(R.id.pager);
        viewPager.setOffscreenPageLimit(2);
        viewPager.setAdapter(new MyFragmentStatePagerAdapter(getSupportFragmentManager()));
    }

    @Override
    public void onListSelectedChanged(String s) {
        android.app.FragmentManager fragmentManager = getFragmentManager();
        ContentFragment cf1 =(ContentFragment)fragmentManager.findFragmentByTag("contentFragment");
        if(cf1==null || !cf1.isVisible()){
            Toast.makeText(getBaseContext(),s,Toast.LENGTH_SHORT).show();
        }else{
            cf1.setText(s);
        }
    }
}