package com.example.ziom.jtr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Pomoc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pomoc);

        android.support.v7.app.ActionBar bar = getSupportActionBar();
        if (bar != null) {
            bar.hide();
        }
    }
}
