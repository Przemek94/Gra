package com.example.ziom.jtr;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Rejestracja extends AppCompatActivity {
    EditText username, password;
    final String TAG = this.getClass().getName();
    // String str_username, str_email, str_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rejestracja);
        username = (EditText)findViewById(R.id.et_Username);
        password = (EditText)findViewById(R.id.et_Password);

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

    public void OnReg(View view) {
        String str_username = username.getText().toString();
        String str_password = password.getText().toString();
        String type = "register";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, str_username, str_password);

    }

    public  void logowanie(View view) {
        Intent intent = new Intent(this, Logowanie.class);
        startActivity(intent);
    }

    boolean twice =false;
    @Override
    public void onBackPressed() {

        Log.d(TAG, "click");

        if(twice == true){
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
            System.exit(0);
        }
        twice = true;
        Log.d(TAG, "twice: "+twice);
        // super.onBackPressed();
        Toast.makeText(Rejestracja.this, "Kliknij dwa razy aby wyjść", Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                twice = false;
                Log.d(TAG, "twice: " + twice);

            }
        }, 3000);

    }

}
