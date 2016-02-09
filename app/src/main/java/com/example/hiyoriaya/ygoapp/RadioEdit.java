package com.example.hiyoriaya.ygoapp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
/**
 * Created by hiyorineko on 2016/02/08.
 */
public class RadioEdit extends RelativeLayout{

    TextView tv;
    RadioButton rb;
    public RadioEdit(Context context, AttributeSet attrs) {
        super(context, attrs);
        View layout = LayoutInflater.from(context).inflate(R.layout.radioedit,this);
        tv = (TextView)layout.findViewById(R.id.tv);
        rb = (RadioButton)layout.findViewById(R.id.rb);
    }
}
