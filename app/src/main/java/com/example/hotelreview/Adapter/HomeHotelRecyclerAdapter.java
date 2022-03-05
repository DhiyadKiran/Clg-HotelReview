package com.example.hotelreview.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.hotelreview.Api.ApiUtilities;
import com.example.hotelreview.MainActivity;
import com.example.hotelreview.Model.HomeHotel;
import com.example.hotelreview.R;
import com.example.hotelreview.SecondActivity;
import com.example.hotelreview.databinding.HomeHotelSampleBinding;

import java.util.ArrayList;
import java.util.List;

public class HomeHotelRecyclerAdapter extends RecyclerView.Adapter<HomeHotelRecyclerAdapter.viewHolder>{

    Context context;
    List<HomeHotel> data;

    public HomeHotelRecyclerAdapter(Context context, List<HomeHotel> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         View view = LayoutInflater.from(context).inflate(R.layout.home_hotel_sample,parent,false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        HomeHotel homeHotel = data.get(position);

        holder.binding.txHotelName.setText(homeHotel.getName());
        holder.binding.txCityName.setText(homeHotel.getCity());
        holder.binding.txRatingNumber.setText(homeHotel.getRating());
        holder.binding.rbRatingBar.setRating(Float.parseFloat(homeHotel.getRating()));
//        Toast.makeText(context, ""+ApiUtilities.imageUrl+homeHotel.getMainimage(), Toast.LENGTH_SHORT).show();
        Glide.with(context).load(ApiUtilities.imageUrl+homeHotel.getMainimage()).into(holder.binding.igHotelImage);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, SecondActivity.class);
                i.putExtra("id",homeHotel.getId());
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public  static class viewHolder extends RecyclerView.ViewHolder{
        HomeHotelSampleBinding binding;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            binding = HomeHotelSampleBinding.bind(itemView);
        }
    }
}
