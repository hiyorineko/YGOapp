package com.example.hiyoriaya.ygoapp;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;


/**
 * Created by hiyorineko on 2016/02/01.
 * 登録されたデュエリストをListViewで表示しています。
 * デュエリスト追加ボタンを押すとAddDuelistDialogが呼ばれます。
 * ListViewの項目ロングタップでRemoveDuelistDialogが呼ばれます。
 * それぞれのDialogから変更通知をするためにListViewのArrayAdapterをstaticにしてあります。
 *
 * ListViewをタップするとMainActivityからopenDuelistメソッドが呼び出され
 * Activityの画面遷移が行われます。
 *
 */
public class EnemyLists extends Fragment implements View.OnClickListener,AdapterView.OnItemClickListener,AdapterView.OnItemLongClickListener{
    private ListView enemyList;
    Button addDuelist;
    static ArrayAdapter<String> arrayAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_enemylists,container,false);
        findView(v, container);
        return v;
    }

    @Override
    public void onStart(){
        super.onStart();
    }

    public void findView(View v, final ViewGroup container){
        enemyList = (ListView)v.findViewById(R.id.enemyLists);
        arrayAdapter = new ArrayAdapter<String>(v.getContext(),android.R.layout.simple_expandable_list_item_1,MainActivity.keys);
        enemyList.setAdapter(arrayAdapter);

        enemyList.setOnItemClickListener(this);
        enemyList.setOnItemLongClickListener(this);

        addDuelist = (Button)v.findViewById(R.id.addduelist);
        addDuelist.setOnClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView parent, View view, int position, long id) {
        MainActivity.openDueList(position);
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        //リストロングタップ時の挙動
        //メニューを出して削除をしたい
        DialogFragment newFragment = new RemoveDuelistDialog();
        MainActivity.select = position;
        newFragment.show(getFragmentManager(), "");
        arrayAdapter.notifyDataSetChanged();
        return true;
    }

    @Override
    public void onClick(View v) {
        //EnemyListを追加するFragment or 処理
        DialogFragment newFragment = new AddDuelistDialog();
        newFragment.show(getFragmentManager(),"");
        arrayAdapter.notifyDataSetChanged();
    }
}