package com.jederson.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public EditText textNumbers;
    public static TextView textMean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendNumber(View view) throws InterruptedException {
        textMean = findViewById(R.id.textMean);
        Client client = new Client("1,2,3,8,10,22,31");
        client.execute();
    }

    public static void updateData(String mean, String median) {
        Log.d("update", mean + " " + median);
        textMean.setText(mean + " " + median);
    }
}
