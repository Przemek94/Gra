package com.example.ziom.jtr;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Menu extends AppCompatActivity {
    DatabaseHelper myDb;
    Button btnnaj;
    String username;
    TextView login;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        myDb = new DatabaseHelper(this);
        btnnaj = (Button) findViewById(R.id.Najlepszy);
        login = (TextView) findViewById(R.id.nick);
        viewAll();


        //sharedPreferences = getSharedPreferences("com.example.ziom.jtr;", Context.MODE_APPEND);
        //editor = sharedPreferences.edit();
        //editor.putString("Username", username);

        //SharedPreferences sharedPreferences = getSharedPreferences("MyData", MODE_PRIVATE);
        //SharedPreferences.Editor editor = sharedPreferences.edit();
        //editor.putString("Login", username);
        //editor.commit();


        android.support.v7.app.ActionBar bar = getSupportActionBar();
        if (bar != null) {
            bar.hide();
        }

        Intent getusername;
        getusername = getIntent();
        username = getusername.getStringExtra("Login");

        login.setText(username);
    }
    


    public  void viewAll() {
        btnnaj.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = myDb.getAllDAta();
                        if (res.getCount() == 0) {
                            showMessage("Błąd", "Brak zapisanych wyników");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            //buffer.append(res.getString(0)+". ");
                            buffer.append(res.getString(1) + ": ");
                            buffer.append(res.getString(2) + "\n\n");
                        }

                        showMessage("Najlepsze Wyniki", buffer.toString());

                    }
                }
        );
    }

    public void showMessage(String title, String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage((Message));
        builder.show();
    }

    public void New_Game(View view) {
        Intent intent = new Intent(this, Start.class);
        startActivity(intent);
        SharedPreferences sharedPreferences = getSharedPreferences("MyData", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Login", username);
        editor.commit();
    }

    public void Help(View view) {
        Intent intent = new Intent(this, Pomoc.class);
        startActivity(intent);
    }

    public void JSON(View view) {
        Intent intent = new Intent(this, JSON.class);
        startActivity(intent);
    }

    public  void logout(View view) {
        Intent intent = new Intent(this, Logowanie.class);
        startActivity(intent);
        super.onPause();
        finish();
    }

    //public void off(View view) {
      //  Intent intent = new Intent(this, Menu.class);
        //startActivity(intent);
    //}

    //public void Wynik(View view) {
      //  Intent intent = new Intent(this, Wynik.class);
        //startActivity(intent);
    //}


}
