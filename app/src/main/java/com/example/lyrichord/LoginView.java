package com.example.lyrichord;

import androidx.annotation.NonNull;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginView extends LoginHandler {
    private Button register, login;
    private EditText username, password;
    private FirebaseAuth fAuth;


    @Override
    protected void onStart(){
        super.onStart();
        if(FirebaseAuth.getInstance().getCurrentUser() != null ){
            startActivity(new Intent(getApplicationContext(), MainView.class));
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        fAuth = FirebaseAuth.getInstance();

        username = findViewById(R.id.loginUsername);
        password = findViewById(R.id.loginPassword);
        login = findViewById(R.id.loginButton);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });


        register = findViewById(R.id.registerButton);
        register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(getApplicationContext(), RegisterView.class));
            }
        });

    }


    @Override
    public Boolean fieldValidation() {
        if (username.getText().toString().isEmpty()){
            username.setError("Username is empty");
            return false;
        } else if (password.getText().toString().isEmpty()){
            password.setError("Password is empty");
            return false;
        }
        return true;
    }

    @Override
    public void firebaseValidation() {
        fAuth.signInWithEmailAndPassword(username.getText().toString(), password.getText().toString()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                fbValidation = true;
                return;
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                fbValidation = false;
                Toast.makeText(LoginView.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                return;
            }
        });
    }

    public void toDashboard(){
        fbValidation = false;
        startActivity(new Intent(getApplicationContext(), MainView.class));
        finish();
    }
}