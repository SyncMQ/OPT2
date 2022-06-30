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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterView extends AppCompatActivity {
    private EditText username, email, password, passConfirm;
    private Button register;
    private FirebaseAuth fAuth;
    private DatabaseReference reference;
    private FirebaseDatabase root = FirebaseDatabase.getInstance("https://lyrichord-default-rtdb.europe-west1.firebasedatabase.app/");
    private User user;

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

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fAuth.createUserWithEmailAndPassword(
                        email.getText().toString(),
                        password.getText().toString()).addOnSuccessListener(
                                new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        createUser(
                                fAuth.getCurrentUser().getUid(),
                                username.getText().toString(),
                                email.getText().toString()
                        );
                        startActivity(new Intent(getApplicationContext(), MainView.class));
                        finish();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(RegisterView.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

    }


    public void createUser(String uid, String username, String email){
        user = new User(uid,username,email);
        reference = root.getReference();
        reference.child("users").child(user.getUid()).setValue(user);
    }

}
