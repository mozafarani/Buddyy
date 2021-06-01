package com.example.buddyy;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

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


public class Post extends AppCompatActivity {

    private Button makePost;
    private FirebaseAuth firebaseAuth;

    private EditText titlePost;
    private EditText descriptionPost;
    private DatabaseReference postDB;



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
                        Post.this.finish();
                        break;
                    case R.id.search:
                        intent = new Intent(Post.this,Search.class);
                        startActivity(intent);
                        Post.this.finish();
                        break;
                    case R.id.post:
                        break;

                    case R.id.message:
                        intent = new Intent(Post.this,Message.class);
                        startActivity(intent);
                        Post.this.finish();
                        break;
                    case R.id.profile:
                        intent = new Intent(Post.this,Profile.class);
                        startActivity(intent);
                        Post.this.finish();
                        break;
                }



                return false;
            }
        });

        firebaseAuth = FirebaseAuth.getInstance();

        FirebaseUser user = firebaseAuth.getCurrentUser();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        assert user != null;
        postDB = database.getReference("Posts");
        titlePost = (EditText) findViewById(R.id.titlePost);
        descriptionPost = (EditText)findViewById(R.id.descriptionPost);


       findViewById(R.id.makePost).setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               if(newPost()){
                    startActivity(new Intent(Post.this, Home.class));}
               else{
                   Toast.makeText(Post.this,"Please enter a title and a description!", Toast.LENGTH_SHORT ).show();
               }
           }


       });

    }

    private boolean newPost() {
        String title = titlePost.getText().toString();
        String description = descriptionPost.getText().toString();

        if (title.equals("") || description.equals("") ) {
            return false;
        }



        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Posts");
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                GenericTypeIndicator<List<Posts>> genericTypeIndicator = new GenericTypeIndicator<List<Posts>>() {};
                List<Posts> x = dataSnapshot.getValue(genericTypeIndicator);


                if(x == null){
                    x = new ArrayList<>();
                }


                Posts posts = new Posts(title, description, null,null, 0, firebaseAuth.getCurrentUser().getUid());
                x.add(posts);
                postDB.setValue(x);
                Toast.makeText(Post.this,"Post posted", Toast.LENGTH_SHORT ).show();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        return true;
    }
}

