package com.example.ziom.jtr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

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


        Random generator = new Random();
        int number = generator.nextInt(20) + 1;
        //20- liczba losowanych activity

        Class activity = null;


        switch(number) {
            case 1:

                activity = Pytanie1.class;
                break;
            case 2:
                activity = Pytanie2.class;
                break;
            case 3:
                activity = Pytanie3.class;
                break;
            case 4:
                activity = Pytanie4.class;
                break;
            case 5:
                activity = Pytanie5.class;
                break;
            case 6:
                activity = Pytanie6.class;
                break;
            case 7:
                activity = Pytanie7.class;
                break;
            case 8:
                activity = Pytanie8.class;
                break;
            case 9:
                activity = Pytanie9.class;
                break;
            case 10:
                activity = Pytanie10.class;
                break;
            case 11:
                activity = Pytanie11.class;
                break;
            case 12:
                activity = Pytanie12.class;
                break;
            case 13:
                activity = Pytanie13.class;
                break;
            case 14:
                activity = Pytanie14.class;
                break;
            case 15:
                activity = Pytanie15.class;
                break;
            case 16:
                activity = Pytanie16.class;
                break;
            case 17:
                activity = Pytanie17.class;
                break;
            case 18:
                activity = Pytanie18.class;
                break;
            case 19:
                activity = Pytanie19.class;
                break;
            default:
                activity = Pytanie20.class;
                break;
        }

        Intent intent = new Intent(getBaseContext(), activity);
        startActivity(intent);
    }



    @Override
    public void onPause() {
        super.onPause();
        finish();

    }
}

