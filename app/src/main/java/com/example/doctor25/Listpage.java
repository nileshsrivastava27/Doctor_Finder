package com.example.doctor25;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

public class Listpage extends AppCompatActivity {
    DBmanager db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_page);

        db = new DBmanager(Listpage.this);
        db.CreateSudoDB();

        ArrayList<ListItem> Temp= db.getAllData();
        ListItemAdapter listItemAdapter = new ListItemAdapter(this,Temp);

        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(listItemAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent myIntent = new Intent(Listpage.this, Details.class);
                myIntent.putExtra("id",Long.toString(id));
                startActivity(myIntent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    public void Back(View view) {
        super.onBackPressed();
    }

}
