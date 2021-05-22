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

import java.util.Objects;


public class MainActivity extends AppCompatActivity {

    CheckBox remember;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).hide();

        remember = findViewById(R.id.rememberMe);

        SharedPreferences preferences = getSharedPreferences("checkbox", MODE_PRIVATE);
        String checkbox  = preferences.getString("remember", "");


        if(checkbox.equals("true")){
            Intent intent = new Intent(this, mainScreen.class);
            startActivity(intent);
        }else{
            Toast.makeText(MainActivity.this, "Please Sign In", Toast.LENGTH_SHORT).show();
        }
    }



    public void onCheckedChanged(View view) {

            if(remember.isChecked()){
                SharedPreferences sharedPreferences = getSharedPreferences("checkbox",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("remember","true");
                editor.apply();
                Toast.makeText(MainActivity.this, "Checked", Toast.LENGTH_SHORT).show();
            }else if(!remember.isChecked()){
                SharedPreferences sharedPreferences = getSharedPreferences("checkbox",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("remember","false");
                editor.apply();
                Toast.makeText(MainActivity.this, "UnChecked", Toast.LENGTH_SHORT).show();
            }

        }

    public void login(View view){



        EditText emailTxt = (EditText)findViewById(R.id.emailTxt);
        EditText passTxt = (EditText)findViewById(R.id.passTxt);

        if(passTxt.getText().toString().equals("") ){
            Toast.makeText(MainActivity.this, "Please, enter a password!", Toast.LENGTH_SHORT).show();
            return;
        }else if(emailTxt.getText().toString().equals("")){
            Toast.makeText(MainActivity.this, "Please, enter an email!", Toast.LENGTH_SHORT).show();
        }

        UserModel model = new UserModel("",emailTxt.getText().toString(),passTxt.getText().toString());
        DatabaseOperations db = new DatabaseOperations(MainActivity.this);

        if(db.userExists(model)){
            // TODO: FINISH SWITCHING SCREENS
        }else{
            Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
        }



        onCheckedChanged(view);


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
