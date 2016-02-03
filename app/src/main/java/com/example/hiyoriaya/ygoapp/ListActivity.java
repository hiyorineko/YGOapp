package com.example.hiyoriaya.ygoapp;

import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class ListActivity extends FragmentActivity{

    static ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_list);
        viewPager = (ViewPager)findViewById(R.id.pager);
        viewPager.setOffscreenPageLimit(3);
        viewPager.setAdapter(new ListFragmentStatePagerAdapter(getSupportFragmentManager()));
    }
}