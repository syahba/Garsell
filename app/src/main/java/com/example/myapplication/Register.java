package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;


public class Register extends AppCompatActivity {

        private EditText inputEmail, inputPassword;
        private Button btnSignUp;
        private ProgressBar progressBar;
        private FirebaseAuth mAuth;

        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_register);
                Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

                mAuth = FirebaseAuth.getInstance();
                btnSignUp = (findViewById(R.id.sign_up));
                inputEmail = (findViewById(R.id.email));
                inputPassword = (findViewById(R.id.password_value));
                progressBar = (findViewById(R.id.progressBar));

                btnSignUp.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                                String email = inputEmail.getText().toString().trim();
                                String password = inputPassword.getText().toString().trim();
                                if (TextUtils.isEmpty(email)) {
                                        Toast.makeText(getApplicationContext(),
                                                "Enter your Email Address!", Toast.LENGTH_SHORT).show();
                                        return;
                                }
                                if (TextUtils.isEmpty(password)) {
                                        Toast.makeText(getApplicationContext(),
                                                "now enter your password! make sure it's a unique one~", Toast.LENGTH_SHORT).show();
                                        return;
                                }
                                if (password.length() < 6) {
                                        Toast.makeText(getApplicationContext(),
                                                "oof- password too short! make it at least 6 characters!", Toast.LENGTH_SHORT).show();
                                        return;
                                }
                                progressBar.setVisibility(View.VISIBLE);

                                mAuth.createUserWithEmailAndPassword(email, password)
                                        .addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {

                                                @Override
                                                public void onComplete(@NonNull Task<AuthResult> task) {
                                                        if (task.isSuccessful()) {
                                                                // Sign in success, update UI with the signed-in user's information
                                                                Log.d("katkat", "createUserWithEmail:success");
                                                                FirebaseUser user = mAuth.getCurrentUser();
                                                                updateUI(user);
                                                        } else {
                                                                // If sign in fails, display a message to the user.
                                                                Log.w("katkat", "createUserWithEmail:failure", task.getException());
                                                                Toast.makeText(Register.this, "Authentication failed.",
                                                                        Toast.LENGTH_SHORT).show();
                                                        }

                                                        // ...
                                                }
                                        });
                        }
                });
        }
        boolean isEmailValid(CharSequence email) {
                return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
        }

        private void updateUI(FirebaseUser user) {
                Intent i = new Intent(Register.this, MainActivity.class);
                startActivity(i);
        }
}