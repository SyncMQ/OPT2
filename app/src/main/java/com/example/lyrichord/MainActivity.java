package com.example.lyrichord;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private final FirebaseFirestore database = FirebaseFirestore.getInstance();
    private Button logout, createItem, uCreateItem, readItems, updateItem, uUpdateItem, deleteItem;
    private Button createNext;
    private ListView mainList;
    private ArrayList<List> lists = new ArrayList<>();
    private User user = new User();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        readList();

        createItem = findViewById(R.id.createItem);
        createItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.create_item);
                createNext = findViewById(R.id.createNext);
                createNext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        setContentView(R.layout.create_item2);
                    }
                });
            }
        });



//        uCreateItem = findViewById(R.id.createNext);



        logout = findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext(),Login.class));
                finish();
            }
        });
    }


    public void readItem(){

    }

//    public void createItem(){
//        Map<String, Object> list = new HashMap<>();
//        list.put("title", title);
//
//        if(author != null) {
//            list.put("author", author);
//        } else {
//            list.put ("author","N/A");
//        }
//
//        if (instrument != null) {
//            list.put("instrument", instrument);
//        } else {
//            list.put("instrument", "N/A");
//        }
//
//        if (type != null) {
//            list.put("type", type);
//        } else {
//            list.put("type", "N/A");
//        }
//
//        list.put("text", text);
//
//        database.collection("users/" + user.getUid() + "/lists" )
//                .add(list)
//                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
//                    @Override
//                    public void onSuccess(DocumentReference documentReference) {
//                        setContentView(R.layout.activity_main);
//                    }
//                }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//                Toast.makeText(MainActivity.this, "Unable to add entry" + e, Toast.LENGTH_SHORT).show();
//            }
//        });
//
//    }

    public void updateItem(){

    }

    public void deleteItem(){

    }


}