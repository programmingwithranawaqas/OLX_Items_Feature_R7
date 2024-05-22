package com.example.olx_items_feature;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Date;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MyViewHolder> {
    ArrayList<Item> data;
    Context context;

    public ItemAdapter(Context c, ArrayList<Item> data)
    {
        this.data= data;
        context = c;
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
        Item i = data.get(holder.getAdapterPosition());

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

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                AlertDialog.Builder addDialog = new AlertDialog.Builder(context);
                addDialog.setTitle("Edit or delete item");
                View v = LayoutInflater
                        .from(context)
                        .inflate(R.layout.add_item_form, null, false);
                addDialog.setView(v);
                EditText etName = v.findViewById(R.id.etNAme);
                EditText etUrl = v.findViewById(R.id.etImgUrl);
                EditText etAddress = v.findViewById(R.id.etAddress);
                EditText etDesc = v.findViewById(R.id.etDesc);
                EditText etPrice = v.findViewById(R.id.etPrice);
                etName.setText(i.getName());
                etUrl.setText(i.getUrl());
                etDesc.setText(i.getDesc());
                etPrice.setText(i.getPrice()+"");
                etAddress.setText(i.getLocation());

                addDialog.setPositiveButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String name = etName.getText().toString().trim();
                        String url = etUrl.getText().toString().trim();
                        String desc = etDesc.getText().toString().trim();
                        String price = etPrice.getText().toString().trim();
                        String address = etAddress.getText().toString().trim();
                        Date today = new Date();

                        // String url, String name, String desc, String location, Date dateAndTime, boolean fav, float price
                        i.setName(name);
                        i.setDesc(desc);
                        i.setLocation(address);
                        i.setPrice(Float.parseFloat(price));
                        i.setUrl(url);
                        i.setDateAndTime(today);
                        Toast.makeText(context, "Record updated", Toast.LENGTH_SHORT).show();

                        notifyItemChanged(holder.getAdapterPosition());
                    }
                });
                addDialog.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int pos = holder.getAdapterPosition();
                        MyApplication.items.remove(pos);
                        notifyItemRemoved(pos);
                        Toast.makeText(context, "Record deleted", Toast.LENGTH_SHORT).show();
                    }
                });

                addDialog.show();

                return false;
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
