package com.example.hiyoriaya.ygoapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by hiyorineko on 2016/02/02.
 * duelistデータの編集クラスも兼ねる
 * removeDatas・・引数の主キーを削除→詰める
 */
public class RecordActivity extends Activity{

    TextView dname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);
        findViews();
    }

    public void findViews(){
        dname=(TextView)findViewById(R.id.dname);
        dname.setText(MainActivity.keys.get(MainActivity.select));
    }

    public static void removeDatas(int position){

    }

}
