package com.example.hotelreview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.hotelreview.databinding.ActivityProfileBinding;

public class ProfileActivity extends AppCompatActivity {

    private ActivityProfileBinding binding;
    private SharedPreferences spf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        spf = this.getSharedPreferences("UserDetails" , Context.MODE_PRIVATE);
        binding.txName.setText(spf.getString("UserName" , null));
        binding.txEmail.setText(spf.getString("UserEmail" , null));

        binding.btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences spf = ProfileActivity.this.getSharedPreferences("UserDetails" , Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = spf.edit();
                editor.clear();
                editor.apply();

                Intent intent = new Intent(ProfileActivity.this, SignIn.class);
                startActivity(intent);
            }
        });

    }
}