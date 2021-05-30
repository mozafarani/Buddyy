package com.example.buddyy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class signUpScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

    }

    public void signIn(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void register(View view){

        EditText emailUp = (EditText)findViewById(R.id.emailUp);
        EditText passwordUp = (EditText)findViewById(R.id.passwordUp);
        EditText nameUp = (EditText)findViewById(R.id.nameUp);


    }

}
