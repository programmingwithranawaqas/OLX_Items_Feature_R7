package com.example.olx_items_feature;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvItems;
    LinearLayoutManager manager;
    ItemAdapter adapter;

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


    }

    private void init()
    {
        rvItems = findViewById(R.id.rvItems);
        rvItems.setHasFixedSize(true);
        //manager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true);

        rvItems.setLayoutManager(new GridLayoutManager(this, 3));
        adapter = new ItemAdapter(this, MyApplication.items);
        rvItems.setAdapter(adapter);
    }
}