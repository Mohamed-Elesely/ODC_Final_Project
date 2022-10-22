package com.example.fnal.model;

import java.io.Serializable;

public class Products implements Serializable {

    public int id;
    public String title;
    public double price;
    public String description;
    public String category;
    public String image;
    public Rating rating;

    public Products(int id, String title, double price, String description, String category, String image, Rating rating) {
        this.id=id;
        this.price=price;
        this.description=description;
        this.category=category;
        this.title=title;
        this.image=image;
        this.rating=rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


}
