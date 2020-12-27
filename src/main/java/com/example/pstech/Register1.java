package com.example.pstech;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Register1 extends AppCompatActivity {

        EditText user1, email_mass, pass, phone;
        TextView login;
        Button submit_but;
        ProgressBar progressBar;
        private FirebaseAuth mAuth;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_register1);
            // FirebaseUser user = mAuth.getCurrentUser();

            getSupportActionBar().hide();
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


            user1 = findViewById(R.id.editTextTextPersonName3);
            email_mass = findViewById(R.id.editTextTextPersonName4);
            pass = findViewById(R.id.editTextTextPersonName5);
            phone = findViewById(R.id.editTextTextPersonName6);
            login = findViewById(R.id.textView);
            submit_but = findViewById(R.id.button2);
            mAuth = FirebaseAuth.getInstance();
            FirebaseUser user = mAuth.getCurrentUser();
            progressBar = (ProgressBar) findViewById(R.id.progressBar2);


            submit_but.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    progressBar.setVisibility(View.VISIBLE);
                    String Email = email_mass.getText().toString().trim();
                    String password = pass.getText().toString().trim();
                    String username = user1.getText().toString().trim();
                    String mobile = phone.getText().toString().trim();
                    if (TextUtils.isEmpty(Email)) {
                        progressBar.setVisibility(View.INVISIBLE);
                        email_mass.setError("Email is Required.");
                        return;
                    }
                    if (TextUtils.isEmpty(password)) {
                        progressBar.setVisibility(View.INVISIBLE);
                        pass.setError("Password is Required");
                        return;
                    }
                    if (TextUtils.isEmpty(username)){
                        progressBar.setVisibility(View.INVISIBLE);
                        user1.setError("Username is Required");
                        return;
                    }
                    if (TextUtils.isEmpty(mobile)){
                        progressBar.setVisibility(View.INVISIBLE);
                        phone.setError("Phone Number is required");
                    }

                    if (password.length() < 6) {
                        progressBar.setVisibility(View.INVISIBLE);
                        pass.setError("Password Must be >= 6 Character");
                        return;
                    }
                    mAuth.createUserWithEmailAndPassword(Email, password)
                            .addOnCompleteListener(Register1.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        progressBar.setVisibility(View.INVISIBLE);

                                        Toast.makeText(Register1.this,"Registered Successfully!",Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(Register1.this, MainActivity.class);
                                        startActivity(intent);

                                    } else {
                                        progressBar.setVisibility(View.INVISIBLE);

                                        Toast.makeText(Register1.this,"Process Error!",Toast.LENGTH_SHORT).show();

                                    }


                                }
                            });
                }

            });

            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent R = new Intent(Register1.this, MainActivity.class);
                    startActivity(R);
                    finish();
                }
            });


        }


    }

