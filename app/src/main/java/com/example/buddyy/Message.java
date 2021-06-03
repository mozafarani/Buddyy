package com.example.buddyy;


import android.content.Intent;
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
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Message extends AppCompatActivity {
    MyRecyclerViewAdapter adapter;
    private FirebaseAuth firebaseAuth;

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
                        Message.this.finish();
                        break;
                    case R.id.search:
                        intent = new Intent(Message.this, Search.class);
                        startActivity(intent);
                        Message.this.finish();
                        break;
                    case R.id.post:
                        intent = new Intent(Message.this, Post.class);
                        startActivity(intent);
                        Message.this.finish();
                        break;

                    case R.id.message:

                        break;
                    case R.id.profile:
                        intent = new Intent(Message.this, Profile.class);
                        startActivity(intent);
                        Message.this.finish();
                        break;
                }


                return false;
            }
        });

        // data to populate the RecyclerView with
        ArrayList<String> people = new ArrayList<>();
        List<String> pictures = new ArrayList<>();


        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Users");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                people.clear();
                pictures.clear();


                GenericTypeIndicator<List<List<String>>> genericTypeIndicator = new GenericTypeIndicator<List<List<String>>>() {
                };
                List<List<String>> x = dataSnapshot.getValue(genericTypeIndicator);

                for (List<String> list : x) {
                    people.add(list.get(1));
                    pictures.add(list.get(0));
                }


                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyRecyclerViewAdapter(this, people,pictures);
        adapter.setClickListener(this::onItemClick);
        recyclerView.setAdapter(adapter);

        firebaseAuth = FirebaseAuth.getInstance();
        checkUser();
    }

    public void onItemClick(View view, int position) {
        Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
    }

    private void checkUser() {
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        if(firebaseUser == null){
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }
    }

}

