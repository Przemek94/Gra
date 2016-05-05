package com.example.ziom.jtr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Wynik extends AppCompatActivity {

    TextView Wynik;
    long punkty, punkty1;
    public static final String SAVE = "Najlepszy Wynik";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wynik);
        Wynik = (TextView) findViewById(R.id.Wynik);



        Wynik.setText("punkty");

        Intent getpytanie;
        getpytanie = getIntent();
        punkty = getpytanie.getLongExtra("Punkty", 0);


        SharedPreferences LNW = getSharedPreferences(SAVE, 0);
        punkty1 = LNW.getLong("Punkty", 0);
        if(punkty>punkty1){
            String wynik =  String.format("%02d", punkty);
            System.out.println(wynik);
            Wynik.setText(wynik);
            punkty1 = punkty;
            SharedPreferences SNW = getSharedPreferences(SAVE, MODE_PRIVATE);
            SharedPreferences.Editor editor = SNW.edit();
            editor.putLong("Punkty", punkty1);
            editor.apply();
        }
        else
            Wynik.setText(String.valueOf(punkty1));

        android.support.v7.app.ActionBar bar = getSupportActionBar();
        if (bar != null) {
            bar.hide();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        finish();


    }
}