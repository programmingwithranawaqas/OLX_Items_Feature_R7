package com.example.olx_items_feature;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvItems;
    LinearLayoutManager manager;
    ItemAdapter adapter;

    FloatingActionButton fabAddItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        init();

        fabAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addItem();

            }
        });


    }

    private void addItem()
    {
        AlertDialog.Builder addDialog = new AlertDialog.Builder(MainActivity.this);
        addDialog.setTitle("New Item");
        View v = LayoutInflater
                .from(MainActivity.this)
                .inflate(R.layout.add_item_form, null, false);
        addDialog.setView(v);
        EditText etName = v.findViewById(R.id.etNAme);
        EditText etUrl = v.findViewById(R.id.etImgUrl);
        EditText etAddress = v.findViewById(R.id.etAddress);
        EditText etDesc = v.findViewById(R.id.etDesc);
        EditText etPrice = v.findViewById(R.id.etPrice);

        addDialog.setPositiveButton("Save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String name = etName.getText().toString().trim();
                String url = etUrl.getText().toString().trim();
                String desc = etDesc.getText().toString().trim();
                String price = etPrice.getText().toString().trim();
                String address = etAddress.getText().toString().trim();
                Date today = new Date();

               // String url, String name, String desc, String location, Date dateAndTime, boolean fav, float price
                Item item = new Item(url, name, desc, address, today, false, Float.parseFloat(price));
                MyApplication.items.add(item);
                adapter.notifyDataSetChanged();

            }
        });
        addDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        addDialog.show();


    }

    private void init()
    {
        rvItems = findViewById(R.id.rvItems);
        fabAddItem = findViewById(R.id.fabAddItem);
        rvItems.setHasFixedSize(true);
        //manager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true);

        rvItems.setLayoutManager(new GridLayoutManager(this, 3));
        adapter = new ItemAdapter(this, MyApplication.items);
        rvItems.setAdapter(adapter);
    }
}