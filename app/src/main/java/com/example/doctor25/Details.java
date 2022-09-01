package com.example.doctor25;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        int id=Integer.parseInt(getIntent().getStringExtra("id"));

        DBmanager db = new DBmanager(this);
        ListItem data=db.getIndx(id);

        if(data.Name.equals("Null"))
            data.Name="Not Found";
        ((TextView)findViewById(R.id.name)).setText(data.Name);

        if(data.Qualification.equals("Null"))
            data.Qualification="Not Found";
        ((TextView)findViewById(R.id.qualifications)).setText(data.Qualification);

        if(data.Category.equals("Null"))
            data.Category="Not Found";
        ((TextView)findViewById(R.id.course)).setText(data.Category);

        if(data.City.equals("Null"))
            data.City="Not Found";
        ((TextView)findViewById(R.id.branch)).setText(data.City);



        if(data.Img==-1)
            ((ImageView)findViewById(R.id.img)).setBackgroundResource(R.drawable.ic_menu_report_image);
        else
            ((ImageView)findViewById(R.id.img)).setBackgroundResource(data.Img);
        if(data.Email.equals("Null"))
            ((ImageButton)findViewById(R.id.whatsapp)).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(Details.this, "Email Not Found",Toast.LENGTH_SHORT).show();
                }

            });



        else
            ((ImageButton)findViewById(R.id.whatsapp)).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String url = "https://wa.me/"+data.Email;

                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                }
            });

        if(data.Email.equals("Null"))
            ((ImageButton)findViewById(R.id.call)).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(Details.this, "Number  Not found",Toast.LENGTH_SHORT).show();
                }

            });
        else
            ((ImageButton)findViewById(R.id.call)).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String con = "tel:"+data.Email;
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse(con));
                    startActivity(intent);
                }
            });
        


    }
    public void Back(View view) {
        super.onBackPressed();
    }
}
