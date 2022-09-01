package com.example.doctor25;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    private ImageButton doc , team, hospital, blog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        doc = findViewById(R.id.doc);
        team = findViewById(R.id.team);
        hospital = findViewById(R.id.hospital);
        blog = findViewById((R.id.blog));

        doc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getBaseContext(),Listpage.class);
                startActivity(intent);

            }
        });

        hospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hos =new Intent(getBaseContext(),Hospital.class);
                startActivity(hos);
            }
        });


        team.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent team = new Intent(getBaseContext(),TeamList.class);
                startActivity(team);
            }
        });

        blog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tips = new Intent(getBaseContext(), Tips.class);
                startActivity(tips);
            }
        });






    }
}