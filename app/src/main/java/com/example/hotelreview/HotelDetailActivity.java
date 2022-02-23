package com.example.hotelreview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.hotelreview.Adapter.HotelImageAdapter;
import com.example.hotelreview.Model.HotelImage;
import com.example.hotelreview.databinding.ActivityHotelDetailBinding;

import java.util.ArrayList;

public class HotelDetailActivity extends AppCompatActivity {

    private ActivityHotelDetailBinding binding;
    Animation from_bottom;
    ArrayList<HotelImage> hotelImages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHotelDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        from_bottom = AnimationUtils.loadAnimation(this,R.anim.anim_from_bottom);

        binding.svScrollView.setAnimation(from_bottom);

        binding.igBackArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(HotelDetailActivity.this,ThirdActivity.class);
                startActivity(intent);
            }
        });


        hotelImages = new ArrayList<>();
        hotelImages.add(new HotelImage(R.drawable.hotel10));
        hotelImages.add(new HotelImage(R.drawable.hotel2));
        hotelImages.add(new HotelImage(R.drawable.hotel3));
        hotelImages.add(new HotelImage(R.drawable.hotel4));
        hotelImages.add(new HotelImage(R.drawable.hotel5));
        hotelImages.add(new HotelImage(R.drawable.hotel6));
        hotelImages.add(new HotelImage(R.drawable.hotel7));
        hotelImages.add(new HotelImage(R.drawable.hotel8));
        hotelImages.add(new HotelImage(R.drawable.hotel9));
        hotelImages.add(new HotelImage(R.drawable.hotel10));

        HotelImageAdapter hotelImageAdapter = new HotelImageAdapter(HotelDetailActivity.this,hotelImages);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(HotelDetailActivity.this,1, RecyclerView.HORIZONTAL,false);
        binding.rvImages.setLayoutManager(gridLayoutManager);
        binding.rvImages.setAdapter(hotelImageAdapter);





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