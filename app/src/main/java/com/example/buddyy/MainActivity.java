package com.example.buddyy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import java.util.Objects;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).hide();
    }

    public void login(View view){

        if(itemClicked(view)){
           // TODO: FINISH THIS CHECKBOX THING

        }

        // TODO: FINISH LOGING IN AND SWITCHING SCREENS
        // TODO: CHECK IF EMAIL AND PASSWORD ARE CORRECT
    }

    public void signUp(View view){
        Intent intent = new Intent(this, mainScreen.class);
        startActivity(intent);
    }

    public boolean itemClicked(View v) {
        //code to check if this checkbox is checked!
        CheckBox rememberMe = (CheckBox)findViewById(R.id.rememberMe);
        return rememberMe.isChecked();
    }
}
