package com.example.lyrichord;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class User {
    private String uid;
    private String username;
    private String email;
    private static final String TAG = "UserActivity";

    protected FirebaseFirestore database = FirebaseFirestore.getInstance();


    public User(){

    }

    public User(String uid, String username, String email) {
        this.uid = uid;
        this.username = username;
        this.email = email;
    }

    public void createUser(){
        Map<String, Object> user = new HashMap<>();
        user.put("uid", uid);
        user.put("username", username);
        user.put("email", email);

        database.collection("users").document(uid)
                .set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Log.d(TAG, "Added user to the database with ID: " + uid);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.w(TAG,"Can't add user to the database!", e);
            }
        });
    }

    public String getUid() {
        return uid;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

}
