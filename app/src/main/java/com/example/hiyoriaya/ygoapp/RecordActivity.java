package com.example.hiyoriaya.ygoapp;

import android.app.Activity;
import android.os.Bundle;

import android.widget.RadioButton;
import android.widget.RadioGroup;

import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hiyorineko on 2016/02/02.
 * duelistデータの編集クラスも兼ねる
 * removeDatas・・引数の主キーを削除→詰める
 */
public class RecordActivity extends Activity implements RadioGroup.OnCheckedChangeListener {

    TextView dname;
    TextView dprof;
    TextView duelresults;
    RadioGroup dthemes;
    List<String> themes;
    List<String> profs;
    String[][] loaddatas; //loaddataで読み込んだtheme名,勝ち数,負け数が入ってる


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);
        findViews();
        loadThemes();
        loadprofs();
        themeSet();
        profSet();
    }

    public void findViews(){
        themes = new ArrayList<String>();
        profs = new ArrayList<String>();
        dname=(TextView)findViewById(R.id.dname);
        dname.setText(MainActivity.keys.get(MainActivity.select));
        dprof=(TextView)findViewById(R.id.dprof);
        duelresults = (TextView)findViewById(R.id.duelresults);
        duelresults.setText("0戦0勝0敗 勝率0%");
        dthemes = (RadioGroup) findViewById(R.id.dthemes);
    }

    public void profSet(){
        dprof.setText("【魂のカード】\n"+profs.get(2));
        dprof.append("\n【自己紹介】\n"+profs.get(3));
    }

    public void themeSet(){
        for(int i=0;i<themes.size();i++){
            String spannable ="";
            for(int j= themes.get(i).length();j<10;j++){
                spannable += ("　");
            }
            RadioButton radioButton = new RadioButton(this);
            radioButton.setText(themes.get(i));
            radioButton.append(spannable+"―　0勝　0敗");
            radioButton.setTextSize(20);
            dthemes.addView(radioButton,i);
        }
        RadioButton radioButton = new RadioButton(this);
        radioButton.setText("追加");
        radioButton.setTextSize(20);
        dthemes.addView(radioButton, themes.size());//一番後ろに追加ボタンを追加
        dthemes.setOnCheckedChangeListener(this);
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

    public void loadprofs(){
        try{
            InputStream in = MainActivity.context.openFileInput("profs"+MainActivity.select+".txt");
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
    }

    public static void removeDatas(int position){
        MainActivity.context.deleteFile("themes"+position+".txt");
    }


    //テーマリストチェック時の動作
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if(checkedId == themes.size()-1){

        }
    }
}
