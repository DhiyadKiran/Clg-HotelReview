package com.example.hotelreview;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.hotelreview.databinding.ActivityMainBinding;
import com.example.hotelreview.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {

    Animation from_left,from_right,from_bottom;
    private ActivitySecondBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //load animations
        from_bottom = AnimationUtils.loadAnimation(this,R.anim.anim_from_bottom);
        from_right= AnimationUtils.loadAnimation(this,R.anim.anim_from_right);
        from_left = AnimationUtils.loadAnimation(this,R.anim.anim_from_left);

        //set Animation
        binding.igBackArrow.setAnimation(from_left);
        binding.txHotelName.setAnimation(from_right);
        binding.rbRatingBar.setAnimation(from_left);
        binding.txRatingNumber.setAnimation(from_right);
        binding.igUpArrow.setAnimation(from_bottom);
        binding.txMoreDetails.setAnimation(from_bottom);


        binding.igBackArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(SecondActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        binding.igUpArrow.setOnClickListener((view -> {

            Intent intent = new Intent(SecondActivity.this,ThirdActivity.class);

            Pair[] pairs = new  Pair[1];
            pairs[0] = new Pair<View,String>(binding.igUpArrow,"background_image_transition");

            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SecondActivity.this,pairs);
            startActivity(intent);
        }));

        //hide status bar and navigation bat at the  bottom
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );
        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        );
    }
}