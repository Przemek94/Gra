package com.example.ziom.jtr;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@TargetApi(Build.VERSION_CODES.GINGERBREAD)
@SuppressLint("NewApi")

public class Pytanie28 extends AppCompatActivity {

    MediaPlayer pytanie;
    Button b1,b2, b3, b4, b5;
    TextView textViewTime;
    long millis, punkty;
    public static final int TIMER_RUNTIMER = 15000;
    public boolean mbActivie;
    public ProgressBar mProgressBar;
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
        setContentView(R.layout.activity_pytanie28);
        b1 = (Button) findViewById(R.id.bttn1);
        b2 = (Button) findViewById(R.id.bttn2);
        b3 = (Button) findViewById(R.id.bttn3);
        b4 = (Button) findViewById(R.id.bttn4);
        b5 = (Button) findViewById(R.id.bttn5);
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        textViewTime = (TextView) findViewById(R.id.textViewTime);
        pytanie = MediaPlayer.create(this, R.raw.pytanie28);
        pytanie.start();
        b1.setBackgroundDrawable(getResources().getDrawable(R.drawable.shape));
        b2.setBackgroundDrawable(getResources().getDrawable(R.drawable.shape));
        b3.setBackgroundDrawable(getResources().getDrawable(R.drawable.shape));
        b4.setBackgroundDrawable(getResources().getDrawable(R.drawable.shape));
        b5.setBackgroundDrawable(getResources().getDrawable(R.drawable.shape));
        b1.setEnabled(false);

        textViewTime.setText("15");

        Intent getpytanie;
        getpytanie = getIntent();
        punkty = getpytanie.getLongExtra("Punkty", 0);



        timer.start();

        final Thread timerThread = new Thread() {
            @Override
            public void run() {
                mbActivie = true;
                try {
                    int waited = 0;
                    while (mbActivie && (waited < TIMER_RUNTIMER)) {
                        sleep(200);
                        if (mbActivie) {
                            waited += 200;
                            updateProgress(waited);
                        }
                    }
                } catch (InterruptedException e) {

                } finally {
                    onContinue();
                }
            }
        };
        timerThread.start();





        android.support.v7.app.ActionBar bar = getSupportActionBar();
        if (bar != null) {
            bar.hide();
        }

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b5.setBackgroundDrawable(getResources().getDrawable(R.drawable.shape3));
                b2.setBackgroundDrawable(getResources().getDrawable(R.drawable.shape2));
                pytanie.stop();
                b2.setEnabled(false);
                b3.setEnabled(false);
                b4.setEnabled(false);
                b5.setEnabled(false);
                timer.cancel();
                b1.setEnabled(true);
                mbActivie = false;


            }

        });


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b2.setBackgroundDrawable(getResources().getDrawable(R.drawable.shape2));
                pytanie.stop();
                b2.setEnabled(false);
                b3.setEnabled(false);
                b4.setEnabled(false);
                b5.setEnabled(false);
                timer.cancel();
                b1.setEnabled(true);
                punkty = punkty + millis;
                mbActivie = false;


            }

        });



        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b3.setBackgroundDrawable(getResources().getDrawable(R.drawable.shape3));
                b2.setBackgroundDrawable(getResources().getDrawable(R.drawable.shape2));
                pytanie.stop();
                b2.setEnabled(false);
                b3.setEnabled(false);
                b4.setEnabled(false);
                b5.setEnabled(false);
                timer.cancel();
                b1.setEnabled(true);
                mbActivie = false;


            }

        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b4.setBackgroundDrawable(getResources().getDrawable(R.drawable.shape3));
                b2.setBackgroundDrawable(getResources().getDrawable(R.drawable.shape2));
                pytanie.stop();
                b2.setEnabled(false);
                b3.setEnabled(false);
                b4.setEnabled(false);
                b5.setEnabled(false);
                timer.cancel();
                b1.setEnabled(true);
                mbActivie = false;


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

            millis = millisUntilFinished;
            String hms = String.format("%02d", TimeUnit.MILLISECONDS.toSeconds(millis));
            System.out.println(hms);
            textViewTime.setText(hms);
        }

        @Override
        public void onFinish() {
            // TODO Auto-generated method stub
            pytanie.stop();
            b2.setBackgroundDrawable(getResources().getDrawable(R.drawable.shape2));
            textViewTime.setText("Koniec Czasu");
            b1.setEnabled(true);
            b2.setEnabled(false);
            b3.setEnabled(false);
            b4.setEnabled(false);
            b5.setEnabled(false);
        }



    }
    public void Dalej(View view) {
        Thread watek = new Thread(){
            public void run(){
                try {
                    sleep(700);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    Random generator = new Random();
                    int number = generator.nextInt(20) + 1;
                    //20- liczba losowanych activity

                    Class activity = null;


                    switch(number) {
                        case 1:

                            activity = Pytanie41.class;
                            break;
                        case 2:
                            activity = Pytanie42.class;
                            break;
                        case 3:
                            activity = Pytanie43.class;
                            break;
                        case 4:
                            activity = Pytanie44.class;
                            break;
                        case 5:
                            activity = Pytanie45.class;
                            break;
                        case 6:
                            activity = Pytanie46.class;
                            break;
                        case 7:
                            activity = Pytanie47.class;
                            break;
                        case 8:
                            activity = Pytanie48.class;
                            break;
                        case 9:
                            activity = Pytanie49.class;
                            break;
                        case 10:
                            activity = Pytanie50.class;
                            break;
                        case 11:
                            activity = Pytanie51.class;
                            break;
                        case 12:
                            activity = Pytanie52.class;
                            break;
                        case 13:
                            activity = Pytanie53.class;
                            break;
                        case 14:
                            activity = Pytanie54.class;
                            break;
                        case 15:
                            activity = Pytanie55.class;
                            break;
                        case 16:
                            activity = Pytanie56.class;
                            break;
                        case 17:
                            activity = Pytanie57.class;
                            break;
                        case 18:
                            activity = Pytanie58.class;
                            break;
                        case 19:
                            activity = Pytanie59.class;
                            break;
                        default:
                            activity = Pytanie60.class;
                            break;
                    }

                    Intent intent = new Intent(getBaseContext(), activity);
                    intent.putExtra("Punkty", punkty);
                    startActivity(intent);
                }
            }
        };

        final Animation animTranslater = AnimationUtils.loadAnimation(this, R.anim.anim_translater);
        final Animation animTranslatel = AnimationUtils.loadAnimation(this, R.anim.anim_translatel);
        b5.startAnimation(animTranslater);
        b3.startAnimation(animTranslatel);
        b2.startAnimation(animTranslater);
        b4.startAnimation(animTranslatel);
        watek.start();


    }


    @Override
    public void onPause() {
        super.onPause();
        finish();
        timer.cancel();


    }





    public void updateProgress(final int timePassed) {
        if(null != mProgressBar) {

            final int progress = mProgressBar.getMax() * timePassed / TIMER_RUNTIMER;
            mProgressBar.setProgress(progress);
        }
    }

    public void onContinue() {
        Log.d("messagmentFinal", "Cos tam po francusku");
    }




}
