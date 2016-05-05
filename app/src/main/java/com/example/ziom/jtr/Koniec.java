package com.example.ziom.jtr;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class Koniec extends AppCompatActivity {

    TextView Wynik;
    long punkty;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_koniec);
        Wynik = (TextView) findViewById(R.id.Wynik);

        Wynik.setText("punkty");

        Intent getpytanie;
        getpytanie = getIntent();
        punkty = getpytanie.getLongExtra("Punkty", 0);


        String wynik =  String.format("%02d", punkty);
        System.out.println(wynik);
        Wynik.setText(wynik);




        android.support.v7.app.ActionBar bar = getSupportActionBar();
        if (bar != null) {
            bar.hide();
        }
    }
}
