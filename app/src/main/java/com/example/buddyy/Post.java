package com.example.buddyy;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;


public class Post extends AppCompatActivity {

    private Button makePost;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setContentView(R.layout.poster);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavView_Bar);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent intent;
                switch (item.getItemId()){
                    case R.id.home:
                        intent = new Intent(Post.this, Home.class);
                        startActivity(intent);
                        Post.this.finish();
                        break;
                    case R.id.search:
                        intent = new Intent(Post.this,Search.class);
                        startActivity(intent);
                        Post.this.finish();
                        break;
                    case R.id.post:
                        break;

                    case R.id.message:
                        intent = new Intent(Post.this,Message.class);
                        startActivity(intent);
                        Post.this.finish();
                        break;
                    case R.id.profile:
                        intent = new Intent(Post.this,Profile.class);
                        startActivity(intent);
                        Post.this.finish();
                        break;
                }



                return false;
            }
        });
        firebaseAuth = FirebaseAuth.getInstance();


        makePost = (Button) findViewById(R.id.makePost);

    }
}

