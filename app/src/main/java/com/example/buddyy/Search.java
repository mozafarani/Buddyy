package com.example.buddyy;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Objects;

public class Search extends AppCompatActivity {
    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setContentView(R.layout.searcher);
        Objects.requireNonNull(getSupportActionBar()).hide();

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavView_Bar);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent intent;
                switch (item.getItemId()){
                    case R.id.home:
                        intent = new Intent(Search.this, Home.class);
                        startActivity(intent);
                        break;
                    case R.id.search:
                        break;
                    case R.id.post:
                        intent = new Intent(Search.this,Post.class);
                        startActivity(intent);
                        break;

                    case R.id.message:
                        intent = new Intent(Search.this,Message.class);
                        startActivity(intent);
                        break;
                    case R.id.profile:
                        intent = new Intent(Search.this,Profile.class);
                        startActivity(intent);
                        break;
                }



                return false;
            }
        });
    }

}

