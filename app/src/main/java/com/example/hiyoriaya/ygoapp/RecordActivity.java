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
        int[] arrayresult = new int[2];
        String[] arrayThemes = profs.get(3).split(",");
        String[] arrayThemeWins = profs.get(4).split(",");
        String[] arrayThemeLoses = profs.get(5).split(",");
        TextView dname = (TextView)findViewById(R.id.dname);
        dname.setPaintFlags(dname.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        TextView dresult = (TextView)findViewById(R.id.duelresults);
        TextView dtheme = (TextView)findViewById(R.id.dthemes);
        dtheme.setPaintFlags(dtheme.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        TextView dspirit = (TextView)findViewById(R.id.dspirit);
        TextView dcomment = (TextView)findViewById(R.id.dcomment);
        TextView themeresult = (TextView)findViewById(R.id.themeresult);
        dname.setText(profs.get(0));
        for(int i=0;i<arrayThemes.length;i++){
            if(i==arrayThemes.length-1){
                dtheme.append(arrayThemes[i]);
                themeresult.append(arrayThemeWins[i]+"勝"+arrayThemeLoses[i]+"敗");
            }else {
                dtheme.append(arrayThemes[i] + "\n");
                themeresult.append(arrayThemeWins[i]+"勝"+arrayThemeLoses[i]+"敗\n");
            }
            arrayresult[0] += Integer.parseInt(arrayThemeWins[i]);
            arrayresult[1] += Integer.parseInt(arrayThemeLoses[i]);
        }
        dresult.setText(String.valueOf(arrayresult[0]) + "勝" + String.valueOf(arrayresult[1]) + "敗");
        dspirit.setText(profs.get(1));
        dcomment.setText(profs.get(2));
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
                writer.append("たろう\n");
                writer.append("ガトクロ\n");
                writer.append("こんにちは\n");
                writer.append("A,B,C\n");
                writer.append("10,10,10\n");
                writer.append("2,2,2\n");
                writer.close();
                readProfs();
            }catch(FileNotFoundException e2){
            }catch(UnsupportedEncodingException e3){}
        }catch (UnsupportedEncodingException e1){
        }catch(IOException e5){}
    }

    public String padding(String tmp) {
        String spannable ="";
        for (int i = tmp.length(); i < 10; i++) {
                spannable += ("　");
            }
        return spannable;
    }

    public static void removeDatas(int position) {
        MainActivity.context.deleteFile("profs" + position + ".txt");
    }
}