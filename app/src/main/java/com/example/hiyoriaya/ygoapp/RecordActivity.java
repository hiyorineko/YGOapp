package com.example.hiyoriaya.ygoapp;

import android.app.Activity;

import android.graphics.Paint;
import android.os.Bundle;
import android.view.TextureView;
import android.widget.TextView;

import org.w3c.dom.Text;

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
public class RecordActivity extends Activity{

    List<String> profs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);
        findViews();
        readProfs();
        setViews();
    }

    public void findViews(){
        profs = new ArrayList<String>();
    }
    public void setViews(){
        String[] arrayresult = profs.get(1).split(",");
        String[] arrayThemes = profs.get(2).split(",");
        TextView dname = (TextView)findViewById(R.id.dname);
        dname.setPaintFlags(dname.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        TextView dresult = (TextView)findViewById(R.id.duelresults);
        TextView dtheme = (TextView)findViewById(R.id.dthemes);
        dtheme.setPaintFlags(dtheme.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        TextView dspirit = (TextView)findViewById(R.id.dspirit);
        TextView dcomment = (TextView)findViewById(R.id.dcomment);
        dname.setText(profs.get(0));
        dresult.setText(arrayresult[0] + "勝" + arrayresult[1] + "敗");
        for(int i=0;i<arrayThemes.length;i++){
            if(i==arrayThemes.length-1){
                dtheme.append(arrayThemes[i]);
            }else {
                dtheme.append(arrayThemes[i] + "\n");
            }
        }
        dspirit.setText(profs.get(3));
        dcomment.setText(profs.get(4));
    }

    public void readProfs(){
        try{
            InputStream in = openFileInput("profs"+MainActivity.select+".txt");
            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(in,"UTF-8"));
            String s;
            while((s = reader.readLine())!= null){
                profs.add(s.replaceAll("\n",""));
            }
            reader.close();
        }catch(FileNotFoundException e){
            try {
                OutputStream out = openFileOutput("profs" + MainActivity.select + ".txt", MODE_PRIVATE);
                PrintWriter writer = new PrintWriter(new OutputStreamWriter(out, "UTF-8"));
                writer.append("たろう\n");//0
                writer.append("1,2\n");//1
                writer.append("A,B,C\n");//2
                writer.append("ガトクロ\n");//3
                writer.append("こんにちは\n");//4
                writer.close();
                readProfs();
            }catch(FileNotFoundException e2){
            }catch(UnsupportedEncodingException e3){}
        }catch (UnsupportedEncodingException e1){
        }catch(IOException e5){}
    }

    //public void padding(int position) {
    //    for (int i = 0; i < themes.size(); i++) {
    //        String spannable = "";
    //        for (int j = themes.get(i).length(); j < 10; j++) {
    //            spannable += ("　");
    //        }
    //    }
    //}

    public static void removeDatas(int position) {
        MainActivity.context.deleteFile("profs" + position + ".txt");
    }
}
