package com.example.pstech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class About extends AppCompatActivity {

    TextView textView;
    String  urls = "https://www.famousappbox.online/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        textView=findViewById(R.id.textView8);
        getSupportActionBar().setTitle("About us");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(urls));
                startActivity(i);
            }
        });
    }

}