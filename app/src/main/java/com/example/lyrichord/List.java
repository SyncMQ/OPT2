package com.example.lyrichord;

import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nullable;

public class List extends User {
    private String title;
    private String author;
    private String text;
    private String instrument;
    private String type;

    public List(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public List(String title, String author, String text) {
        this.title = title;
        this.author = author;
        this.text = text;
    }

    public List(String title, String author, String text, String instrument) {
        this.title = title;
        this.author = author;
        this.text = text;
        this.instrument = instrument;
    }

    public List(String title, String author, String text, String instrument, String type) {
        this.title = title;
        this.author = author;
        this.text = text;
        this.instrument = instrument;
        this.type = type;
    }

    public void createList(){
        Map<String, Object> list = new HashMap<>();
        list.put("title", title);

        if(author != null) {
            list.put("author", author);
        } else {
            list.put ("author","N/A");
        }

        if (instrument != null) {
            list.put("instrument", instrument);
        } else {
            list.put("instrument", "N/A");
        }

        if (type != null) {
            list.put("type", type);
        } else {
            list.put("type", "N/A");
        }

        list.put("text", text);

        database.collection("users/" + uid + "/lists" )
                .add(list)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });

    }

}
