package com.example.lostandfound.DatabaseAndTables;


public class Item {

    long id;
    long uid;
    String type;
    String title;
    String description;
    String category;
    String status;
    String date;
    String location;
    String image;

    public Item() {}

    public Item(String type, String title, String description, String category,String status, String date, String location, String image) {
        this.type = type;
        this.title = title;
        this.description = description;
        this.category = category;
        this.status = status;
        this.date = date;
        this.location = location;
        this.image = image;
    }

    public Item(long id,long uid, String type, String title, String description, String category,String status, String date, String location, String image) {
        this.id = id;
        this.uid = uid;
        this.type = type;
        this.title = title;
        this.description = description;
        this.category = category;
        this.status = status;
        this.date = date;
        this.location = location;
        this.image = image;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUid() {return uid;}

    public void setUid(long uid) {this.uid = uid;}

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
