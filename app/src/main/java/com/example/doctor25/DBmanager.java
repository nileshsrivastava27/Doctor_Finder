package com.example.doctor25;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;
public class DBmanager extends SQLiteOpenHelper{
    public static final String TABLE_NAME="Doctor_TABLE";
    public static final String COLUMN_ID="Doc_Id";
    public static final String COLUMN_NAME="Doc_Name";
    public static final String COLUMN_QUALIFICATION="Doc_Qualification";
    public static final String COLUMN_CAT="Doc_Cat";
    public static final String COLUMN_CITY="Doc_City";

    public static final String COLUMN_WHT="Doc_Wht";
    public static final String COLUMN_IMG="Alumni_Img";

    public DBmanager(@Nullable Context context) {
        super(context,"doctor.db",null, 1);
    }

    public void CreateSudoDB(){
        SQLiteDatabase db= this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);

        String createTableQuery="CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" ("+COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+COLUMN_NAME+" TEXT,"+COLUMN_QUALIFICATION+" TEXT,"+COLUMN_CAT+" TEXT,"+COLUMN_CITY+" TEXT,"+COLUMN_WHT+" TEXT,"+COLUMN_IMG+" INT)";
        db.execSQL(createTableQuery);

        ArrayList<ListItem> data_list= new ArrayList<>();
        data_list.add(new ListItem("Dr. Surinder Pal Singh Bedi","MBBS","General Physician","New Delhi","+919560849811",R.drawable.img_6));
        data_list.add(new ListItem("Dr Z S Meharwal","MBBS + MS + Mch","Cardiac Surgeon","New Delhi","+919334361116",R.drawable.img_7));
        data_list.add(new ListItem("Dr. Arun Saroha","MBBS + MS + Mch","Spine Surgeon","Gurgaon","+919334361116",R.drawable.img_8));
        data_list.add(new ListItem("Dr Nandkishore Kapadia","MBBS + MS + Mch","Cardiologist","Mumbai","+919321787580",R.drawable.img_9));
        data_list.add(new ListItem("Dr Ritika Malhotra","BDS + MDS (Periodontics)","Dentist","Mumbai","+919321787580",R.drawable.img_4));
        data_list.add(new ListItem("Dr Aman Popli","MBBS ","Pediatrician","Bhopal","+919321787580",R.drawable.img_5));

        for( int i=0;i<data_list.size();i++) {
            ContentValues cv = new ContentValues();

            cv.put(COLUMN_NAME, data_list.get(i).Name);
            cv.put(COLUMN_QUALIFICATION,data_list.get(i).Qualification);
            cv.put(COLUMN_CAT,data_list.get(i).Category);
            cv.put(COLUMN_CITY,data_list.get(i).City);

            cv.put(COLUMN_WHT,data_list.get(i).Email);
            cv.put(COLUMN_IMG,data_list.get(i).Img);

            db.insert(TABLE_NAME, null, cv);
        }

        db.close();
    }
    @Override
    public void onCreate(SQLiteDatabase db) {}

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public ArrayList<ListItem> getAllData(){

        ArrayList<ListItem> DATA= new ArrayList<>();

        String queryStr="SELECT * FROM "+TABLE_NAME;

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(queryStr,null);

        if(cursor.moveToFirst())

            do{
                DATA.add(new ListItem(
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5),
                        cursor.getInt(6)));
            }while (cursor.moveToNext());

        cursor.close();
        db.close();
        return DATA;
    }

    public ListItem getIndx(int id){
        SQLiteDatabase db= this.getReadableDatabase();

//        Cursor cursor = db.rawQuery("SELECT * FROM "+TABLE_NAME+" WHERE "+COLUMN_ID+"="+ id,null);
        ListItem tempListItem=new ListItem("Null","Null","Null","Null","Null",-1);

        Cursor cursor = db.rawQuery("SELECT * FROM "+TABLE_NAME+" WHERE "+COLUMN_ID+"="+Integer.toString(id+1),null);

        cursor.moveToFirst();
        if(cursor.moveToFirst())
            try {
                tempListItem = new ListItem(
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5),
                        cursor.getInt(6));
            }catch(Exception e){
                tempListItem=new ListItem("Null","Null","Null","Null","Null",-1);
            }

        cursor.close();
        db.close();
        return tempListItem;
    }

}
