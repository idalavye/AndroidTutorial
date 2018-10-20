package com.idalavye.example.memorableplace;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    static ArrayList<String> places = new ArrayList<>();
    static ArrayList<LatLng> locations = new ArrayList<>();
    static ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);

        SharedPreferences sharedPreferences = this.getSharedPreferences("com.idalavye.example.memorableplace", Context.MODE_PRIVATE);
        ArrayList<String> lats = new ArrayList<>();
        ArrayList<String> lons = new ArrayList<>();

        places.clear();
        locations.clear();
        lats.clear();
        lons.clear();

        try {
            places = (ArrayList<String>) ObjectSerializer.deserialize(sharedPreferences.getString("places", ObjectSerializer.serialize(new ArrayList<String>())));
            lats = (ArrayList<String>) ObjectSerializer.deserialize(sharedPreferences.getString("lats", ObjectSerializer.serialize(new ArrayList<String>())));
            lons = (ArrayList<String>) ObjectSerializer.deserialize(sharedPreferences.getString("lons", ObjectSerializer.serialize(new ArrayList<String>())));
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (places.size() > 0 && lats.size() > 0 && lons.size() > 0) {
            if (places.size() == lats.size() && places.size() == lons.size()) {
                for (int i = 0; i < lats.size(); i++) {
                    locations.add(new LatLng(Double.parseDouble(lats.get(i)), Double.parseDouble(lons.get(i))));
                }
            }
        }else{

            //Eğer buraya girerse uygulama ilk defa açılmış demektir.
            places.add("Add a new place...");
            locations.add(new LatLng(0, 0));
        }

        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, places);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(getApplicationContext(), Integer.toString(position), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
                intent.putExtra("placeNumber", position);

                startActivity(intent);
            }
        });
    }
}
