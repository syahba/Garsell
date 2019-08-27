package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Form extends AppCompatActivity {

    int plastic_value, paper_value, oil_value;
    Button confirm;
    TextView address, address_name, types, weight, plastic, paper, oil, plastic_amount, paper_amount, oil_amount;
    EditText plastic_number, paper_number, oil_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        confirm = findViewById(R.id.confirm);
        address = findViewById(R.id.address);
        address_name = findViewById(R.id.address_name);
        types = findViewById(R.id.types);
        weight = findViewById(R.id.weight);
        plastic = findViewById(R.id.plastic);
        plastic_amount = findViewById(R.id.plastic_amount);
        plastic_number = findViewById(R.id.plastic_number);
        paper = findViewById(R.id.paper);
        paper_amount = findViewById(R.id.paper_amount);
        paper_number = findViewById(R.id.paper_number);
        oil = findViewById(R.id.oil);
        oil_amount = findViewById(R.id.oil_amount);
        oil_number = findViewById(R.id.oil_number);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                plastic_value = paper_value = oil_value = 0;


                Intent i = new Intent(Form.this, Amount.class);
                startActivity(i);
            }
        });
    }
}
