package com.example.hiyoriaya.ygoapp;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.Random;

/**
 * Created by hiyorineko on 2016/02/02.
 * TCGに使いそうなツールのコインとサイコロを表示します。
 * それぞれタップ→ランダムにアニメーションが呼び出される
 * という仕組みです。
 */
public class ToolsFragment extends Fragment implements View.OnTouchListener{

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
        coin.setBackgroundResource(R.drawable.omote);
        cycolo = (ImageView)v.findViewById(R.id.cycolo);
        cycolo.setBackgroundResource(R.drawable.cy1motion);
        cycolo.setOnTouchListener(this);
        coin.setOnTouchListener(this);
    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        Random r = new Random();
        if (v.getId() == R.id.coin) {
            switch (r.nextInt(2)) {
                case 0:
                    coin.setBackgroundResource(R.drawable.omotemotion);
                    AnimationDrawable anim = (AnimationDrawable)coin.getBackground();
                    anim.stop(); // 念のため一度ストップ
                    anim.selectDrawable(0); // 0フレーム目に戻す
                    anim.setOneShot(true);
                    anim.start();
                    break;
                case 1:
                    coin.setBackgroundResource(R.drawable.uramotion);
                    AnimationDrawable anim2 = (AnimationDrawable)coin.getBackground();
                    anim2.stop(); // 念のため一度ストップ
                    anim2.selectDrawable(0); // 0フレーム目に戻す
                    anim2.setOneShot(true);
                    anim2.start();
                    break;
            }
        } else {
            switch (r.nextInt(6)) {
                case 0:
                    cycolo.setBackgroundResource(R.drawable.cy1motion);
                    AnimationDrawable anim = (AnimationDrawable)cycolo.getBackground();
                    anim.stop(); // 念のため一度ストップ
                    anim.selectDrawable(0); // 0フレーム目に戻す
                    anim.setOneShot(true);
                    anim.start();
                    break;
                case 1:
                    cycolo.setBackgroundResource(R.drawable.cy2motion);
                    AnimationDrawable anim2 = (AnimationDrawable)cycolo.getBackground();
                    anim2.stop(); // 念のため一度ストップ
                    anim2.selectDrawable(0); // 0フレーム目に戻す
                    anim2.setOneShot(true);
                    anim2.start();
                    break;
                case 2:
                    cycolo.setBackgroundResource(R.drawable.cy3motion);
                    AnimationDrawable anim3 = (AnimationDrawable)cycolo.getBackground();
                    anim3.stop(); // 念のため一度ストップ
                    anim3.selectDrawable(0); // 0フレーム目に戻す
                    anim3.setOneShot(true);
                    anim3.start();
                    break;
                case 3:
                    cycolo.setBackgroundResource(R.drawable.cy4motion);
                    AnimationDrawable anim4 = (AnimationDrawable)cycolo.getBackground();
                    anim4.stop(); // 念のため一度ストップ
                    anim4.selectDrawable(0); // 0フレーム目に戻す
                    anim4.setOneShot(true);
                    anim4.start();
                    break;
                case 4:
                    cycolo.setBackgroundResource(R.drawable.cy5motion);
                    AnimationDrawable anim5 = (AnimationDrawable)cycolo.getBackground();
                    anim5.stop(); // 念のため一度ストップ
                    anim5.selectDrawable(0); // 0フレーム目に戻す
                    anim5.setOneShot(true);
                    anim5.start();
                    break;
                case 5:
                    cycolo.setBackgroundResource(R.drawable.cy6motion);
                    AnimationDrawable anim6 = (AnimationDrawable)cycolo.getBackground();
                    anim6.stop(); // 念のため一度ストップ
                    anim6.selectDrawable(0); // 0フレーム目に戻す
                    anim6.setOneShot(true);
                    anim6.start();
                    break;
            }
        }

        return false;
    }
}
