package com.idalavye.example.timestables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar timesTablesSeekBar = findViewById(R.id.timesTablesSeekBar);
        final ListView timesTables = findViewById(R.id.timesTablesListView);

        int max= 20;
        int startingPosition = 10;

        timesTablesSeekBar.setMax(max);
        timesTablesSeekBar.setProgress(startingPosition);

        timesTablesSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min = 1;
                int timesTableNumber;

                if (progress < min) {
                    timesTableNumber = min;
                    timesTablesSeekBar.setProgress(min);
                } else {
                    timesTableNumber = progress;
                }
                Log.i("Seekbar Value", Integer.toString(timesTableNumber));

                ArrayList<String> timesTableContent = new ArrayList<>();

                for (int i = 1; i <= 100; i++) {
                    timesTableContent.add(Integer.toString(i * timesTableNumber));
                }

                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,timesTableContent);
                timesTables.setAdapter(arrayAdapter);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
