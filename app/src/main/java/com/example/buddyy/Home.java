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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {
    RecyclerViewHome adapter;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference mDatabase;


    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {

        firebaseAuth = FirebaseAuth.getInstance();

        super.onPostCreate(savedInstanceState);
        setContentView(R.layout.homer);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavView_Bar);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent intent;
                switch (item.getItemId()) {
                    case R.id.home:
                        break;
                    case R.id.search:
                        intent = new Intent(Home.this, Search.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        Home.this.finish();
                        break;
                    case R.id.post:
                        intent = new Intent(Home.this, Post.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        Home.this.finish();
                        break;

                    case R.id.message:
                        intent = new Intent(Home.this, Message.class);
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

        RecyclerView v = (RecyclerView) findViewById(R.id.recyclerhome);
        v.setNestedScrollingEnabled(false);
        List<String> names = new ArrayList<>();
        List<String> pictures = new ArrayList<>();
        List<String> titles = new ArrayList<>();
        List<String> description = new ArrayList<>();

        // set up the RecyclerView
        LinearLayoutManager manager = new LinearLayoutManager(this);
        RecyclerView recyclerView = findViewById(R.id.recyclerhome);
        recyclerView.setLayoutManager(manager);
        adapter = new RecyclerViewHome(this, names, pictures, titles, description);
        recyclerView.setAdapter(adapter);


        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Posts");
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                int i = 0;
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    GenericTypeIndicator<List<Posts>> genericTypeIndicator = new GenericTypeIndicator<List<Posts>>() {
                    };
                    List<Posts> x = dataSnapshot.getValue(genericTypeIndicator);
                    names.add(x.get(i).getUser());
                    pictures.add(x.get(i).getUser());
                    titles.add(x.get(i).getTitle());
                    description.add(x.get(i++).getDescription());
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }


}

