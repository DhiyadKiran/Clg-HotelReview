package com.example.hotelreview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.example.hotelreview.Adapter.HomeHotelRecyclerAdapter;
import com.example.hotelreview.Model.HomeHotel;
import com.example.hotelreview.databinding.ActivityMainBinding;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<HomeHotel> homeHotels;
    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         binding = ActivityMainBinding.inflate(getLayoutInflater());
         setContentView(binding.getRoot());


        binding.igProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent secondActivity = new Intent(MainActivity.this,ProfileActivity.class);
                startActivity(secondActivity);
            }
        });

        homeHotels = new ArrayList<>();
        homeHotels.add(new HomeHotel(R.drawable.image_one,"The START Hotel,Casino & Skypod", 4.5F,"4.5"));
        homeHotels.add(new HomeHotel(R.drawable.image_two,"Sky Bar at Waldorf Astoria", 4.3F,"4.3"));
        homeHotels.add(new HomeHotel(R.drawable.image_three,"The Boulevard Pool at The Cosmopolitan", 4F,"4"));
        homeHotels.add(new HomeHotel(R.drawable.image_one,"The START Hotel & Skypod", 5F,"5"));
        homeHotels.add(new HomeHotel(R.drawable.image_two,"The START Hotel,Casino & Skypod", 4.5F,"4.5"));

        HomeHotelRecyclerAdapter homeHotelRecyclerAdapter =new HomeHotelRecyclerAdapter(MainActivity.this,homeHotels);
        GridLayoutManager gridLayoutManager =new GridLayoutManager(MainActivity.this,1);
        binding.rvHomeHotel.setLayoutManager(gridLayoutManager);
        binding.rvHomeHotel.setAdapter(homeHotelRecyclerAdapter);

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