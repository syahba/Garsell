package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Login extends AppCompatActivity {

    TextView username, password;
    EditText username_value, password_value;
    Button sign_in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        username_value = findViewById(R.id.username_value);
        password_value = findViewById(R.id.password_value);
        sign_in = findViewById(R.id.sign_in);

        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username.getText().toString().equals("")) {
                    username.setError("Please fill the username");
                }
                if (password.getText().toString().equals("")) {
                    password.setError("Please fill the password");
                }
                if (username_value.getText().toString().equals("user")
                        && password_value.getText().toString().equals("user")) {
                    Intent i = new Intent(getBaseContext(), MainActivity.class);
                    startActivity(i);
                    finish();
                } else {
                    Toast.makeText(
                            getBaseContext(), "Username and password doesn't seem to match",
                            Toast.LENGTH_SHORT
                    ).show();
                }

            }
        });

    }
}
