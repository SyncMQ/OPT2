package com.example.lyrichord;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.lyrichord.FactoryMethod.Default;
import com.example.lyrichord.FactoryMethod.Guitar;
import com.example.lyrichord.FactoryMethod.Item;
import com.example.lyrichord.FactoryMethod.Piano;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreateItemView extends AppCompatActivity {
    private EditText title, author, text;
    private Button next, create;
    private RadioGroup instrumentGroup, typeGroup;
    private RadioButton radioButton1, radioButton2;
    private FirebaseAuth fAuth;
    private FirebaseDatabase root = FirebaseDatabase.getInstance("https://lyrichord-default-rtdb.europe-west1.firebasedatabase.app/");
    private DatabaseReference reference;
    private String cTitle, cAuthor,cText, cInstrument, cType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_item);

        title = findViewById(R.id.cTitle);
        author = findViewById(R.id.cAuthor);


        instrumentGroup = findViewById(R.id.cInstrument);
        typeGroup = findViewById(R.id.cType);
        instrumentGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                radioButton1 = findViewById(i);
                if(radioButton1.getText().toString().equals("None")){
                    disableTypeGroup();
                }else {
                    enableTypeGroup();
                }
            }
        });

        disableTypeGroup();



        next = findViewById(R.id.cNext);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedId;

                if(title.getText().toString().isEmpty()) {
                    title.setError("Please enter a title");
                    return;
                } else {
                    cTitle = title.getText().toString();
                }

                if(!author.getText().toString().isEmpty()){
                    cAuthor = author.getText().toString();
                }

                selectedId = instrumentGroup.getCheckedRadioButtonId();
                radioButton1 = findViewById(selectedId);
                cInstrument = radioButton1.getText().toString();

                selectedId = typeGroup.getCheckedRadioButtonId();
                radioButton2 = findViewById(selectedId);
                cType = radioButton2.getText().toString();

                setContentView(R.layout.create_item2);
                create = findViewById(R.id.create);
                create.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        text = findViewById(R.id.cText);
                        if(text.getText().toString().isEmpty()){
                            text.setError("Lyrics can't be empty!");
                            return;
                        } else {
                            cText = text.getText().toString();
                        }
                        switch(cInstrument){
                            case "Guitar":
                                createGuitar();
                                break;
                            case "Piano":
                                createPiano();
                                break;
                            default:
                                createItem();
                        }
                        finish();
                    }
                });
            }
        });
    }

    public void createItem(){
        fAuth = FirebaseAuth.getInstance();
        reference = root.getReference().child("users").child(fAuth.getCurrentUser().getUid()).child("lyrics").push();
        Item item = new Default(cTitle, cAuthor, cText);
        reference.setValue(item);
    }

    public void createGuitar(){
        fAuth = FirebaseAuth.getInstance();
        reference = root.getReference().child("users").child(fAuth.getCurrentUser().getUid()).child("lyrics").push();
        Item item = new Guitar(cTitle, cAuthor,cText, cType);
        reference.setValue(item);
    }

    public void createPiano(){
        fAuth = FirebaseAuth.getInstance();
        reference = root.getReference().child("users").child(fAuth.getCurrentUser().getUid()).child("lyrics").push();
        Item item = new Piano(cTitle, cAuthor,cText, cType);
        reference.setValue(item);
    }

    public void enableTypeGroup(){
        for (int i = 0; i <typeGroup.getChildCount(); i++){
            typeGroup.getChildAt(i).setEnabled(true);
        }
    }

    public void disableTypeGroup(){
        radioButton1 = findViewById(R.id.cNone1);
        radioButton1.setChecked(true);
        radioButton2 = findViewById(R.id.cNone2);
        radioButton2.setChecked(true);
        for (int i = 0; i < typeGroup.getChildCount(); i++){
            typeGroup.getChildAt(i).setEnabled(false);
        }

    }
}