package com.example.ziom.jtr;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class StartBonus extends AppCompatActivity {

    ImageButton b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_bonus);
        b1 = (ImageButton) findViewById(R.id.button4);


        android.support.v7.app.ActionBar bar = getSupportActionBar();
        if (bar != null) {
            bar.hide();
        }
    }

    public void Start(View view) {



        Intent intent = new Intent(this, BonusPyt1.class);
        startActivity(intent);
    }



    @Override
    public void onPause() {
        super.onPause();
        finish();

    }
}

