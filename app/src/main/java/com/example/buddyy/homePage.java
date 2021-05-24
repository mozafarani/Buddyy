package com.example.buddyy;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Objects;

public class homePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavView_Bar);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent intent;
                switch (item.getItemId()){
                    case R.id.home:
                        intent = new Intent(homePage.this, Home.class);
                        startActivity(intent);
                        break;
                    case R.id.search:
                        intent = new Intent(homePage.this,Search.class);
                        startActivity(intent);
                        break;
                    case R.id.post:
                        intent = new Intent(homePage.this,Post.class);
                        startActivity(intent);
                        break;

                    case R.id.message:
                        intent = new Intent(homePage.this,Message.class);
                        startActivity(intent);
                        break;
                    case R.id.profile:
                        intent = new Intent(homePage.this,Profile.class);
                        startActivity(intent);
                        break;
                }



                return false;
            }
        });
    }

}
