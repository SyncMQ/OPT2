package com.example.lyrichord;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Register extends AppCompatActivity {
    private EditText username, email, password, passConfirm;
    private Button register;
    private FirebaseAuth firebaseAuth;

    @Override
    public void onStart(){
        super.onStart();
        FirebaseUser currentUser = firebaseAuth.getCurrentUser();
        if(currentUser != null){

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = findViewById(R.id.registerUsername);
        email = findViewById(R.id.registerEmail);
        password = findViewById(R.id.registerPass);
        passConfirm = findViewById(R.id.repeatPass);
        register = findViewById(R.id.registerButton);

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

//                firebaseAuth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString()).addOnCompleteListener()

            }
        });

    }

}
