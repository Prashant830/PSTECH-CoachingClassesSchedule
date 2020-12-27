package com.example.pstech;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {


    EditText email_mass, pass;
    ImageButton imageButton;
    Button but;
    ProgressBar progressBar;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        email_mass = findViewById(R.id.editTextTextPersonName);
        pass = findViewById(R.id.editTextTextPersonName2);
        imageButton = (ImageButton) findViewById(R.id.imageButton);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        but = findViewById(R.id.button);
        mAuth = FirebaseAuth.getInstance();

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email = email_mass.getText().toString().trim();
                String password = pass.getText().toString().trim();
                progressBar.setVisibility(View.VISIBLE);

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

                if (password.length() < 6) {
                    progressBar.setVisibility(View.INVISIBLE);
                    pass.setError("Password Must be >= 6 Character");
                    return;
                }
                if (Email.equals("") && password.equals("")) {
                    progressBar.setVisibility(View.INVISIBLE);
                    Toast.makeText(MainActivity.this, "Email and Password is Blank", Toast.LENGTH_SHORT).show();
                }
                mAuth.signInWithEmailAndPassword(Email, password)
                        .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    progressBar.setVisibility(View.INVISIBLE);

                                    Intent i = new Intent(MainActivity.this, Home.class);
                                    startActivity(i);


                                } else {
                                    progressBar.setVisibility(View.INVISIBLE);
                                    Toast.makeText(MainActivity.this, "Invalid Email and Password!", Toast.LENGTH_SHORT).show();
                                }

                            }
                        });

            }
        });


        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Register1.class);
                startActivity(i);
                finish();
            }
        });

    }
    @Override
    protected void onStart() {
        super.onStart();


        FirebaseUser user = mAuth.getCurrentUser();
        if (user != null) {
            startActivity(new Intent(MainActivity.this, Home.class));
            finish();
        }
    }

}


