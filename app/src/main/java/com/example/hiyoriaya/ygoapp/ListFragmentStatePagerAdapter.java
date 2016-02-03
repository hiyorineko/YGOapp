package com.example.hiyoriaya.ygoapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by hiyorineko on 2016/02/03.
 */
public class ListFragmentStatePagerAdapter extends FragmentStatePagerAdapter {
    public ListFragmentStatePagerAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int i){
        switch(i){
            case 0:
                return new EnemyLists();
            case 1:
                return new RecordFragment();
        }
        return null;
    }

    @Override
    public int getCount(){
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Tools";
            case 1:
                return "Counter";
        }
        return null;
    }
}
