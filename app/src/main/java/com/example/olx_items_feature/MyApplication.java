package com.example.olx_items_feature;

import android.app.Application;
import android.icu.text.SimpleDateFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class MyApplication extends Application {
    public static ArrayList<Item> items;

    @Override
    public void onCreate() {
        super.onCreate();
        items = new ArrayList<>();
        //public Item(String url, String name, String desc, String location, Date dateAndTime, boolean fav, float price) {
        //

        Date date = new Date();

        items.add(new Item("dummy", "Shampoo", "Bio Amla is the best shampoo for pakistanis", "Lahore, Pakistan", date, false, 150));
        items.add(new Item("dummy", "Shampoo", "Bio Amla is the best shampoo for pakistanis", "Lahore, Pakistan", date, false, 300));
        items.add(new Item("dummy", "Shampoo", "Bio Amla is the best shampoo for pakistanis", "Lahore, Pakistan", date, false, 150));
items.add(new Item("dummy", "Shampoo", "Bio Amla is the best shampoo for pakistanis", "Lahore, Pakistan", date, true, 150));
        items.add(new Item("dummy", "Shampoo", "Bio Amla is the best shampoo for pakistanis", "Lahore, Pakistan", date, false, 150));
        items.add(new Item("dummy", "Shampoo", "Bio Amla is the best shampoo for pakistanis", "Lahore, Pakistan", date, false, 750));
items.add(new Item("dummy", "Shampoo", "Bio Amla is the best shampoo for pakistanis", "Lahore, Pakistan", date, false, 150));
        items.add(new Item("dummy", "Shampoo", "Bio Amla is the best shampoo for pakistanis", "Lahore, Pakistan", date, true, 15000));
        items.add(new Item("dummy", "Shampoo", "Bio Amla is the best shampoo for pakistanis", "Lahore, Pakistan", date, false, 150));
items.add(new Item("dummy", "Shampoo", "Bio Amla is the best shampoo for pakistanis", "Lahore, Pakistan", date, false, 150));
        items.add(new Item("dummy", "Shampoo", "Bio Amla is the best shampoo for pakistanis", "Lahore, Pakistan", date, false, 150));
        items.add(new Item("dummy", "Shampoo", "Bio Amla is the best shampoo for pakistanis", "Lahore, Pakistan", date, false, 150));

    }
}
