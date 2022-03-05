package com.example.hotelreview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ActionMenuView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hotelreview.Api.ApiUtilities;
import com.example.hotelreview.Model.Responce;
import com.example.hotelreview.databinding.ActivitySignUpBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class signUp extends AppCompatActivity {



    private ActivitySignUpBinding binding;
    private  String name,email,password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        binding.txClickSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(signUp.this,SignIn.class);
                startActivity(intent);

            }
        });

        binding.btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.edUserName.getText().toString().isEmpty()) {
                    binding.edUserName.setError("Please Enter Name");
                } else if (binding.edUserName.getText().toString().length() < 4) {
                    binding.edUserName.setError("Name must be Minimum 3 characters");
                } else if (binding.edEmail.getText().toString().isEmpty()) {
                    binding.edEmail.setError("Please Enter Email In Valid Format");
                } else if (!(binding.edEmail.getText().toString().contains("@"))) {
                    binding.edEmail.setError("Please Enter Email In Valid Format");
                } else if (!(binding.edEmail.getText().toString().endsWith(".com"))) {
                    binding.edEmail.setError("Please Enter Email In Valid Format");
                } else if (binding.edPassword.getText().toString().isEmpty()) {
                    binding.edPassword.setError("Please Enter Password");
                }else if(binding.edPassword.getText().toString().length() < 8 ) {
                    binding.edPassword.setError("Password Must Be Minimum 8 Characters");
                } else {
//                    Toast.makeText(signUp.this, "Profile Saved...", Toast.LENGTH_SHORT).show();

                    name = binding.edUserName.getText().toString();
                    email = binding.edEmail.getText().toString();
                    password = binding.edPassword.getText().toString();


                    Call<Responce> call = ApiUtilities
                            .getInstance()
                            .getApi()
                            .UserDetails(name,email,password);

                    call.enqueue(new Callback<Responce>() {
                        @Override
                        public void onResponse(Call<Responce> call, Response<Responce> response) {
                            Responce model = response.body();
                            if (model != null) {
                                if (model.getMessage().equals("fail")) {
                                    Toast.makeText(signUp.this, "Something Went Wrong!!", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(signUp.this, "" + model.getMessage(), Toast.LENGTH_SHORT).show();



                                    Intent intent = new Intent(signUp.this, SignIn.class);
                                    startActivity(intent);
                                }
                            }
                        }

                        @Override
                        public void onFailure(Call<Responce> call, Throwable t) {
                            Toast.makeText(signUp.this, "Something Went Wrong!!", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });

    }


}