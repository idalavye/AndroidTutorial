package com.idalavye.example.a06_database_demo;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        //Mode Private ile sadece bu uygulama veritabanına erişebilir
//        SQLiteDatabase myDatabase = this.openOrCreateDatabase("Users", MODE_PRIVATE, null);
//        myDatabase.execSQL("CREATE TABLE IF NOT EXISTS users (name VARCHAR,age INT(3))");
//        //myDatabase.execSQL("INSERT INTO users (name,age) VALUES('İbrahim',28)");
//        //myDatabase.execSQL("INSERT INTO users (name,age) VALUES('Ali',27)");
//
//        Cursor c = myDatabase.rawQuery("SELECT * FROM users", null);
//
//        int nameIndex = c.getColumnIndex("name");
//        int ageIndex = c.getColumnIndex("age");
//
//        c.moveToFirst();//go to start position
//        while (c != null) {
//            Log.i("name", c.getString(nameIndex));
//            Log.i("age", c.getString(ageIndex));
//
//            c.moveToNext();
//        }

        try {
            SQLiteDatabase sqLiteDatabase = this.openOrCreateDatabase("Events", MODE_PRIVATE, null);
            sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS events (name VARCHAR,year INT(4))");
            sqLiteDatabase.execSQL("INSERT INTO events (name,year) VALUES('Milenium',2000)");
            sqLiteDatabase.execSQL("INSERT INTO events (name,year) VALUES('Teaching',2012)");

            Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM events", null);
            int nameIndex = c.getColumnIndex("name");
            int yearIndex = c.getColumnIndex("year");
            c.moveToFirst();

            while (c != null) {
                Log.i("Result - event", c.getString(nameIndex));
                Log.i("Result - year", Integer.toString(c.getInt(yearIndex)));

                c.moveToNext();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
