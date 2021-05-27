package com.example.buddyy;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Home extends AppCompatActivity {
    RecyclerViewHome adapter;
    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setContentView(R.layout.homer);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavView_Bar);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent intent;
                switch (item.getItemId()){
                    case R.id.home:
                        break;
                    case R.id.search:
                        intent = new Intent(Home.this,Search.class);
                        startActivity(intent);
                        break;
                    case R.id.post:
                        intent = new Intent(Home.this,Post.class);
                        startActivity(intent);
                        break;

                    case R.id.message:
                        intent = new Intent(Home.this,Message.class);
                        startActivity(intent);
                        break;
                    case R.id.profile:
                        intent = new Intent(Home.this, Profile.class);
                        startActivity(intent);
                        break;
                }



                return false;
            }
        });

        List<String> names = new ArrayList<>();
        List<Integer> pictures = new ArrayList<>();
        List<String> titles = new ArrayList<>();
        List<String> description = new ArrayList<>();

        names.add("Abdullah Alzafarani");
        pictures.add(R.drawable.mancool);
        description.add("I have been lonely my whole life, but this app changed my life completely. I have found my best friend on here and soulmate too.");
        titles.add("I love this new app!");

        names.add("Abdullah Alzafarani");
        pictures.add(R.drawable.mancool);
        description.add("I have been lonely my whole life, but this app changed my life completely. I have found my best friend on here and soulmate too.");
        titles.add("I love this new app!");

        names.add("Abdullah Alzafarani");
        pictures.add(R.drawable.mancool);
        description.add("I have been lonely my whole life, but this app changed my life completely. I have found my best friend on here and soulmate too.");
        titles.add("I love this new app!");

        names.add("Abdullah Alzafarani");
        pictures.add(R.drawable.mancool);
        description.add("I have been lonely my whole life, but this app changed my life completely. I have found my best friend on here and soulmate too.");
        titles.add("I love this new app!");

        names.add("Abdullah Alzafarani");
        pictures.add(R.drawable.mancool);
        description.add("I have been lonely my whole life, but this app changed my life completely. I have found my best friend on here and soulmate too.");
        titles.add("I love this new app!");

        names.add("Abdullah Alzafarani");
        pictures.add(R.drawable.mancool);
        description.add("I have been lonely my whole life, but this app changed my life completely. I have found my best friend on here and soulmate too.");
        titles.add("I love this new app!");

        names.add("Abdullah Alzafarani");
        pictures.add(R.drawable.mancool);
        description.add("I have been lonely my whole life, but this app changed my life completely. I have found my best friend on here and soulmate too.");
        titles.add("I love this new app!");

        names.add("Abdullah Alzafarani");
        pictures.add(R.drawable.mancool);
        description.add("I have been lonely my whole life, but this app changed my life completely. I have found my best friend on here and soulmate too.");
        titles.add("I love this new app!");

        names.add("Abdullah Alzafarani");
        pictures.add(R.drawable.mancool);
        description.add("I have been lonely my whole life, but this app changed my life completely. I have found my best friend on here and soulmate too.");
        titles.add("I love this new app!");

        names.add("Abdullah Alzafarani");
        pictures.add(R.drawable.mancool);
        description.add("I have been lonely my whole life, but this app changed my life completely. I have found my best friend on here and soulmate too.");
        titles.add("I love this new app!");

        // set up the RecyclerView
        LinearLayoutManager manager  = new LinearLayoutManager(this);
        RecyclerView recyclerView = findViewById(R.id.recyclerhome);
        recyclerView.setLayoutManager(manager);
        adapter = new RecyclerViewHome(this, names, pictures, titles, description);
        recyclerView.setAdapter(adapter);


    }

}

