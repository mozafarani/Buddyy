package com.example.buddyy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

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

        UserModel model = new UserModel(nameUp.getText().toString(),emailUp.getText().toString(),passwordUp.getText().toString());
        DatabaseOperations databaseOperations = new DatabaseOperations(signUpScreen.this);
        boolean b = databaseOperations.addUser(model);

        Toast.makeText(signUpScreen.this, "Success = " + b, Toast.LENGTH_SHORT).show();
    }

}
