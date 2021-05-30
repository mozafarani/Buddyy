package com.example.buddyy;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

public class signUpScreen extends AppCompatActivity {

    FirebaseAuth firebaseAuth;
    private static final String TAG = "GOOGLE_SIGN_IN_TAG";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        firebaseAuth = FirebaseAuth.getInstance();
    }

    public void signIn(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void register(View view){

        EditText emailUp = (EditText)findViewById(R.id.emailUp);
        EditText passwordUp = (EditText)findViewById(R.id.passwordUp);
        EditText nameUp = (EditText)findViewById(R.id.nameUp);

        createAccount(emailUp.getText().toString(), passwordUp.getText().toString(), nameUp.getText().toString());


    }

    private void createAccount(String email, String password, String name) {
        // [START create_user_with_email]
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = firebaseAuth.getCurrentUser();
                            UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                                    .setDisplayName(name)
                                    .build();

                            user.updateProfile(profileUpdates).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Log.d(TAG, "User profile updated.");
                                    }
                                }
                            });

                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(signUpScreen.this, "Please enter a valid email and password!",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                    }

                    private void updateUI(FirebaseUser user) {

                        if(user != null){
                            Intent intent = new Intent(signUpScreen.this, Home.class);
                            startActivity(intent);
                        }
                    }
                });
        // [END create_user_with_email]
    }

}
