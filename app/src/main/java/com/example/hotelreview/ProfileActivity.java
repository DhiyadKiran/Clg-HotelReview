package com.example.hotelreview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.hotelreview.Api.ApiUtilities;
import com.example.hotelreview.Model.Responce;
import com.example.hotelreview.databinding.ActivityProfileBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileActivity extends AppCompatActivity {

    private ActivityProfileBinding binding;
    private SharedPreferences spf;
    String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        spf = this.getSharedPreferences("UserDetails", Context.MODE_PRIVATE);
        binding.txName.setText(spf.getString("UserName", null));
        binding.txEmail.setText(spf.getString("UserEmail", null));

        email = binding.txEmail.getText().toString();

        binding.btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences spf = ProfileActivity.this.getSharedPreferences("UserDetails", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = spf.edit();
                editor.clear();
                editor.apply();

                Intent intent = new Intent(ProfileActivity.this, SignIn.class);
                startActivity(intent);
            }
        });


        binding.txDeleteAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Call<Responce> call = ApiUtilities
                        .getInstance()
                        .getApi()
                        .DeleteUser(email);

                call.enqueue(new Callback<Responce>() {
                    @Override
                    public void onResponse(Call<Responce> call, Response<Responce> response) {
                        Responce model = response.body();
                        if (model != null) {
                            if (model.getMessage().equals("fail")) {
                                Toast.makeText(ProfileActivity.this, "Something Went Wrong!!", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(ProfileActivity.this, "" + model.getMessage(), Toast.LENGTH_SHORT).show();

                                SharedPreferences spf = ProfileActivity.this.getSharedPreferences("UserDetails", Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor = spf.edit();
                                editor.clear();
                                editor.apply();

                                Intent intent = new Intent(ProfileActivity.this, SplachScreen.class);
                                startActivity(intent);
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<Responce> call, Throwable t) {
                        Toast.makeText(ProfileActivity.this, "Something Went Wrong!!", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }
}