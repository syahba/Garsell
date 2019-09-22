package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

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

        if (getIntent()!= null && getIntent().getExtras()!= null) {
            int total = getIntent().getExtras().getInt("total", 0);
            DecimalFormat formatter = new DecimalFormat("#,###,###");
            String format_total = formatter.format(total);
            String rp = String.format("%s%s%s", "Rp.", format_total, ",00");
            amount.setText(rp);

            int plastic = getIntent().getExtras().getInt("plastic", 0);
            int paper = getIntent().getExtras().getInt("paper", 0);
            int oil = getIntent().getExtras().getInt("oil", 0);
            String plastic_details = String.format("%s%s", plastic, " kg of plastics are going to be picked up by a collector");
            String paper_details = String.format("%s%s", paper, " kg of papers are going to be picked up by a collector");
            String oil_details = String.format("%s%s", oil, " kg of oils are going to be picked up by a collector");
            String plastic_paper_details = String.format("%s%s%s%s", plastic, " kg of plastics and ", paper, " kg of papers are going to be picked up by a collector");
            String plastic_oil_details = String.format("%s%s%s%s", plastic, " kg of plastics and ", oil, " kg of oils are going to be picked up by a collector");
            String paper_oil_details = String.format("%s%s%s%s", paper, " kg of papers and ", oil, " kg of oils are going to be picked up by a collector");
            String plastic_paper_oil_details = String.format("%s%s%s%s%s%s", plastic, " kg of plastics, ", paper, " kg of papers and ", oil, " kg of oils are going to be picked up by a collector");
            String description = "";

            if (plastic != 0 && paper != 0 && oil != 0) {
                description = plastic_paper_oil_details;
            }
            else if (plastic != 0 && paper != 0){
                description = plastic_paper_details;
            }
            else if (plastic != 0 && oil != 0){
                description = plastic_oil_details;
            }
            else if (paper != 0 && oil != 0){
                description = paper_oil_details;
            }
            else if (plastic != 0){
                description = plastic_details;
            }
            else if (paper != 0){
                description = paper_details;
            }
            else if (oil != 0){
                description = oil_details;
            }

            details_content.setText(description);
        }

        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Amount.this, Searching.class);
                i.putExtra("description", details_content.getText().toString());
                startActivity(i);
            }
        });
    }
}
