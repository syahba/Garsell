package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Amount extends AppCompatActivity {

    Button book;
    TextView details, details_content, amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amount);

        book = findViewById(R.id.book);
        details = findViewById(R.id.details);
        details_content = findViewById(R.id.details_content);
        amount = findViewById(R.id.amount);

        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Amount.this, Searching.class);
                startActivity(i);
            }
        });

        
    }
}
