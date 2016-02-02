package com.example.hiyoriaya.ygoapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by hiyorineko on 2016/02/02.
 */
public class ToolsFragment extends Fragment implements View.OnTouchListener{
    Bitmap cy1;
    Bitmap cy2;
    Bitmap cy3;
    Bitmap cy4;
    Bitmap cy5;
    Bitmap cy6;
    Bitmap omote;
    Bitmap ura;
    ImageView coin;
    ImageView cycolo;

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.activity_tools,container,false);
        findViews(v);
        return v;
    }

    @Override
    public void onStart(){
        super.onStart();
    }

    public void findViews(View v){
        coin = (ImageView)v.findViewById(R.id.coin);
        cycolo = (ImageView)v.findViewById(R.id.cycolo);
        omote = BitmapFactory.decodeResource(getResources(), R.drawable.omote);
        ura = BitmapFactory.decodeResource(getResources(), R.drawable.ura);
        cy1 = BitmapFactory.decodeResource(getResources(), R.drawable.cy1);
        cy2 = BitmapFactory.decodeResource(getResources(), R.drawable.cy2);
        cy3 = BitmapFactory.decodeResource(getResources(), R.drawable.cy3);
        cy4 = BitmapFactory.decodeResource(getResources(), R.drawable.cy4);
        cy5 = BitmapFactory.decodeResource(getResources(), R.drawable.cy5);
        cy6 = BitmapFactory.decodeResource(getResources(), R.drawable.cy6);
        cycolo.setOnTouchListener(this);
        coin.setOnTouchListener(this);
    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        Random r = new Random();
        if(v.getId()==R.id.coin) {
            switch (r.nextInt(2)) {
                case 0:
                    coin.setImageBitmap(omote);
                    break;
                case 1:
                    coin.setImageBitmap(ura);
                    break;
            }
        }else{
            switch (r.nextInt(6)) {
                case 0:
                    cycolo.setImageBitmap(cy1);
                    break;
                case 1:
                    cycolo.setImageBitmap(cy2);
                    break;
                case 2:
                    cycolo.setImageBitmap(cy3);
                    break;
                case 3:
                    cycolo.setImageBitmap(cy4);
                    break;
                case 4:
                    cycolo.setImageBitmap(cy5);
                    break;
                case 5:
                    cycolo.setImageBitmap(cy6);
                    break;
            }
        }

        return false;
    }
}
