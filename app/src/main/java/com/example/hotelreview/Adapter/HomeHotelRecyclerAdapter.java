package com.example.hotelreview.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hotelreview.MainActivity;
import com.example.hotelreview.Model.HomeHotel;
import com.example.hotelreview.R;
import com.example.hotelreview.SecondActivity;
import com.example.hotelreview.databinding.HomeHotelSampleBinding;

import java.util.ArrayList;

public class HomeHotelRecyclerAdapter extends RecyclerView.Adapter<HomeHotelRecyclerAdapter.viewHolder>{

    Context context;
    ArrayList<HomeHotel> homeHotels;

    public HomeHotelRecyclerAdapter(Context context, ArrayList<HomeHotel> homeHotels) {
        this.context = context;
        this.homeHotels = homeHotels;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         View view = LayoutInflater.from(context).inflate(R.layout.home_hotel_sample,parent,false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        HomeHotel homeHotel = homeHotels.get(position);

        holder.binding.igHotelImage.setImageResource(homeHotel.getHotelImage());
        holder.binding.txHotelName.setText(homeHotel.getHotelName());
        holder.binding.rbRatingBar.setRating(homeHotel.getHotelRating());
        holder.binding.txRatingNumber.setText(homeHotel.getHotelRatingNumber());
        holder.binding.txCityName.setText(homeHotel.getCityName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,SecondActivity.class);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return homeHotels.size();
    }


    public  static class viewHolder extends RecyclerView.ViewHolder{
        HomeHotelSampleBinding binding;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            binding = HomeHotelSampleBinding.bind(itemView);
        }
    }
}
