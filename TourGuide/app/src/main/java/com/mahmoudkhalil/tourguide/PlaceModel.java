package com.mahmoudkhalil.tourguide;

public class PlaceModel {
    private String name;
    private String description;
    private String city;
    private String address;
    private String phone;
    private int imageResID;
    private float rate;

    public PlaceModel(String name, String description, String city, String address, String phone, int imageResID, float rate) {
        this.name = name;
        this.description = description;
        this.city = city;
        this.address = address;
        this.phone = phone;
        this.imageResID = imageResID;
        this.rate = rate;
    }

    public PlaceModel(String name, String description,String city, String address, int imageResID, float rate) {
        this.name = name;
        this.description = description;
        this.city = city;
        this.address = address;
        this.imageResID = imageResID;
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getImageResID() {
        return imageResID;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getCity() {
        return city;
    }

    public float getRate() {
        return rate;
    }
}
