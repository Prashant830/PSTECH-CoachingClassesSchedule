package com.example.pstech;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Home extends AppCompatActivity {

    ListView listView1;
    private FirebaseAuth mAuth;


    String[] classes = {"English classes", "Mathematics classes", "Social science classes", "Science classes","Chemistry class"
    , "Physics class","Biology class","Hindi class"};

    String[] urls = {"https://drive.google.com/file/d/13sN2KNN3WRaQHk39zacyPChcm-4ysiP6/view?usp=sharing",
            "https://drive.google.com/file/d/1PHM8xMmjFkX0mDLkEMxFMFbLq6fAd1Lf/view?usp=sharing",
            "https://drive.google.com/file/d/11FxEuh6H1h6om9E74UpM1P4xvJTgBhRR/view?usp=sharing ",
            "https://drive.google.com/file/d/1oxzSDgwymstZ8jCH2KQ0PC1DzLDoVtUX/view?usp=sharing",
            "https://drive.google.com/file/d/1S4Y5iO6ajMtO1QU__rxtgoS8cLW6bxbj/view?usp=sharing",
    "https://drive.google.com/file/d/1omQZmw9vGUF-WQ4l5kDRLyhgH1qtjZK9/view?usp=sharing",
    "https://drive.google.com/file/d/1fh4NMxZVuVAQTPvBk0FBQgiFfg6gu2V9/view?usp=sharing",
    "https://drive.google.com/file/d/1cg1n6zyNyuqZlzklatzHXZjCGnLlVopB/view?usp=sharing",
    "https://drive.google.com/file/d/16LVgr4zUuppuVTyOcm2T2AswyQ8ZjpLf/view?usp=sharing"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().setTitle("PS TECH");
        getSupportActionBar().setSubtitle("COACHING CLASSES SCHEDULE");

       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mAuth = FirebaseAuth.getInstance();
        listView1 = (ListView) findViewById(R.id.lists);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Home.this, android.R.layout.simple_dropdown_item_1line, classes);
        listView1.setAdapter(adapter);
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(urls[position]));
                startActivity(i);

            }
        });
    }
        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.main_menu,menu);
            return super.onCreateOptionsMenu(menu);
        }

        @Override
        public boolean onOptionsItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()){

                case R.id.share_button:
                    Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                    sharingIntent.setType("text/plain");
                    String shareBody="https://www.famousappbox.online/";
                    String shareSubject="Download this useful application it hare:-";

                    sharingIntent.putExtra(Intent.EXTRA_TEXT,shareBody);
                    sharingIntent.putExtra(Intent.EXTRA_SUBJECT,shareSubject);

                    startActivity(Intent.createChooser(sharingIntent,"share Using"));

                    break;
                case R.id.log_out:
                    Toast.makeText(this,"logout successfully",Toast.LENGTH_SHORT).show();
                    mAuth.signOut();
                    Intent i = new Intent(Home.this, MainActivity.class);
                    startActivity(i);
                    break;
                case R.id.about_button:
                    Intent m = new Intent(Home.this, About.class);
                    startActivity(m);

                    break;
                case R.id.contact_button:

                    Intent n = new Intent(Home.this, contact.class);
                    startActivity(n);
                    break;
            }
            return super.onOptionsItemSelected(item);

}
    }
