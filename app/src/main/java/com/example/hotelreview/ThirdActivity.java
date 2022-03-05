package com.example.hotelreview;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.hotelreview.Api.ApiUtilities;
import com.example.hotelreview.databinding.ActivityThirdBinding;

public class ThirdActivity extends AppCompatActivity {

    Animation from_bottom;
    private ActivityThirdBinding binding;
    private SharedPreferences spf;
    private  String image;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityThirdBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        from_bottom = AnimationUtils.loadAnimation(this,R.anim.anim_from_bottom);

        binding.igDownArrow.setAnimation(from_bottom);
//        binding.linearLayout.setAnimation(from_bottom);

        spf = this.getSharedPreferences("HotelDetails" , Context.MODE_PRIVATE);
        binding.txHotelName.setText(spf.getString("name" , null));
        binding.txRatingNumber.setText(spf.getString("rating" , null));
        binding.rbRatingBar.setRating(Float.parseFloat(spf.getString("rating",null)));
        binding.txAboutText.setText(spf.getString("about",null));
        image = spf.getString("mainimage",null);
        Glide.with(ThirdActivity.this).load(ApiUtilities.imageUrl+image).into(binding.igHotelImage);
//        Toast.makeText(this, ""+image, Toast.LENGTH_SHORT).show();





        binding.igDownArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ThirdActivity.this,SecondActivity.class);

                Pair[] pairs = new  Pair[1];
                pairs[0] = new Pair<View,String>(binding.igDownArrow,"background_image_transition");

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(ThirdActivity.this,pairs);
                startActivity(intent,options.toBundle());
            }
        });


        binding.btnRoadMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ThirdActivity.this,HotelDetailActivity.class);

                Pair[] pairs = new  Pair[1];
                pairs[0] = new Pair<View,String>(binding.btnRoadMap,"background_image_transition");

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