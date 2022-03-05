package com.example.hotelreview;

import androidx.annotation.NonNull;
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
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.hotelreview.Api.ApiUtilities;
import com.example.hotelreview.Model.AllDetail;
import com.example.hotelreview.databinding.ActivityMainBinding;
import com.example.hotelreview.databinding.ActivitySecondBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SecondActivity extends AppCompatActivity {

    Animation from_left,from_right,from_bottom;
    private ActivitySecondBinding binding;
    private String id;
    private String name,city,rating,number,address,price,venuetype,facility,about,mainimage,bgimage,images;


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

        Intent i = getIntent();
        id = i.getStringExtra("id");

//        Toast.makeText(this, ""+id, Toast.LENGTH_SHORT).show();

        LoadData();

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

    private void LoadData() {

        Call<AllDetail> call = ApiUtilities
                .getInstance()
                .getApi()
                .getDetail(Integer.parseInt(id));


        call.enqueue(new Callback<AllDetail>() {
            @Override
            public void onResponse(Call<AllDetail> call, Response<AllDetail> response) {
                AllDetail allDetail = response.body();

                  binding.txHotelName.setText(allDetail.getName());
                  binding.txRatingNumber.setText(allDetail.getRating());
                  binding.rbRatingBar.setRating(Float.parseFloat(allDetail.getRating()));
                Glide.with(SecondActivity.this).load(ApiUtilities.imageUrl+allDetail.getBgimage()).into(binding.igBackgroundHotelImage);


                name =allDetail.getName();
                city = allDetail.getCity();
                rating = allDetail.getRating();
                number = allDetail.getNumber();
                address = allDetail.getAddress();
                price = String.valueOf(allDetail.getPrice());
                venuetype = allDetail.getVenuetype();
                facility = allDetail.getFacility();
                about = allDetail.getAbout();
                mainimage = allDetail.getMainimage();
                bgimage = allDetail.getBgimage();
                images = allDetail.getImages();

                StoreHotelDetails(name,city,rating,number,address,price,venuetype,facility,about,mainimage,bgimage,images);

            }

            @Override
            public void onFailure(Call<AllDetail> call, Throwable t) {
                Toast.makeText(SecondActivity.this, t.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @NonNull
    private SharedPreferences StoreHotelDetails(String name, String city, String rating, String number, String address, String price, String venuetype, String facility, String about, String mainimage, String bgimage, String images)
    {
        SharedPreferences spf = SecondActivity.this.getSharedPreferences("HotelDetails" , Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = spf.edit();
        editor.putString("name" , name);
        editor.putString("city" , city);
        editor.putString("rating" , rating);
        editor.putString("number" , number);
        editor.putString("address" , address);
        editor.putString("price" ,price );
        editor.putString("venuetype" ,venuetype );
        editor.putString("facility" , facility);
        editor.putString("about" ,about );
        editor.putString("mainimage" , mainimage);
        editor.putString("bgimage" , bgimage);
        editor.putString("images" , images);
        editor.apply();
        return spf;
    }



}