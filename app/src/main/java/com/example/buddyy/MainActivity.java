package com.example.buddyy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Objects;
import java.util.Scanner;


public class MainActivity extends AppCompatActivity {

    CheckBox remember;
    boolean logged_in = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences preferences = getSharedPreferences("checkbox", MODE_PRIVATE);
        String checkbox = preferences.getString("remember", "");
        remember = findViewById(R.id.rememberMe);

        if (checkbox.equals("true")) {

            if(logged_in){
                Intent intent2 = new Intent(this, Home.class);
                intent2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent2);
                MainActivity.this.finish();
            }
        }

    }

    public void onCheckedChanged(View view) {

        if (remember.isChecked()) {
            SharedPreferences sharedPreferences = getSharedPreferences("checkbox", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("remember", "true");
            editor.apply();
        } else if (!remember.isChecked()) {
            SharedPreferences sharedPreferences = getSharedPreferences("checkbox", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("remember", "false");
            editor.apply();

        }

    }

    public void login(View view) {

        EditText emailTxt = (EditText) findViewById(R.id.emailTxt);
        EditText passTxt = (EditText) findViewById(R.id.passTxt);

        UserModel model = new UserModel("", emailTxt.getText().toString(), passTxt.getText().toString());
        DatabaseOperations db = new DatabaseOperations(MainActivity.this);


        if (passTxt.getText().toString().equals("")) {
            Toast.makeText(MainActivity.this, "Please, enter a password!", Toast.LENGTH_SHORT).show();
            return;
        } else if (emailTxt.getText().toString().equals("")) {
            Toast.makeText(MainActivity.this, "Please, enter an email!", Toast.LENGTH_SHORT).show();
        }else{
            if (db.userExists(model)) {
                Intent intent = new Intent(this, Home.class);
                startActivity(intent);
                logged_in = true;
            } else {
                Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
            }
        }

        onCheckedChanged(view);


    }

    public void signUp(View view) {
        Intent intent = new Intent(this, signUpScreen.class);
        startActivity(intent);
    }

    public boolean itemClicked(View v) {
        //code to check if this checkbox is checked!
        CheckBox rememberMe = (CheckBox) findViewById(R.id.rememberMe);
        return rememberMe.isChecked();
    }


}
