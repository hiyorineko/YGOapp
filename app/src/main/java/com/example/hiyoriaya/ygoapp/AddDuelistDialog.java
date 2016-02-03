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
 * Created by hiyorineko on 2016/02/02.
 */
public class AddDuelistDialog extends DialogFragment{
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = (LayoutInflater)getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View content = inflater.inflate(R.layout.adddialog_setting,null);
        builder.setView(content);
        builder.setMessage("デュエリスト追加").setNegativeButton("追加", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                EditText et = (EditText) content.findViewById(R.id.inputduelistname);
                String input = et.getText().toString();
                try {
                    OutputStream out = MainActivity.context.openFileOutput("keys.txt", MainActivity.context.MODE_APPEND);
                    PrintWriter writer = new PrintWriter(new OutputStreamWriter(out, "UTF-8"));
                    writer.append(input + "\n");
                    MainActivity.keys.add(input);
                    writer.close();
                } catch (FileNotFoundException e) {
                    try {
                        OutputStream out = MainActivity.context.openFileOutput("keys.txt", MainActivity.context.MODE_PRIVATE);
                        PrintWriter writer = new PrintWriter(new OutputStreamWriter(out, "UTF-8"));
                        writer.append(input + "\n");
                        MainActivity.keys.add(input);
                        writer.close();
                    } catch (FileNotFoundException e1) {

                    } catch (UnsupportedEncodingException e1){

                    }
                } catch (UnsupportedEncodingException e) {

                }

            }
        });
        return builder.create();
    }
}
