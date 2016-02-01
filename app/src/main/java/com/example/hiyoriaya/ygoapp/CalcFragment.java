package com.example.hiyoriaya.ygoapp;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by hiyorineko on 2016/02/01.
 */
public class CalcFragment extends Fragment {

    EditText met1;
    Button mokButton;
    TextView mtv1;

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_calc,container,false);
    }
    @Override
    public void onStart(){
        super.onStart();
        findViews();
        mokButton.setOnClickListener(new View.OnClickListener(){
           @Override
            public void onClick(View v){
               mtv1.setText(met1.getText());
           }
        });
    }

    protected void findViews(){
        met1 = (EditText)getActivity().findViewById(R.id.et1);
        mokButton = (Button)getActivity().findViewById(R.id.okButton);
        mtv1 = (TextView)getActivity().findViewById(R.id.tv1);
    }
}
