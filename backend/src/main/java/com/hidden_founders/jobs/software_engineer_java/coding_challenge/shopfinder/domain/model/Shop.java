package com.hidden_founders.jobs.software_engineer_java.coding_challenge.shopfinder.domain.model;

import com.hidden_founders.jobs.software_engineer_java.coding_challenge.shopfinder.domain.geolocation.Location;

public class Shop {
    private String picture;
    private String name;
    private String email;
    private String city;
    private Location location;

    public Shop(String picture, String name, String email, String city, Location location) {
        this.picture = picture;
        this.name = name;
        this.email = email;
        this.city = city;
        this.location = location;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
