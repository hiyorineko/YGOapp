package com.example.hiyoriaya.ygoapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * Created by hiyorineko on 2016/02/03.
 */
public class RemoveDuelistDialog extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = (LayoutInflater)getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View content = inflater.inflate(R.layout.removedialog_setting,null);
        builder.setView(content);
        builder.setMessage("デュエリストデータの削除").setNegativeButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                for(int i=0;i<MainActivity.keys.size();i++){
                    if(i!=MainActivity.select){
                        try {
                            OutputStream out;
                            if(i==0) {
                                out = MainActivity.context.openFileOutput("keys.txt", MainActivity.context.MODE_PRIVATE);
                            }else{
                                out = MainActivity.context.openFileOutput("keys.txt", MainActivity.context.MODE_APPEND);
                            }
                            PrintWriter writer = new PrintWriter(new OutputStreamWriter(out, "UTF-8"));
                            writer.append(MainActivity.keys.get(i) + "\n");
                            writer.close();
                        } catch (FileNotFoundException e) {

                        }catch (UnsupportedEncodingException e){

                        }
                    }
                }
                MainActivity.loadData();
                RecordActivity.removeDatas(MainActivity.select);
            }
        });
        return builder.create();
    }
}