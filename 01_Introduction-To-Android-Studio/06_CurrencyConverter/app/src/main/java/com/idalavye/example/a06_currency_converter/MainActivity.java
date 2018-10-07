package com.idalavye.example.a06_currency_converter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void convertCurrency(View v){
        Log.i("Info","Button pressed");

        EditText editText = findViewById(R.id.editText2);
        Log.i("Info",editText.getText().toString());

        String amountInPounds = editText.getText().toString();
        double amountInDollars = Double.parseDouble(amountInPounds) * 1.3;

        //Toast.makeText(this,Double.toString(amountInDollars),Toast.LENGTH_LONG).show();
        Toast.makeText(this,String.format("%.2f",amountInDollars),Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
