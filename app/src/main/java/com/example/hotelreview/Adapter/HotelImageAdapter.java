package com.example.hotelreview.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hotelreview.Model.HotelImage;
import com.example.hotelreview.R;
import com.example.hotelreview.databinding.ImageSampleBinding;

import java.util.ArrayList;

public class HotelImageAdapter extends RecyclerView.Adapter<HotelImageAdapter.viewHolder> {

    Context context;
    ArrayList<HotelImage> hotelImages;

    public HotelImageAdapter(Context context, ArrayList<HotelImage> hotelImages) {
        this.context = context;
        this.hotelImages = hotelImages;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.image_sample,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        HotelImage hotelImage = hotelImages.get(position);

        holder.binding.igImages.setImageResource(hotelImage.getImage());

    }

    @Override
    public int getItemCount() {
        return hotelImages.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder{
        ImageSampleBinding binding;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            binding = ImageSampleBinding.bind(itemView);
        }
    }
}
