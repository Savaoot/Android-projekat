package com.example.mirol.androidprojekat.model;

import android.graphics.Bitmap;
import android.location.Location;

import java.util.Date;
import java.util.List;

public class Post {

    private int id;
    private User author;
    private String title;
    private String description;
    private Bitmap photo;
    private Date date;
    private Location location;
    private List<Comment> comments;
    private List<Tag> tags;
    private int like;
    private int dislike;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Bitmap getPhoto() {
        return photo;
    }

    public void setPhoto(Bitmap photo) {
        this.photo = photo;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public int getDislike() {
        return dislike;
    }

    public void setDislike(int dislike) {
        this.dislike = dislike;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public User getAuthor() {
        return author;
    }
}
