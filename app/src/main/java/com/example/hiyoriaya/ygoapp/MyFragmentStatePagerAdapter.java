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
                return new ToolsFragment();
            case 1:
                return new CalcFragment();
            case 2:
                return new EnemyLists();
        }
        return null;
    }

    @Override
    public int getCount(){
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Tools";
            case 1:
                return "Counter";
            case 2:
                return "Duelists";
        }
        return null;
    }
}
