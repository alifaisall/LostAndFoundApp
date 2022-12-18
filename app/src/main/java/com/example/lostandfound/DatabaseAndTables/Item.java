package com.example.lostandfound.DatabaseAndTables;

public class Item {

    int id;
    String type;
    String title;
    String description;
    String category;
    String date;
    String location;
    String image;

    public Item() {

    }

    public Item(int id, String type, String title, String description, String category, String date, String location, String image) {
        this.id = id;
        this.type = type;
        this.title = title;
        this.description = description;
        this.category = category;
        this.date = date;
        this.location = location;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
