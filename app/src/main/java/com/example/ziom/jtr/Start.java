package com.example.ziom.jtr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Start extends AppCompatActivity {

    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        b1 = (Button) findViewById(R.id.button4);
        b1.setBackgroundColor(0xff2BBCEC);

        android.support.v7.app.ActionBar bar = getSupportActionBar();
        if (bar != null) {
            bar.hide();
        }
    }

    public void Start(View view) {
        Intent intent = new Intent(this, Pytanie1.class);
        startActivity(intent);
    }

    @Override
    public void onPause() {
        super.onPause();
        finish();

    }
}
