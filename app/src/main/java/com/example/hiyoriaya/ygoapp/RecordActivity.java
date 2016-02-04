package com.example.hiyoriaya.ygoapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hiyorineko on 2016/02/02.
 * duelistデータの編集クラスも兼ねる
 * removeDatas・・引数の主キーを削除→詰める
 */
public class RecordActivity extends Activity{

    TextView dname;
    TextView duelresults;
    ListView dthemes;
    List<String> themes;
    String[][] loaddatas; //loaddataで読み込んだtheme名,勝ち数,負け数が入ってる

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);
        findViews();
        loadThemes();
    }

    public void findViews(){
        themes = new ArrayList<String>();
        dname=(TextView)findViewById(R.id.dname);
        dname.setText(MainActivity.keys.get(MainActivity.select));
        duelresults = (TextView)findViewById(R.id.duelresults);
        duelresults.setText("0戦0勝0敗 勝率0%");
        dthemes = (ListView)findViewById(R.id.dthemes);
        themeSet();
    }

    public void themeSet(){
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,themes);
        dthemes.setAdapter(arrayAdapter);
    }

    //テーマリストを取得
    //themes"select".txtから読み込み
    public void loadThemes(){
        try{
            InputStream in = MainActivity.context.openFileInput("themes"+MainActivity.select+".txt");
            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(in,"UTF-8"));
            String s;
            while((s = reader.readLine())!= null){
                themes.add(s + "\n");
            }
            reader.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        loaddatas = new String[themes.size()][3];
        for(int i=0;i<themes.size();i++) {
            loaddatas[i] = themes.get(i).split(",");
        }
    }

    public void addThemes(){

    }

    public static void removeDatas(int position){
        try {
            OutputStream out = MainActivity.context.openFileOutput("dueldata.txt", MainActivity.context.MODE_PRIVATE);
        }catch (IOException e){}
    }
}
