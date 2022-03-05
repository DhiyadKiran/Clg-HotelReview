package com.example.hotelreview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hotelreview.Api.ApiUtilities;
import com.example.hotelreview.Model.Responce;
import com.example.hotelreview.Model.UserDetails;
import com.example.hotelreview.databinding.ActivitySignInBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignIn extends AppCompatActivity {


    private ActivitySignInBinding binding;
    private SharedPreferences spf;
    private String Email,Password, UserPassword,UserEmail,DBName,DBEmail,DBPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        spf = this.getSharedPreferences("UserDetails" , Context.MODE_PRIVATE);
//        Email =spf.getString("UserEmail" , null);
//        Password =spf.getString("UserPassword",null);


        binding.btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Email = binding.edEmail.getText().toString();
                Password = binding.edPassword.getText().toString();

//                if (UserEmail.equals(Email) && UserPassword.equals(Password)){
//
//
//                    Intent intent = new Intent(SignIn.this,MainActivity.class);
//                    startActivity(intent);
//
//                }
//                else {
//                    binding.edEmail.setError("Something Went Wrong ");
//                    binding.edPassword.setError("Something Went Wrong ");
//                }

                Call<UserDetails> call = ApiUtilities
                        .getInstance()
                        .getApi()
                        .ReadUser(Email,Password);

                call.enqueue(new Callback<UserDetails>() {
                    @Override
                    public void onResponse(Call<UserDetails> call, Response<UserDetails> response) {
                        UserDetails model = response.body();
                        if (model != null) {

                            DBEmail = model.getEmail();
                            DBPassword = model.getPassword();
                            DBName = model.getName();

                            if (DBEmail.equals(Email) && DBPassword.equals(Password)) {
                                StoreUserDetails(DBName,DBEmail,DBPassword);

                                Intent intent = new Intent(SignIn.this, MainActivity.class);
                                startActivity(intent);
                            } else {

                                binding.edEmail.setError("Something Went Wrong ");
                                binding.edPassword.setError("Something Went Wrong ");

                            }

                        }
                    }

                    @Override
                    public void onFailure(Call<UserDetails> call, Throwable t) {

                    }
                });


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


    private SharedPreferences StoreUserDetails(String UserName , String UserEmail, String UserPassword)
    {
        SharedPreferences spf = SignIn.this.getSharedPreferences("UserDetails" , Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = spf.edit();
        editor.putString("UserName" , UserName);
        editor.putString("UserEmail" , UserEmail);
        editor.putString("UserPassword" , UserPassword);
        editor.apply();
        return spf;
    }
}