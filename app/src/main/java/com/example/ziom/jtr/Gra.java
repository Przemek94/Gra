package com.example.ziom.jtr;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Gra extends AppCompatActivity {

    MediaPlayer pytanie;

    @Override
    public void onStop() {
        super.onStop();
        pytanie.release();
        finish();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gra);
        pytanie = MediaPlayer.create(this, R.raw.ostr);
        pytanie.start();



        android.support.v7.app.ActionBar bar = getSupportActionBar();
        if (bar != null) {
            bar.hide();
        }
    }



    public void Dobrze(View view) {
        Intent intent = new Intent(this, dobrze.class);
        startActivity(intent);
    }

    public void Zle(View view) {
        Intent intent = new Intent(this, zle.class);
        startActivity(intent);
    }



}
