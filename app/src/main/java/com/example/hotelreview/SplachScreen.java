package com.example.hotelreview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hotelreview.databinding.ActivitySplachScreenBinding;

public class SplachScreen extends AppCompatActivity {

    private static  int SPLACH_SCREEN = 3000;
    Animation anim_from_bottom,anim_from_top;
    private ActivitySplachScreenBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplachScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        //load animations
        anim_from_bottom = AnimationUtils.loadAnimation(this,R.anim.anim_from_bottom);
        anim_from_top = AnimationUtils.loadAnimation(this,R.anim.anim_from_top);


        //set Animations
        binding.igSplashImage.setAnimation(anim_from_top);
        binding.txSplashScreen.setAnimation(anim_from_bottom);
        binding.txSplashScreen2.setAnimation(anim_from_bottom);
        binding.txSplashScreen3.setAnimation(anim_from_bottom);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplachScreen.this,SignIn.class);
                startActivity(intent);
                finish();
            }
        },SPLACH_SCREEN);
    }
}