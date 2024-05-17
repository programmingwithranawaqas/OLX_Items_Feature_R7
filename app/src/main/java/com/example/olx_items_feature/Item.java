package com.example.olx_items_feature;

import java.util.Date;

public class Item {
    private String url, name, desc, location;
    private Date dateAndTime;
    private boolean fav;
    private float price;

    public Item() {
    }

    public Item(String url, String name, String desc, String location, Date dateAndTime, boolean fav, float price) {
        this.url = url;
        this.name = name;
        this.desc = desc;
        this.location = location;
        this.dateAndTime = dateAndTime;
        this.fav = fav;
        this.price = price;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(Date dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public boolean isFav() {
        return fav;
    }

    public void setFav(boolean fav) {
        this.fav = fav;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
