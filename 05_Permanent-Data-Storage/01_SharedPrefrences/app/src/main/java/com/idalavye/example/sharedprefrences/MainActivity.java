package com.idalavye.example.sharedprefrences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = this.getSharedPreferences("com.idalavye.example.sharedprefrences", Context.MODE_PRIVATE);

        /**
         * Aşarıdaki kodu bir kere çalıştırmam yeterli daha sonrasında  sharedPreferences.edit().putString("username", "idalavye").apply(); satırını kaldırsam
         * bile username ile idalavye verisine ulaşabilirim.
         */
        sharedPreferences.edit().putString("username", "idalavye").apply();
        String username = sharedPreferences.getString("username", "anonymous");

        ArrayList<String> friends = new ArrayList<>();
        friends.add("Baran");
        friends.add("Mustafa");
        friends.add("Sefer");

        try {
            sharedPreferences.edit().putString("friends", ObjectSerializer.serialize(friends)).apply();
            Log.i("friends", ObjectSerializer.serialize(friends));
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<String> newFriends = new ArrayList<>();

        try {
            newFriends = (ArrayList<String>) ObjectSerializer.deserialize(sharedPreferences.getString("friends", ObjectSerializer.serialize(new ArrayList<String>())));
            Log.i("New Friends: ", newFriends.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        Log.i("This is the username :", username);
    }
}
