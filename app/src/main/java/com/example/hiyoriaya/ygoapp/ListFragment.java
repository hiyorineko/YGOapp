package com.example.hiyoriaya.ygoapp;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hiyorineko on 2016/02/01.
 */
public class ListFragment extends Fragment implements AdapterView.OnItemClickListener {

    static List<String> dataList = new ArrayList<String>();
    static ArrayAdapter<String> adapter;
    ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_list,container,false);
        listView = (ListView)v.findViewById(R.id.lv1);
        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        if(dataList.size() == 0){
            dataList.add("Foo");
            dataList.add("Bar");
            dataList.add("Baz");
        }

        adapter = new ArrayAdapter<String>(getActivity(),
                                            android.R.layout.simple_list_item_1,dataList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Activity a = getActivity();
        if(a instanceof OnListChangeListener){
            OnListChangeListener listener = (OnListChangeListener)getActivity();
            listener.onListSelectedChanged(dataList.get(position));
        }
    }
}


