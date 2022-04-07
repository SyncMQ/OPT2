package com.example.lyrichord;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private DatabaseReference reference;
    private FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    private FirebaseDatabase root = FirebaseDatabase.getInstance("https://lyrichord-default-rtdb.europe-west1.firebasedatabase.app/");
    private Button logout, createItem, uCreateItem, readItems, updateItem, uUpdateItem, deleteItem;
    private EditText cTitle, cAuthor, cInstrument;
    private RadioButton cNone1, cGuitar, cPiano, cNone2, cAcoustic, cElectric, cText;
    private Button createNext;
    private ListView mainList;
    private ArrayList<String> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_dropdown_item_1line,
                items
        );

        createItem = findViewById(R.id.createItem);
        uCreateItem = findViewById(R.id.uCreateItem);


        mainList = findViewById(R.id.itemList);
//        mainList.setAdapter(adapter);

        // below line is used for getting reference
        // of our Firebase Database.
        reference = FirebaseDatabase
                .getInstance("https://lyrichord-default-rtdb.europe-west1.firebasedatabase.app/")
                .getReference("users");

//        reference.addChildEventListener(new ChildEventListener() {
//                                            @Override
//                                            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//                                                String value = snapshot.getValue(String.class);
//                                                items.add(value);
//                                                adapter.notifyDataSetChanged();
//                                            }
//
//                                            @Override
//                                            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//                                                adapter.notifyDataSetChanged();
//                                            }
//
//                                            @Override
//                                            public void onChildRemoved(@NonNull DataSnapshot snapshot) {
//                                                adapter.notifyDataSetChanged();
//                                            }
//
//                                            @Override
//                                            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//
//                                            }
//
//                                            @Override
//                                            public void onCancelled(@NonNull DatabaseError error) {
//
//                                            }
//                                        });
//                mainList.setAdapter(adapter);


        createItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createItem();
            }
        });

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

    public void createItem(){
        setContentView(R.layout.create_item);
        createNext = findViewById(R.id.createNext);
        createNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.create_item2);
                uCreateItem = findViewById(R.id.uCreateItem);
            }
        });
    }

    public void updateItem(){

    }

    public void deleteItem(){

    }


}