package com.example.fnal.model;

public class ProductCategory {
    public String Categ;
    public String image;

    public ProductCategory(String categ, String image) {
        Categ = categ;
        this.image = image;
    }

    public String getCateg() {
        return Categ;
    }

    public void setCateg(String categ) {
        Categ = categ;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
