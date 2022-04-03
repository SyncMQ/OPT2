package com.example.lyrichord;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    private Button register, login;
    private EditText username, password;
    private FirebaseAuth fAuth;

    @Override
    protected void onStart(){
        super.onStart();
        if(FirebaseAuth.getInstance().getCurrentUser() != null ){
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
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
                if (username.getText().toString().isEmpty()){
                    username.setError("Username is empty");
                    return;
                } else if (password.getText().toString().isEmpty()){
                    password.setError("Password is empty");
                    return;
                }

                fAuth.signInWithEmailAndPassword(username.getText().toString(), password.getText().toString()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        finish();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Login.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

        register = findViewById(R.id.registerButton);
        register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(getApplicationContext(), Register.class));
            }
        });

    }


}