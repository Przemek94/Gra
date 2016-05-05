package com.example.ziom.jtr;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.content.SharedPreferences;

import java.util.concurrent.TimeUnit;

public class Koniec extends AppCompatActivity {

    TextView Wynik, NajleszyWynik;
    long punkty, punkty1, ppunkty;
    public static final String SAVE = "Najlepszy Wynik";
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_koniec);
        Wynik = (TextView) findViewById(R.id.Wynik);
        NajleszyWynik = (TextView) findViewById(R.id.NajlepszyWynik);

        Wynik.setText("punkty");

        Intent getpytanie;
        getpytanie = getIntent();
        punkty = getpytanie.getLongExtra("Punkty", 0);

        ppunkty = punkty;



        SharedPreferences LNW = getSharedPreferences(SAVE, 0);
        punkty1 = LNW.getLong("Punkty", 0);
        if(ppunkty>punkty1){
            String wynik =  String.format("%02d", ppunkty);
            System.out.println(wynik);
            NajleszyWynik.setText(wynik);
            punkty1 = ppunkty;
            SharedPreferences SNW = getSharedPreferences(SAVE, MODE_PRIVATE);
            SharedPreferences.Editor editor = SNW.edit();
            editor.putLong("Punkty", punkty1);
            editor.apply();
        }
        else
            NajleszyWynik.setText(String.valueOf(punkty1));




        String wynik =  String.format("%02d", punkty);
        System.out.println(wynik);
        Wynik.setText(wynik);



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
