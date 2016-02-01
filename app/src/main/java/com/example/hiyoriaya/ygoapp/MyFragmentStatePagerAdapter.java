package com.example.hiyoriaya.ygoapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by hiyorineko on 2016/02/01.
 */
public class MyFragmentStatePagerAdapter extends FragmentStatePagerAdapter {
    public MyFragmentStatePagerAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int i){
        switch(i){
            case 0:
                return new CalcFragment();
            case 1:
                return new RecordFragment();
            case 2:
                return new ListFragment();
        }
        return null;
    }

    @Override
    public int getCount(){
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position){
        return "Page"+position;
    }
}
