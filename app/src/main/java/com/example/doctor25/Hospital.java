package com.example.doctor25;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Hospital extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital);

        ListView listView = findViewById(R.id.listView);


        ArrayList<String> arrResume = new ArrayList<>();
        arrResume.add("AIIMS Delhi");
        arrResume.add("AIIMS Vijayawada");
        arrResume.add("AIIMS Nagpur");
        arrResume.add("APOLLO Vizag");
        arrResume.add("APOLLO Chennai");
        arrResume.add("KIIMS Kolkata");
        arrResume.add("BL Kapoor Delhi");
        arrResume.add("Ram Manhohar Lohiya Hospital Delhi");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, arrResume);
        listView.setAdapter(adapter);


    }
}

