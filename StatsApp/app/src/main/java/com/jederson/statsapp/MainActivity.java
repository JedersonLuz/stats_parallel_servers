package com.jederson.statsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    protected TextView textNumbers = findViewById(R.id.textNumbers);
    public TextView textMean = findViewById(R.id.textMean);
    public TextView textMedian = findViewById(R.id.textMedian);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendNumber(View view) {
        Client client = new Client(textNumbers.toString());
        client.execute();
        textMean.setText("Média" + client.mean);
        textMedian.setText("Mediana" + client.median);
    }
}
