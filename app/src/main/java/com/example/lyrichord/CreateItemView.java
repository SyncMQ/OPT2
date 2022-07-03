package com.example.lyrichord;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.lyrichord.Models.Default;
import com.example.lyrichord.Models.Guitar;
import com.example.lyrichord.Models.ItemGetter;
import com.example.lyrichord.Models.Piano;
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
                        createItem(cInstrument);
                        finish();
                    }
                });
            }
        });
    }

    public void createItem(String instrument){
        fAuth = FirebaseAuth.getInstance();
        ItemGetter itemGetter;
        reference = root.getReference().child("users").child(fAuth.getCurrentUser().getUid()).child("lyrics").push();

        switch(instrument){
            case "Guitar":
                itemGetter = new Guitar(cTitle, cAuthor, cText);
                break;
            case "Piano":
                itemGetter = new Piano(cTitle, cAuthor, cText);
                break;
            default:
                itemGetter = new Default(cTitle, cAuthor, cText);
                break;
        }
        reference.setValue(itemGetter);
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
