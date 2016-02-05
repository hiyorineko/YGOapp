package com.example.hiyoriaya.ygoapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
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
public class RecordActivity extends Activity implements RadioGroup.OnCheckedChangeListener{

    static int currentmenuidx;
    TextView dname;
    TextView duelresults;
    RadioGroup dthemes;
    List<String> themes;
    String[][] loaddatas; //loaddataで読み込んだtheme名,勝ち数,負け数が入ってる
    LinearLayout tresults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);
    }

    public void findViews(){
        currentmenuidx = -1;//初期値
        themes = new ArrayList<String>();
        themes.add("スタンダード");
        themes.add("融合");
        themes.add("儀式");
        themes.add("スタンダード");
        themes.add("融合");
        themes.add("儀式");
        dname=(TextView)findViewById(R.id.dname);
        dname.setText(MainActivity.keys.get(MainActivity.select));
        duelresults = (TextView)findViewById(R.id.duelresults);
        duelresults.setText("0戦0勝0敗 勝率0%");
        dthemes = (RadioGroup)findViewById(R.id.dthemes);
        tresults = (LinearLayout)findViewById(R.id.tresults);
    }

    public void themeSet(){
        for(int i=0;i<themes.size();i++){
            RadioButton radioButton = new RadioButton(this);
            radioButton.setText(themes.get(i));
            dthemes.addView(radioButton, i);
            TextView textView = new TextView(this);
            textView.setPadding(16,16,16,16);
            textView.setText("―　　0勝　0敗");
            textView.setTextSize(16);
            tresults.addView(textView,i);
        }
        RadioButton radioButton = new RadioButton(this);
        radioButton.setText("追加");
        radioButton.setTextSize(20);
        dthemes.addView(radioButton, themes.size());//一番後ろに追加ボタンを追加
        dthemes.invalidate();
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

    public void addThemes(){

    }

    public static void removeDatas(int position){
        MainActivity.context.deleteFile("themes"+position+".txt");
    }



    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if(checkedId == themes.size()+1){
            if (currentmenuidx != -1 && currentmenuidx != themes.size()+1) {
                dthemes.removeViewAt(currentmenuidx);
            }
            currentmenuidx = checkedId;
        }else {
            if (currentmenuidx != -1 && currentmenuidx != themes.size()+1) {
                dthemes.removeViewAt(currentmenuidx);
            }
            currentmenuidx = checkedId;
            LinearLayout menu = new LinearLayout(this);
            menu.setOrientation(LinearLayout.VERTICAL);
            Button deletetheme = new Button(this);
            deletetheme.setText("削除");
            Button winbutton = new Button(this);
            winbutton.setText("勝ち");
            Button losebutton = new Button(this);
            losebutton.setText("負け");
            menu.addView(deletetheme);
            menu.addView(winbutton);
            menu.addView(losebutton);
            dthemes.addView(menu, currentmenuidx);
        }
    }

    @Override
    public void onStart(){
        super.onStart();
        findViews();
        loadThemes();
        themeSet();
    }

    @Override
    public void onPause(){
        super.onPause();
    }

    @Override
    public void onResume(){
        super.onResume();
    }
}
