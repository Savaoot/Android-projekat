package com.example.mirol.androidprojekat.data;

import android.location.Location;

import com.example.mirol.androidprojekat.model.Comment;
import com.example.mirol.androidprojekat.model.Post;
import com.example.mirol.androidprojekat.model.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class PostRepositoryImpl implements PostRepositoty{

    private static PostRepositoryImpl instance;

    public static PostRepositoryImpl getInstance(){
        if(instance == null){
            instance = new PostRepositoryImpl();
        }
        return instance;
    }

    @Override
    public Post getPostById(int id) {
        Post createPost = new Post();
        createPost.setId(0);
        createPost.setTitle("Naslov");
        createPost.setDate(new Date());
        createPost.setDescription("Opis");
        createPost.setLike(560);
        createPost.setDislike(25);
        //LOCATION
        Location location =new Location("NS");
        location.setLatitude(45.2671352);
        location.setLongitude(19.8335496);
        createPost.setLocation(location);
        //USER
        User user = new User();
        user.setId(0);
        user.setName("Perica");
        user.setUsername("pera");
        createPost.setAuthor(user);
        //COMENTARS
        Comment comment = new Comment();
        comment.setAuthor(user);
        comment.setDate(new Date());
        comment.setDescription("Opis1");
        comment.setDislikes(10);
        comment.setLikes(589);
        comment.setPost(createPost);
        comment.setTitle("Naslov1");

        Comment comment1 = new Comment();
        comment1.setAuthor(user);
        comment1.setDate(new Date());
        comment1.setDescription("Opis2");
        comment1.setDislikes(2);
        comment1.setLikes(3);
        comment1.setPost(createPost);
        comment1.setTitle("Naslov2");

        List<Comment> comments = new ArrayList<>();
        comments.add(comment);
        comments.add(comment1);

        createPost.setComments(comments);


        return createPost;
    }
}
