package com.example.hotelreview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
    private SharedPreferences spf;
    private String Name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplachScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        spf = this.getSharedPreferences("UserDetails" , Context.MODE_PRIVATE);
        Name = spf.getString("UserName" , null);


        //load animations
        anim_from_bottom = AnimationUtils.loadAnimation(this,R.anim.anim_from_bottom);
        anim_from_top = AnimationUtils.loadAnimation(this,R.anim.anim_from_top);


        //set Animations
        binding.txHotelReview.setAnimation(anim_from_top);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


                Intent intent;
                if(Name == null){
                    intent = new Intent(SplachScreen.this, SignIn.class);
                }else {
                    intent = new Intent(SplachScreen.this, MainActivity.class);
                }
                startActivity(intent);
                finish();
            }
        },SPLACH_SCREEN);
    }
}