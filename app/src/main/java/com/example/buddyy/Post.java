package com.example.buddyy;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;


public class Post extends AppCompatActivity {

    private Button makePost;

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
                        break;
                    case R.id.search:
                        intent = new Intent(Post.this,Search.class);
                        startActivity(intent);
                        break;
                    case R.id.post:
                        break;

                    case R.id.message:
                        intent = new Intent(Post.this,Message.class);
                        startActivity(intent);
                        break;
                    case R.id.profile:
                        intent = new Intent(Post.this,Profile.class);
                        startActivity(intent);
                        break;
                }



                return false;
            }
        });

        makePost = (Button) findViewById(R.id.makePost);

    }
    public void newPost(View view){

    }

}

