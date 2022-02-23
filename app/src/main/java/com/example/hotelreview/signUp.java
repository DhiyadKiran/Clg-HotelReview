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

import com.example.hotelreview.databinding.ActivitySignUpBinding;

public class signUp extends AppCompatActivity {



    private ActivitySignUpBinding binding;
    private  String Name,Email,Password;


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
                    Toast.makeText(signUp.this, "Profile Saved...", Toast.LENGTH_SHORT).show();

                    Name = binding.edUserName.getText().toString();
                    Email = binding.edEmail.getText().toString();
                    Password = binding.edPassword.getText().toString();

                    StoreUserDetails(Name, Email, Password);

                    Intent intent = new Intent(signUp.this, SignIn.class);
                    startActivity(intent);
                }
            }
        });

    }

    private SharedPreferences StoreUserDetails(String UserName , String UserEmail, String UserPassword)
    {
        SharedPreferences spf = signUp.this.getSharedPreferences("UserDetails" , Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = spf.edit();
        editor.putString("UserName" , UserName);
        editor.putString("UserEmail" , UserEmail);
        editor.putString("UserPassword" , UserPassword);
        editor.apply();
        return spf;
    }
}