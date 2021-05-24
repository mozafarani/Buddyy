package com.example.buddyy;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Objects;

public class Profile extends AppCompatActivity {
    //TODO: Rezise images when imprted in

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setContentView(R.layout.profiler);



        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavView_Bar);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent intent;
                switch (item.getItemId()){
                    case R.id.home:
                        intent = new Intent(Profile.this, Home.class);
                        startActivity(intent);
                        break;
                    case R.id.search:
                        intent = new Intent(Profile.this,Search.class);
                        startActivity(intent);
                        break;
                    case R.id.post:
                        intent = new Intent(Profile.this,Post.class);
                        startActivity(intent);
                        break;

                    case R.id.message:
                        intent = new Intent(Profile.this,Message.class);
                        startActivity(intent);
                        break;
                    case R.id.profile:
                        break;
                }



                return false;
            }
        });
    }

}

