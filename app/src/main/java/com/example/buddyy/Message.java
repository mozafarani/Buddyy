package com.example.buddyy;


import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.shadow.ShadowDrawableWrapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import de.hdodenhof.circleimageview.CircleImageView;

public class Message extends AppCompatActivity {
    MyRecyclerViewAdapter adapter;
    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setContentView(R.layout.messeger);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavView_Bar);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent intent;
                switch (item.getItemId()) {
                    case R.id.home:
                        intent = new Intent(Message.this, Home.class);
                        startActivity(intent);
                        break;
                    case R.id.search:
                        intent = new Intent(Message.this, Search.class);
                        startActivity(intent);
                        break;
                    case R.id.post:
                        intent = new Intent(Message.this, Post.class);
                        startActivity(intent);
                        break;

                    case R.id.message:

                        break;
                    case R.id.profile:
                        intent = new Intent(Message.this, Profile.class);
                        startActivity(intent);
                        break;
                }


                return false;
            }
        });

        // data to populate the RecyclerView with
        ArrayList<String> animalNames = new ArrayList<>();
        List<Drawable> pictures = new ArrayList<Drawable>();
        for(int i = 0; i<1;i++){
            animalNames.add("lol " + i);
        }
        Drawable image=(Drawable)getResources().getDrawable(R.drawable.message);
        pictures.add(image);

        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyRecyclerViewAdapter(this, animalNames,pictures);
        adapter.setClickListener(this::onItemClick);
        recyclerView.setAdapter(adapter);
    }

    public void onItemClick(View view, int position) {
        Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
    }

}

