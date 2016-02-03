package com.example.hiyoriaya.ygoapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

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

            }
        });
        return builder.create();
    }
}
