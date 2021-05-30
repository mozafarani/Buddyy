package com.example.buddyy;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Profile extends AppCompatActivity {
    //TODO: Rezise images when imprted in

    private FirebaseAuth firebaseAuth;
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
                        Profile.this.finish();
                        break;
                    case R.id.search:
                        intent = new Intent(Profile.this,Search.class);
                        startActivity(intent);
                        Profile.this.finish();
                        break;
                    case R.id.post:
                        intent = new Intent(Profile.this,Post.class);
                        startActivity(intent);
                        Profile.this.finish();
                        break;

                    case R.id.message:
                        intent = new Intent(Profile.this,Message.class);
                        startActivity(intent);
                        Profile.this.finish();
                        break;
                    case R.id.profile:
                        break;
                }



                return false;
            }
        });

        firebaseAuth = FirebaseAuth.getInstance();
        checkUser();
        findViewById(R.id.logout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseAuth.signOut();
                GoogleSignIn.getClient(
                        getApplicationContext(),
                        new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).build()
                ).signOut();
                Intent intent = new Intent(Profile.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                Profile.this.finish();
                startActivity(intent);
                finish();
            }
        });
    }



    private void checkUser() {
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        if(firebaseUser == null){
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }
    }

}

