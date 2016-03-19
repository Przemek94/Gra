package com.example.ziom.jtr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        android.support.v7.app.ActionBar bar = getSupportActionBar();
        if (bar != null) {
            bar.hide();
        }
    }

    public void New_Game(View view) {
        Intent intent = new Intent(this, Gra.class);
        startActivity(intent);
    }

    public void Help(View view) {
        Intent intent = new Intent(this, Pomoc.class);
        startActivity(intent);
    }

    public void Wynik(View view) {
        Intent intent = new Intent(this, Wynik.class);
        startActivity(intent);
    }


}
