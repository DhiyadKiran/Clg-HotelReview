package com.example.hotelreview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.hotelreview.databinding.ActivitySignInBinding;

public class SignIn extends AppCompatActivity {


    private ActivitySignInBinding binding;
    private SharedPreferences spf;
    private String Email,Password, UserPassword,UserEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        spf = this.getSharedPreferences("UserDetails" , Context.MODE_PRIVATE);
        Email =spf.getString("UserEmail" , null);
        Password =spf.getString("UserPassword",null);


        binding.btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserEmail = binding.edEmail.getText().toString();
                UserPassword = binding.edPassword.getText().toString();

                if (UserEmail.equals(Email) && UserPassword.equals(Password)){
                    Intent intent = new Intent(SignIn.this,MainActivity.class);
                    startActivity(intent);

                }
                else {
                    binding.edEmail.setError("Something Went Wrong ");
                    binding.edPassword.setError("Something Went Wrong ");
                }


            }
        });

        binding.txClickSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(SignIn.this,signUp.class);
                startActivity(intent);

            }
        });

    }
}