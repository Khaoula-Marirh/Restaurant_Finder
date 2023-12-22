package com.example.restaurant_finder.model;

public class Magasin {
    public String restaurants,adress;
    public int phone;

    public Magasin(String restaurants, String adress,int phone) {
        this.restaurants = restaurants;
        this.adress = adress;
        this.phone = phone;
    }

    public String getRestaurants() {
        return restaurants;
    }

    public String getAdress() {
        return adress;
    }

    public int getPhone() {
        return phone;
    }

    public void setRestaurants(String restaurants) {
        this.restaurants = restaurants;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
}
