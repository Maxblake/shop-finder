package com.hidden_founders.jobs.software_engineer_java.coding_challenge.shopfinder.presentation.dto;

public class ShopDTO {
    private String name;
    private String picture;

    public ShopDTO(String name, String picture) {
        this.name = name;
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "{" +
                "name:" + name + ' ' +
                ", picture:" + picture +
                '}';
    }
}
