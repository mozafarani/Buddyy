package com.example.buddyy;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {
    RecyclerViewHome adapter;
    private FirebaseAuth firebaseAuth;
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
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        Home.this.finish();
                        break;
                    case R.id.post:
                        intent = new Intent(Home.this,Post.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        Home.this.finish();
                        break;

                    case R.id.message:
                        intent = new Intent(Home.this,Message.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        Home.this.finish();
                        break;
                    case R.id.profile:
                        intent = new Intent(Home.this, Profile.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        Home.this.finish();
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

        firebaseAuth = FirebaseAuth.getInstance();

    }


}

