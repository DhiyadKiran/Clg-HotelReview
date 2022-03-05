package com.example.hotelreview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.hotelreview.Adapter.HomeHotelRecyclerAdapter;
import com.example.hotelreview.Api.ApiUtilities;
import com.example.hotelreview.Model.HomeHotel;
import com.example.hotelreview.databinding.ActivityMainBinding;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

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


        LoadData();

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

    private void LoadData() {


        Call<List<HomeHotel>> call = ApiUtilities
                .getInstance()
                .getApi()
                .getData();


        call.enqueue(new Callback<List<HomeHotel>>() {
            @Override
            public void onResponse(Call<List<HomeHotel>> call, Response<List<HomeHotel>> response) {
                List<HomeHotel> data =response.body();

                HomeHotelRecyclerAdapter homeHotelRecyclerAdapter = new HomeHotelRecyclerAdapter(MainActivity.this, data);
                binding.rvHomeHotel.setLayoutManager(new GridLayoutManager(MainActivity.this,1));
                binding.rvHomeHotel.setAdapter(homeHotelRecyclerAdapter);
            }

            @Override
            public void onFailure(Call<List<HomeHotel>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.toString(), Toast.LENGTH_LONG).show();
            }
        });

    }
}