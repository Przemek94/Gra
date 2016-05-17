package com.example.ziom.jtr;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;


public class Logowanie extends ActionBarActivity {
    EditText UsernameEt, PasswordEt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logowanie);
        UsernameEt = (EditText)findViewById(R.id.etUserName);
        PasswordEt = (EditText)findViewById(R.id.etPassword);
    }

    public void OnLogin(View view) {
        String username = UsernameEt.getText().toString();
        String password = PasswordEt.getText().toString();
        String type = "login";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, username, password);
    }

    public void Rejestracja(View view) {
        Intent intent = new Intent(this, Rejestracja.class);
        startActivity(intent);
    }

    public void off(View view) {
        Intent intent = new Intent(this, Menu.class);
        startActivity(intent);
    }

    @Override
    public void onPause() {
        super.onPause();
        finish();
    }









}