package com.idalavye.example.a02_animations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public void fade(View v){
        Log.i("Info","Imageview has been tabbed");

        ImageView bartImageView = findViewById(R.id.bartImageView);
        ImageView homerImageView = findViewById(R.id.homerImageView);

        /*
        if(homerImageView.getAlpha() == 0){
            homerImageView.animate().alpha(1).setDuration(2000);
            bartImageView.animate().alpha(0).setDuration(2000);
        }else{
            homerImageView.animate().alpha(0).setDuration(2000);
            bartImageView.animate().alpha(1).setDuration(2000);
        }
        */

        /*
        bartImageView.animate().translationX(-1000).setDuration(2000);
        */

        /*
        bartImageView.animate().rotation(1800).alpha(0).setDuration(2000);
        */

        bartImageView.animate().scaleX(0.5f).scaleY(0.5f).setDuration(2000);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = findViewById(R.id.bartImageView);

        imageView.setX(-1000);
        imageView.animate().translationXBy(1000).rotation(1800).setDuration(2000);
    }
}
