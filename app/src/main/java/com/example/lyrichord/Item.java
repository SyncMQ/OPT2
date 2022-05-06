package com.example.lyrichord;

import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

interface Item {
    public void setTitle(String title) ;

    public void setAuthor(String author);

    public void setText(String text);

    public void setType(String type);

    public String getTitle();

    public String getAuthor();

    public String getText();

    public String getInstrument();

    public String getType();

}
