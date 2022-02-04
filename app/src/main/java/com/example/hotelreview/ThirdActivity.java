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
import android.widget.ScrollView;

import com.example.hotelreview.databinding.ActivityThirdBinding;

public class ThirdActivity extends AppCompatActivity {

    ImageView down_arrow;
    ScrollView third_scrollview;
    Animation from_bottom;
    private ActivityThirdBinding binding;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityThirdBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        down_arrow = findViewById(R.id.down_arrow);
//        third_scrollview = findViewById(R.id.third_scrollview);

        from_bottom = AnimationUtils.loadAnimation(this,R.anim.anim_from_bottom);

        binding.igDownArrow.setAnimation(from_bottom);
        binding.svScrollView.setAnimation(from_bottom);


        binding.igDownArrow.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ThirdActivity.this,SecondActivity.class);

                Pair[] pairs = new  Pair[1];
                pairs[0] = new Pair<View,String>(binding.igDownArrow,"background_image_transition");

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(ThirdActivity.this,pairs);
                startActivity(intent,options.toBundle());
            }
        });




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