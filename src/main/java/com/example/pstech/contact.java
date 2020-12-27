package com.example.pstech;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class contact extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        getSupportActionBar().setTitle("Contact us");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



    }
}