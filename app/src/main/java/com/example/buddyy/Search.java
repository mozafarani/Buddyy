package com.example.buddyy;


import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.widget.EditText;

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

public class Search extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;
    RecyleViewSearch adapter;
    RecyclerView recyclerView;
    private List<String> ppl = new ArrayList<>();
    private List<String> pics = new ArrayList<>();

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setContentView(R.layout.searcher);

        firebaseAuth = FirebaseAuth.getInstance();
        checkUser();

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.searchButtom);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent intent;
                switch (item.getItemId()) {
                    case R.id.home:
                        intent = new Intent(Search.this, Home.class);
                        startActivity(intent);
                        Search.this.finish();
                        break;
                    case R.id.search:
                        break;
                    case R.id.post:
                        intent = new Intent(Search.this, Post.class);
                        startActivity(intent);
                        Search.this.finish();
                        break;

                    case R.id.message:
                        intent = new Intent(Search.this, Message.class);
                        startActivity(intent);
                        Search.this.finish();
                        break;
                    case R.id.profile:
                        intent = new Intent(Search.this, Profile.class);
                        startActivity(intent);
                        Search.this.finish();
                        break;
                }


                return false;
            }
        });

        ArrayList<String> people = new ArrayList<>();
        List<String> pictures = new ArrayList<>();

        String result = FirebaseAuth.getInstance().getUid();

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

        EditText searchText = findViewById(R.id.searchText);

        searchText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                ppl.clear();
                pics.clear();

                if(s.toString().isEmpty()){
                    recyclerView.setAdapter(new RecyleViewSearch(getApplicationContext(), ppl,pics));
                    adapter.notifyDataSetChanged();
                }else{
                    filter(s.toString());
                }

            }

            private void filter(String s) {
                for(int i = 0; i< people.size();i++){
                    String l = people.get(i);
                    if(l.contains(s)){
                        ppl.add(l);
                        pics.add(pictures.get(i));
                    }
                }
                recyclerView.setAdapter(new RecyleViewSearch(getApplicationContext(), ppl, pics));
                adapter.notifyDataSetChanged();
            }
        });

        // set up the RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ((LinearLayoutManager) recyclerView.getLayoutManager()).setStackFromEnd(false);
        adapter = new RecyleViewSearch(this, people, pictures);
        recyclerView.setAdapter(adapter);

    }


    private void checkUser() {
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        if (firebaseUser == null) {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }
    }
}

