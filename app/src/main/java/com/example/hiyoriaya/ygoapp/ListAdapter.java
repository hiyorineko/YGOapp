package com.example.hiyoriaya.ygoapp;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

import java.util.List;

/**
 * Created by hiyorineko on 2016/02/09.
 */
public class ListAdapter extends ArrayAdapter<String> implements View.OnClickListener{

        private LayoutInflater inflater = null;

        public ListAdapter(Context context, int resource,List<String> items) {
            super(context, resource, items);
            inflater = LayoutInflater.from(context);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if(convertView == null){
                convertView = inflater.inflate(R.layout.row,null);
            }

            ViewPager viewPager = (ViewPager)convertView.findViewById(R.id.viewpager);
            MyPagerAdapter adapter = new MyPagerAdapter(getContext(),getItem(position));
            viewPager.setAdapter(adapter);

            return convertView;
        }

    @Override
    public void onClick(View v) {

    }
}
