package com.example.hiyoriaya.ygoapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hiyorineko on 2016/02/02.
 * duelistデータの編集クラスも兼ねる
 * removeDatas・・引数の主キーを削除→詰める
 */
public class RecordActivity extends Activity implements AdapterView.OnItemClickListener, View.OnClickListener{

    TextView dname;
    TextView dprof;
    TextView duelresults;
    List<String> themes;
    List<String> profs;
    String[][] loaddatas; //loaddataで読み込んだtheme名,勝ち数,負け数が入ってる
    ListView dtheme;
    Button winbutton;
    Button losebutton;
    Button deletebutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);
        findViews();
        loadThemes();
        loadprofs();
        themeSet();
        profSet();

        LayoutInflater inflater = getLayoutInflater();
        View v = inflater.inflate(R.layout.menupart, null, false);
        winbutton = (Button)v.findViewById(R.id.winbutton);
        winbutton.setOnClickListener(this);
        losebutton = (Button)v.findViewById(R.id.losebutton);
        losebutton.setOnClickListener(this);
        deletebutton = (Button)v.findViewById(R.id.delbutton);
        deletebutton.setOnClickListener(this);
    }

    public void findViews(){
        themes = new ArrayList<String>();
        profs = new ArrayList<String>();
        themes.add("かげろう");
        themes.add("かげろう");
        themes.add("かげろう");
        themes.add("かげろう");
        themes.add("かげろう");
        themes.add("かげろう");
        themes.add("かげろう");
        themes.add("かげろう");
        themes.add("かげろう");
        themes.add("かげろう");
        themes.add("かげろう");
        themes.add("かげろう");
        dname=(TextView)findViewById(R.id.dname);
        dname.setText(MainActivity.keys.get(MainActivity.select));
        dprof=(TextView)findViewById(R.id.dprof);
        duelresults = (TextView)findViewById(R.id.duelresults);
        duelresults.setText("0戦0勝0敗 勝率0%");


    }

    public void padding(int position){
        for(int i=0;i<themes.size();i++){
            String spannable ="";
            for(int j= themes.get(i).length();j<10;j++){
                spannable += ("　");
            }
        }

    }

    public void profSet(){
        try {
            dprof.setText("【魂のカード】\n" + profs.get(2));
            dprof.append("\n【自己紹介】\n" + profs.get(3));
        }catch(IndexOutOfBoundsException e){

        }
    }

    public void themeSet(){
        dtheme = (ListView)findViewById(R.id.dtheme);
        ListAdapter adapter = new ListAdapter(this,R.layout.row,themes);
        dtheme.setAdapter(adapter);
        dtheme.setOnItemClickListener(this);
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
            try{
                OutputStream out = MainActivity.context.openFileOutput("themes"+MainActivity.select+".txt", MainActivity.context.MODE_APPEND);
                PrintWriter writer = new PrintWriter(new OutputStreamWriter(out, "UTF-8"));
            } catch (FileNotFoundException e1) {
            } catch (UnsupportedEncodingException e1) {
            }
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
                profs.add(s + "\n");
            }
            reader.close();
        }catch(IOException e){
           try{
               OutputStream out = MainActivity.context.openFileOutput("profs"+MainActivity.select+".txt", MainActivity.context.MODE_PRIVATE);
               PrintWriter writer = new PrintWriter(new OutputStreamWriter(out, "UTF-8"));
               writer.append(MainActivity.keys.get(MainActivity.select)+"\n");//名前
               writer.append(" \n");
               writer.append(" \n");
               writer.append(" ");
               loadprofs();
           } catch (FileNotFoundException e1) {
           } catch (UnsupportedEncodingException e1) {
           }
        }
    }

    public static void removeDatas(int position){
        MainActivity.context.deleteFile("themes"+position+".txt");
    }

    @Override
    public void onClick(View v) {
        dname.setText("わたろう");
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        dname.setText("わたろう");
    }
}
