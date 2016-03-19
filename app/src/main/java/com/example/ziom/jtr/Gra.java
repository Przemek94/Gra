package com.example.ziom.jtr;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Gra extends AppCompatActivity {

    MediaPlayer pytanie;
  Button b5,b2, b3, b4;



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
        b5 = (Button) findViewById(R.id.bttn5);
        b2 = (Button) findViewById(R.id.bttn2);
        b3 = (Button) findViewById(R.id.bttn3);
        b4 = (Button) findViewById(R.id.bttn4);
        pytanie = MediaPlayer.create(this, R.raw.pytanie1);
        pytanie.start();
        b5.setBackgroundColor(0xff2BBCEC);
        b2.setBackgroundColor(0xff2BBCEC);
        b3.setBackgroundColor(0xff2BBCEC);
        b4.setBackgroundColor(0xff2BBCEC);





        android.support.v7.app.ActionBar bar = getSupportActionBar();
        if (bar != null) {
            bar.hide();
        }

       b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b5.setBackgroundColor(0xffff0000);
                b2.setBackgroundColor(0xFF00FF00);
                pytanie.stop();
                Thread watek = new Thread(){
                    public void run(){
                        try {
                            sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        finally {
                            finish();
                        }
                    }
                };
                watek.start();
            }

        });


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b2.setBackgroundColor(0xFF00FF00);
                pytanie.stop();
                Thread watek = new Thread(){
                    public void run(){
                        try {
                            sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        finally {
                            finish();
                        }
                    }
                };
                watek.start();
            }

        });



        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b3.setBackgroundColor(0xffff0000);
                b2.setBackgroundColor(0xFF00FF00);
                pytanie.stop();
                Thread watek = new Thread(){
                    public void run(){
                        try {
                            sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        finally {
                            finish();
                        }
                    }
                };
                watek.start();
            }

        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b4.setBackgroundColor(0xffff0000);
                b2.setBackgroundColor(0xFF00FF00);
                pytanie.stop();
                Thread watek = new Thread() {
                    public void run() {
                        try {
                            sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } finally {
                            finish();
                        }
                    }
                };
                watek.start();
            }

        });


    }

    @Override
    public void onPause() {
        super.onPause();
        finish();

    }










}
