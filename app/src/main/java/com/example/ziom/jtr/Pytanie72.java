package com.example.ziom.jtr;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@TargetApi(Build.VERSION_CODES.GINGERBREAD)
@SuppressLint("NewApi")

public class Pytanie72 extends AppCompatActivity {

    MediaPlayer pytanie;
    Button b1,b2, b3, b4, b5;
    TextView textViewTime;
    final CounterClass timer = new CounterClass(15000, 1000);




    @Override
    public void onStop() {
        super.onStop();
        pytanie.release();
        finish();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pytanie72);
        b1 = (Button) findViewById(R.id.bttn1);
        b2 = (Button) findViewById(R.id.bttn2);
        b3 = (Button) findViewById(R.id.bttn3);
        b4 = (Button) findViewById(R.id.bttn4);
        b5 = (Button) findViewById(R.id.bttn5);
        textViewTime = (TextView) findViewById(R.id.textViewTime);
        pytanie = MediaPlayer.create(this, R.raw.pytanie72);
        pytanie.start();
        b1.setBackgroundColor(0xff2BBCEC);
        b2.setBackgroundColor(0xff2BBCEC);
        b3.setBackgroundColor(0xff2BBCEC);
        b4.setBackgroundColor(0xff2BBCEC);
        b5.setBackgroundColor(0xff2BBCEC);
        b1.setEnabled(false);

        textViewTime.setText("15");



        timer.start();





        android.support.v7.app.ActionBar bar = getSupportActionBar();
        if (bar != null) {
            bar.hide();
        }

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b5.setBackgroundColor(0xFF00FF00);
                pytanie.stop();
                b2.setEnabled(false);
                b3.setEnabled(false);
                b4.setEnabled(false);
                timer.cancel();
                b1.setEnabled(true);

            }

        });


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b2.setBackgroundColor(0xffff0000);
                b5.setBackgroundColor(0xFF00FF00);
                pytanie.stop();
                b5.setEnabled(false);
                b3.setEnabled(false);
                b4.setEnabled(false);
                timer.cancel();
                b1.setEnabled(true);

            }

        });



        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b3.setBackgroundColor(0xffff0000);
                b5.setBackgroundColor(0xFF00FF00);
                pytanie.stop();
                b2.setEnabled(false);
                b5.setEnabled(false);
                b4.setEnabled(false);
                timer.cancel();
                b1.setEnabled(true);

            }

        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b4.setBackgroundColor(0xffff0000);
                b5.setBackgroundColor(0xFF00FF00);
                pytanie.stop();
                b2.setEnabled(false);
                b5.setEnabled(false);
                b3.setEnabled(false);
                timer.cancel();
                b1.setEnabled(true);

            }

        });


    }

    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    @SuppressLint("NewApi")
    public class CounterClass extends CountDownTimer {

        public CounterClass(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
            // TODO Auto-generated constructor stub
        }

        @SuppressLint("NewApi")
        @TargetApi(Build.VERSION_CODES.GINGERBREAD)
        @Override
        public void onTick(long millisUntilFinished) {
            // TODO Auto-generated method stub

            long millis = millisUntilFinished;
            String hms = String.format("%02d", TimeUnit.MILLISECONDS.toSeconds(millis));
            System.out.println(hms);
            textViewTime.setText(hms);
        }

        @Override
        public void onFinish() {
            // TODO Auto-generated method stub
            pytanie.stop();
            b5.setBackgroundColor(0xFF00FF00);
            textViewTime.setText("Koniec Czasu");
            b1.setEnabled(true);
            b2.setEnabled(false);
            b3.setEnabled(false);
            b4.setEnabled(false);
            b5.setEnabled(false);
        }



    }
    public void Dalej(View view) {
        Random generator = new Random();
        int number = generator.nextInt(20) + 1;
        //20- liczba losowanych activity

        Class activity = null;


        switch(number) {
            case 1:

                activity = Pytanie81.class;
                break;
            case 2:
                activity = Pytanie82.class;
                break;
            case 3:
                activity = Pytanie83.class;
                break;
            case 4:
                activity = Pytanie84.class;
                break;
            case 5:
                activity = Pytanie85.class;
                break;
            case 6:
                activity = Pytanie86.class;
                break;
            case 7:
                activity = Pytanie87.class;
                break;
            case 8:
                activity = Pytanie88.class;
                break;
            case 9:
                activity = Pytanie89.class;
                break;
            case 10:
                activity = Pytanie90.class;
                break;
            case 11:
                activity = Pytanie91.class;
                break;
            case 12:
                activity = Pytanie92.class;
                break;
            case 13:
                activity = Pytanie93.class;
                break;
            case 14:
                activity = Pytanie94.class;
                break;
            case 15:
                activity = Pytanie95.class;
                break;
            case 16:
                activity = Pytanie96.class;
                break;
            case 17:
                activity = Pytanie97.class;
                break;
            case 18:
                activity = Pytanie98.class;
                break;
            case 19:
                activity = Pytanie99.class;
                break;
            default:
                activity = Pytanie100.class;
                break;
        }

        Intent intent = new Intent(getBaseContext(), activity);
        startActivity(intent);
    }


    @Override
    public void onPause() {
        super.onPause();
        finish();
        timer.cancel();


    }










}
