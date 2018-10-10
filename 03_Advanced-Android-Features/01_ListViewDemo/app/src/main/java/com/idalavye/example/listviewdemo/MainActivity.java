package com.idalavye.example.listviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static java.util.Arrays.asList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView myFriendListView = findViewById(R.id.myFriendListView);

        final ArrayList<String> myFriends = new ArrayList<>(asList("Mevlüt", "Baran", "Sefer", "Muhammed"));
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, myFriends);
        myFriendListView.setAdapter(arrayAdapter);

        myFriendListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //parent.setVisibility(View.INVISIBLE);

                Toast.makeText(MainActivity.this, "Person Selected: " + myFriends.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
