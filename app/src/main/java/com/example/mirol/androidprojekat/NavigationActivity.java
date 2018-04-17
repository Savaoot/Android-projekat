package com.example.mirol.androidprojekat;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;

public class NavigationActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_posts) {
            Intent intent = new Intent(NavigationActivity.this, PostsDrawerActivity.class);
            finish();
            Toast.makeText(this,"Posts",Toast.LENGTH_SHORT).show();
            startActivity(intent);
        } else if (id == R.id.nav_settings) {
            Intent intent = new Intent(NavigationActivity.this, SettingsActivity.class);
            Toast.makeText(this,"Settings",Toast.LENGTH_SHORT).show();
            startActivity(intent);

        } else if (id == R.id.nav_create) {
            Intent intent = new Intent(NavigationActivity.this, CreatePostDrawerActivity.class);
            finish();
            Toast.makeText(this,"Create post",Toast.LENGTH_SHORT).show();
            startActivity(intent);

        } else if (id == R.id.nav_read) {
            Intent intent = new Intent(NavigationActivity.this, ReadPostDrawerActivity.class);
            finish();
            Toast.makeText(this,"Read post",Toast.LENGTH_SHORT).show();
            startActivity(intent);

        } else if (id == R.id.nav_logout) {
            Intent intent = new Intent(NavigationActivity.this, LoginActivity.class);
            finish();
            Toast.makeText(this,"Logout",Toast.LENGTH_SHORT).show();
            startActivity(intent);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(NavigationActivity.this, SettingsActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
