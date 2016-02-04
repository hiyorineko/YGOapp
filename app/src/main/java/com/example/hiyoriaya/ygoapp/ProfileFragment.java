package com.example.hiyoriaya.ygoapp;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

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
 * Created by hiyorineko on 2016/02/04.
 * 自分のプロフィールを設定できるクラス。
 * 設定したプロフィールは赤外線かNFCとかで送信できるようにしたい
 * (AndroidだしNFCかな？)
 */
public class ProfileFragment extends Fragment{

    List<String> profile;
    View v;
    EditText username;
    EditText userthemes;
    EditText favorites;
    EditText appeal;

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
        v = inflater.inflate(R.layout.fragment_profile,container,false);
        return v;
    }

    @Override
    public void onStart(){
        super.onStart();
        findViews();
        loadProfile();
    }

    @Override
    public void onPause(){
        super.onPause();
        saveProfile();
    }

    public void findViews(){
        profile = new ArrayList<String>();
        username = (EditText)v.findViewById(R.id.username);
        userthemes = (EditText)v.findViewById(R.id.userthemes);
        favorites = (EditText)v.findViewById(R.id.favorite);
        appeal = (EditText)v.findViewById(R.id.favorite);

    }

    public void loadProfile(){
        try{
            InputStream in = MainActivity.context.openFileInput("profile.txt");
            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(in,"UTF-8"));
            String s;
            int i=0;
            while((s = reader.readLine())!= null){
                profile.add(s);
                switch (i){
                    case 0:
                        username.setText(profile.get(0));
                        break;
                    case 1:
                        userthemes.setText(profile.get(1));
                        break;
                    case 2:
                        favorites.setText(profile.get(2));
                        break;
                    case 3:
                        appeal.setText(profile.get(3));
                        break;
                }
                i++;
            }
            reader.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void saveProfile(){
        try {
            OutputStream out;
            MainActivity.context.deleteFile("profile.txt");
            out = MainActivity.context.openFileOutput("profile.txt", MainActivity.context.MODE_PRIVATE);
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(out, "UTF-8"));
            writer.append(username.getText() + "\n");
            writer.append(userthemes.getText() + "\n");
            writer.append(favorites.getText() + "\n");
            writer.append(appeal.getText() + "\n");
            writer.close();
        } catch (FileNotFoundException e) {

        } catch (UnsupportedEncodingException e) {

        }
    }
}
