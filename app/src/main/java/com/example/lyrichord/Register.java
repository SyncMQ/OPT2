package com.example.lyrichord;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Register extends AppCompatActivity {
    private EditText username, email, password, passConfirm;
    private Button register;
    private FirebaseAuth fAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);



        username = findViewById(R.id.registerUsername);
        email = findViewById(R.id.registerEmail);
        password = findViewById(R.id.registerPass);
        passConfirm = findViewById(R.id.repeatPass);
        register = findViewById(R.id.register);

        fAuth = FirebaseAuth.getInstance();


        //Form validation
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username.getText().toString().isEmpty()){
                    username.setError("Username is required");
                    return;
                }

                if (email.getText().toString().isEmpty()){
                    email.setError("Email is required");
                    return;
                }

                if (password.getText().toString().isEmpty()){
                    password.setError("Password is required");
                    return;
                }

                if (passConfirm.getText().toString().isEmpty()){
                    passConfirm.setError("Please confirm your password");
                    return;
                } else if (!password.getText().toString().equals(passConfirm.getText().toString())){
                    passConfirm.setError("Both passwords are different");
                    return;
                }

                fAuth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        User user = new User(fAuth.getCurrentUser().getUid(),username.getText().toString(),email.getText().toString());
                        user.createUser();
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        finish();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Register.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

    }

}
