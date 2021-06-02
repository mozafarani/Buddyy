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
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;

public class Search extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;
    RecyleViewSearch adapter;
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
                switch (item.getItemId()){
                    case R.id.home:
                        intent = new Intent(Search.this, Home.class);
                        startActivity(intent);
                        Search.this.finish();
                        break;
                    case R.id.search:
                        break;
                    case R.id.post:
                        intent = new Intent(Search.this,Post.class);
                        startActivity(intent);
                        Search.this.finish();
                        break;

                    case R.id.message:
                        intent = new Intent(Search.this,Message.class);
                        startActivity(intent);
                        Search.this.finish();
                        break;
                    case R.id.profile:
                        intent = new Intent(Search.this,Profile.class);
                        startActivity(intent);
                        Search.this.finish();
                        break;
                }



                return false;
            }
        });

        ArrayList<String> people = new ArrayList<>();
        List<Integer> pictures = new ArrayList<>();

        String result = FirebaseAuth.getInstance().getUid();


//        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Posts");
//        reference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                names.clear();
//                pictures.clear();
//
//                int i = 0;
//                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
//                    GenericTypeIndicator<List<Posts>> genericTypeIndicator = new GenericTypeIndicator<List<Posts>>() {
//                    };
//                    List<Posts> x = dataSnapshot.getValue(genericTypeIndicator);
//                    names.add(x.get(i).getUser());
//                    pictures.add(null);
//
//                }
//                adapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });


        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ((LinearLayoutManager)recyclerView.getLayoutManager()).setStackFromEnd(true);
        adapter = new RecyleViewSearch(this, people,pictures);
        recyclerView.setAdapter(adapter);

    }



    private void checkUser() {
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        if(firebaseUser == null){
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }
    }
}

