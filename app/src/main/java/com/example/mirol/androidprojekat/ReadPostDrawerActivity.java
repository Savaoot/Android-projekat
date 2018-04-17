package com.example.mirol.androidprojekat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mirol.androidprojekat.adapter.PostAdapter;
import com.example.mirol.androidprojekat.data.PostRepositoryImpl;
import com.example.mirol.androidprojekat.model.Comment;
import com.example.mirol.androidprojekat.model.Post;
import com.example.mirol.androidprojekat.model.Tag;

public class ReadPostDrawerActivity extends NavigationActivity  {

    private TextView title;
    private TextView author;
    private TextView date;
    private TextView location;
    private TextView likes;
    private TextView dislikes;
    private TextView description;
    private ListView listViewComments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_post_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        PostRepositoryImpl.getInstance().getPostById(0);

        initView();
        populateView();


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ImageView imageView = findViewById(R.id.iv_create_post);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReadPostDrawerActivity.this, CreatePostDrawerActivity.class);
                finish();
                Toast.makeText(ReadPostDrawerActivity.this,"Create post",Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
    }

    private void initView() {
        title = findViewById(R.id.tv_title);
        author = findViewById(R.id.tv_author_name);
        date = findViewById(R.id.tv_date);
        location = findViewById(R.id.tv_location);
        likes = findViewById(R.id.tv_number_likes);
        dislikes = findViewById(R.id.tv_numbers_dislike);
        description = findViewById(R.id.tv_description);
        listViewComments = findViewById(R.id.lv_comments);

    }

    private void populateView() {
        Post post = PostRepositoryImpl.getInstance().getPostById(0);
        title.setText(String.format("%s %s", title.getText(), post.getTitle()));
        author.setText(String.format("%s %s", author.getText(), post.getAuthor().getName()));
        date.setText(DateUtil.convertDateToString(post.getDate()));
        location.setText(post.getLocation().toString());
        likes.setText(""+post.getLike());
        dislikes.setText(""+post.getDislike());
        description.setText(post.getDescription());

        Comment[] comments = new Comment[2];
        comments[0] = post.getComments().get(0);
        comments[1] = post.getComments().get(1);
        PostAdapter postAdapter = new PostAdapter(this,comments);


//        String tags = "";
//        for (Tag tag : post.getTags()){
//            tags += tag.getName() + " ";
//        }
//        //TODO add tags

        listViewComments.setAdapter(postAdapter);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.posts_drawer, menu);
        return true;
    }


}
