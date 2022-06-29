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

abstract class Item {
    abstract public void setTitle(String title) ;

    abstract public void setAuthor(String author);

    abstract public void setText(String text);

    abstract public void setType(String type);

    abstract public String getTitle();

    abstract public String getAuthor();

    abstract public String getText();

    abstract public String getInstrument();

    abstract public String getType();

}
