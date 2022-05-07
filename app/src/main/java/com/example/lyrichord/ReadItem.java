package com.example.lyrichord;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ReadItem extends AppCompatActivity {
    private TextView title, text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.read_item);

        title = findViewById(R.id.rTitle);
        text = findViewById(R.id.rText);

        Intent intent = getIntent();
        String rTitle = intent.getStringExtra("title");
        String rText = intent.getStringExtra("text");
        title.setText(rTitle);
        text.setText(rText);

    }



}