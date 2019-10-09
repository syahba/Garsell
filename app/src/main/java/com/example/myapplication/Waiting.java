package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Waiting extends AppCompatActivity {

    Button next, call;
    TextView details_content_display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waiting);

        next = findViewById(R.id.next);
        call = findViewById(R.id.call);
        details_content_display = findViewById(R.id.details_content_display);

        if (getIntent() != null && getIntent().getExtras() != null) {
            String description = getIntent().getExtras().getString("description", " ");
            details_content_display.setText(description);

            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(Waiting.this, Done.class);
                    startActivity(i);
                }
            });
        }
    }
}