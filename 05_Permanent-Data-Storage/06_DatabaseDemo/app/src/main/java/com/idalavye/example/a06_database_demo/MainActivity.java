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
            SQLiteDatabase sqLiteDatabase = this.openOrCreateDatabase("Users", MODE_PRIVATE, null);
            sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS newUser (name VARCHAR,age INT(3), id INTEGER PRIMARY KEY)");
            sqLiteDatabase.execSQL("INSERT INTO newUser (name,age) VALUES('İbrahim',28)");
            sqLiteDatabase.execSQL("INSERT INTO newUser (name,age) VALUES('MEvlüt',20)");

//            sqLiteDatabase.execSQL("DELETE FROM newUser WHERE name = 'İbrahim' LIMIT 1");

//            Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM newUser WHERE name LIKE '%a%' LIMIT 1", null);
            Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM newUser", null);
            int nameIndex = c.getColumnIndex("name");
            int ageIndex = c.getColumnIndex("age");
            int idIndex = c.getColumnIndex("id");
            c.moveToFirst();

            while (c != null) {
                Log.i("Result - name", c.getString(nameIndex));
                Log.i("Result - age", Integer.toString(c.getInt(ageIndex)));
                Log.i("Result - id", Integer.toString(c.getInt(idIndex)));

                c.moveToNext();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
