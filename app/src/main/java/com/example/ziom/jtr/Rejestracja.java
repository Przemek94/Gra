package com.example.ziom.jtr;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class Rejestracja extends AppCompatActivity {
    EditText username, email, password;
   // String str_username, str_email, str_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rejestracja);
        username = (EditText)findViewById(R.id.et_UserName);
        email = (EditText)findViewById(R.id.et_Email);
        password = (EditText)findViewById(R.id.et_Password);
    }

    @Override
    public void onPause() {
        super.onPause();
        finish();
    }

    public void OnReg(View view) {
        String str_username = username.getText().toString();
        String str_email = email.getText().toString();
        String str_password = password.getText().toString();
        String type = "register";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, str_username, str_email, str_password);

    }
}
