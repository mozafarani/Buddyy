package com.example.buddyy;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Search extends AppCompatActivity {

    RecyleViewSearch adapter;
    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setContentView(R.layout.searcher);

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

        ArrayList<String> people = new ArrayList<>();
        List<Integer> pictures = new ArrayList<>();

        people.add("Raven Reyes");
        people.add("Maxwell James");
        people.add("Ava Alzafarani");
        people.add("Hannah Baker");
        people.add("Levi Strootman");
        people.add("Raven Reyes");
        people.add("Maxwell James");
        people.add("Ava Alzafarani");
        people.add("Hannah Baker");
        people.add("Levi Strootman");

        pictures.add(R.drawable.prof);


        pictures.add(R.drawable.cas);

        pictures.add(R.drawable.baby);

        pictures.add(R.drawable.bestfriend);
        pictures.add(R.drawable.mancool);
        pictures.add(R.drawable.prof);


        pictures.add(R.drawable.cas);

        pictures.add(R.drawable.baby);

        pictures.add(R.drawable.bestfriend);
        pictures.add(R.drawable.mancool);



        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyleViewSearch(this, people,pictures);
        adapter.setClickListener(this::onItemClick);
        recyclerView.setAdapter(adapter);

    }

    public void onItemClick(View view, int position) {
        Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
    }
}

