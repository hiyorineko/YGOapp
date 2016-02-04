package com.example.hiyoriaya.ygoapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by hiyorineko on 2016/02/01.
 * ViewPagerの継承クラスです。
 * MainActivity上で呼ばれます。
 * ここを編集することでFragmentを増やすことができます。
 */
public class MyFragmentStatePagerAdapter extends FragmentStatePagerAdapter {
    public MyFragmentStatePagerAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int i){
        switch(i){
            case 0:
                return new ProfileFragment();
            case 1:
                return new ToolsFragment();
            case 2:
                return new CalcFragment();
            case 3:
                return new EnemyLists();
        }
        return null;
    }

    @Override
    public int getCount(){
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Profiles";
            case 1:
                return "Tools";
            case 2:
                return "Counter";
            case 3:
                return "Duelists";
        }
        return null;
    }
}