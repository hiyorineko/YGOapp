package com.example.hiyoriaya.ygoapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * Created by hiyorineko on 2016/02/10.
 */
public class RemoveThemeDialog extends DialogFragment{

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = (LayoutInflater)getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View content = inflater.inflate(R.layout.removedialog_setting,null);
        TextView selectDuelist = (TextView)content.findViewById(R.id.selectduelist);
        //selectDuelist.setText(RecordActivity.themes.get(RecordActivity.themeselect));
        builder.setView(content);
        builder.setMessage("テーマを削除してもよろしいですか？").setNegativeButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                MainActivity.context.deleteFile("themes" + MainActivity.select + ".txt");

            }
        });
        return builder.create();
    }
}
