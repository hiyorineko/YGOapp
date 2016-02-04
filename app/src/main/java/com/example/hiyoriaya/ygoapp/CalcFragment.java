package com.example.hiyoriaya.ygoapp;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * Created by hiyorineko on 2016/02/01.
 * 遊戯王のデュエルカウンターです。
 * 数値の書いてあるボタンを押すとライフ表示から引かれます。
 * 回復モードを選択すると数値を押すとライフ表示に足されます。
 * 1/2はどちらのモードでも現行のライフの数字を半分にします。
 */
public class CalcFragment extends Fragment implements View.OnClickListener{
    TextView lpy;
    TextView lpe;
    int lpyn;
    int lpen;
    CheckBox modec;

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_calc, container, false);
        findViews(v);
        return v;
    }
    @Override
    public void onStart(){
        super.onStart();
    }

    public void onClick(View v){
        if(modec.isChecked() == true) {
            switch (v.getId()) {
                case R.id.y1000:
                    lpyn = lpyn + 1000;
                    lpy.setText(String.valueOf(lpyn));
                    break;

                case R.id.y500:
                    lpyn = lpyn + 500;
                    lpy.setText(String.valueOf(lpyn));
                    break;

                case R.id.y100:
                    lpyn = lpyn + 100;
                    lpy.setText(String.valueOf(lpyn));
                    break;

                case R.id.y50:
                    lpyn = lpyn + 50;
                    lpy.setText(String.valueOf(lpyn));
                    break;

                case R.id.yharf:
                    lpyn = lpyn / 2;
                    lpy.setText(String.valueOf(lpyn));
                    break;

                case R.id.e1000:
                    lpen = lpen + 1000;
                    lpe.setText(String.valueOf(lpen));
                    break;

                case R.id.e500:
                    lpen = lpen + 500;
                    lpe.setText(String.valueOf(lpen));
                    break;

                case R.id.e100:
                    lpen = lpen + 100;
                    lpe.setText(String.valueOf(lpen));
                    break;

                case R.id.e50:
                    lpen = lpen + 50;
                    lpe.setText(String.valueOf(lpen));
                    break;

                case R.id.eharf:
                    lpen = lpen / 2;
                    lpe.setText(String.valueOf(lpen));
                    break;

                case R.id.reset:
                    lpyn = 8000;
                    lpen = 8000;
                    lpy.setText(String.valueOf(lpyn));
                    lpe.setText(String.valueOf(lpen));
            }

        }else{

            switch(v.getId()){
                case R.id.y1000:
                    lpyn = lpyn - 1000;
                    lpy.setText(String.valueOf(lpyn));
                    break;

                case R.id.y500:
                    lpyn = lpyn - 500;
                    lpy.setText(String.valueOf(lpyn));
                    break;

                case R.id.y100:
                    lpyn = lpyn - 100;
                    lpy.setText(String.valueOf(lpyn));
                    break;

                case R.id.y50:
                    lpyn = lpyn - 50;
                    lpy.setText(String.valueOf(lpyn));
                    break;

                case R.id.yharf:
                    lpyn = lpyn/2;
                    lpy.setText(String.valueOf(lpyn));
                    break;

                case R.id.e1000:
                    lpen = lpen - 1000;
                    lpe.setText(String.valueOf(lpen));
                    break;

                case R.id.e500:
                    lpen = lpen - 500;
                    lpe.setText(String.valueOf(lpen));
                    break;

                case R.id.e100:
                    lpen = lpen - 100;
                    lpe.setText(String.valueOf(lpen));
                    break;

                case R.id.e50:
                    lpen = lpen - 50;
                    lpe.setText(String.valueOf(lpen));
                    break;

                case R.id.eharf:
                    lpen = lpen/2;
                    lpe.setText(String.valueOf(lpen));
                    break;

                case R.id.reset:
                    lpyn = 8000;
                    lpen = 8000;
                    lpy.setText(String.valueOf(lpyn));
                    lpe.setText(String.valueOf(lpen));
            }

        }
    }

    protected void findViews(View v){
        lpy = (TextView) v.findViewById(R.id.lpy);
        lpe = (TextView)v.findViewById(R.id.lpe);
        lpyn = 8000;
        lpen = 8000;
        lpy.setText("8000");
        lpe.setText("8000");

        modec = (CheckBox)v.findViewById(R.id.modec);

        Button y1000 = (Button) v.findViewById(R.id.y1000);
        y1000.setOnClickListener(this);

        Button y500 = (Button) v.findViewById(R.id.y500);
        y500.setOnClickListener(this);

        Button y100 = (Button) v.findViewById(R.id.y100);
        y100.setOnClickListener(this);

        Button y50 = (Button) v.findViewById(R.id.y50);
        y50.setOnClickListener(this);

        Button yharf = (Button) v.findViewById(R.id.yharf);
        yharf.setOnClickListener(this);

        Button e1000 = (Button) v.findViewById(R.id.e1000);
        e1000.setOnClickListener(this);

        Button e500 = (Button) v.findViewById(R.id.e500);
        e500.setOnClickListener(this);

        Button e100 = (Button) v.findViewById(R.id.e100);
        e100.setOnClickListener(this);

        Button e50 = (Button) v.findViewById(R.id.e50);
        e50.setOnClickListener(this);

        Button eharf = (Button)v.findViewById(R.id.eharf);
        eharf.setOnClickListener(this);

        Button reset = (Button) v.findViewById(R.id.reset);
        reset.setOnClickListener(this);
    }

}
