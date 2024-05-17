package com.example.olx_items_feature;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MyViewHolder> {
    ArrayList<Item> data;

    public ItemAdapter(Context c, ArrayList<Item> data)
    {
        this.data= data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_item_design, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Item i = data.get(position);
        holder.tvDesc.setText(i.getDesc());
        holder.tvDate.setText(i.getDateAndTime().toString());
        holder.tvLocation.setText(i.getLocation());
        holder.tvPrice.setText(i.getPrice()+"");


        if(i.isFav())
        {
            holder.ivFav.setImageResource(R.drawable.icon_fav_filled);
        }
        else
        {
            holder.ivFav.setImageResource(R.drawable.icon_fav_hollow);
        }


        holder.ivFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                i.setFav(!i.isFav());
                if(i.isFav())
                {
                    holder.ivFav.setImageResource(R.drawable.icon_fav_filled);
                }
                else
                {
                    holder.ivFav.setImageResource(R.drawable.icon_fav_hollow);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView tvDesc, tvDate, tvLocation, tvPrice;
        ImageView ivFav;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDate = itemView.findViewById(R.id.tvTime);

            tvDesc = itemView.findViewById(R.id.tvDesc);
            tvLocation = itemView.findViewById(R.id.tvLoc);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            ivFav = itemView.findViewById(R.id.ivFavourite);


        }
    }
}
