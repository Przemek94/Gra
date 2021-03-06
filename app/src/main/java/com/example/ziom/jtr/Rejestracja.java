package com.example.ziom.jtr;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Rejestracja extends AppCompatActivity {
    EditText username, password, email;
    int username_length, password_length;
    final String TAG = this.getClass().getName();
    // String str_username, str_email, str_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rejestracja);
        username = (EditText)findViewById(R.id.et_Username);
        password = (EditText)findViewById(R.id.et_Password);
        email = (EditText)findViewById(R.id.et_Email);

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
        username_length = username.getText().length();
        password_length = password.getText().length();
        if (username_length >= 6 && password_length >= 6) {
            ConnectivityManager cMenager = (ConnectivityManager) getSystemService(this.CONNECTIVITY_SERVICE);
            NetworkInfo nInfo = cMenager.getActiveNetworkInfo();
            if (nInfo != null && nInfo.isConnected()) {
                String str_username = username.getText().toString();
                String str_password = password.getText().toString();
                String str_email = email.getText().toString();
                String type = "register";
                BackgroundWorker backgroundWorker = new BackgroundWorker(this);
                backgroundWorker.execute(type, str_username, str_password, str_email);
            } else {
                Toast.makeText(this, "Brak połączenia z internetem", Toast.LENGTH_LONG).show();

            }
        } else {
            Toast.makeText(this, "Za krótka nazwa użytkownika lub hasło", Toast.LENGTH_LONG).show();
        }
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
