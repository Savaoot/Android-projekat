package com.example.mirol.androidprojekat.model;

import com.example.mirol.androidprojekat.model.Post;

import java.util.List;

public class Tag {

    private int id;
    private String name;
    private List<Post> posts;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
