package com.example.ziom.jtr;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {
    DatabaseHelper myDb;
    Button btnnaj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        myDb = new DatabaseHelper(this);
        btnnaj = (Button) findViewById(R.id.Najlepszy);
        viewAll();

        android.support.v7.app.ActionBar bar = getSupportActionBar();
        if (bar != null) {
            bar.hide();
        }
    }

    public  void viewAll() {
        btnnaj.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = myDb.getAllDAta();
                        if(res.getCount() == 0) {
                            showMessage("Błąd","Brak zapisanych wyników");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            //buffer.append(res.getString(0)+". ");
                            buffer.append(res.getString(1)+": ");
                            buffer.append(res.getString(2)+"\n\n");
                        }

                        showMessage("Najlepsze Wyniki",buffer.toString());

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
    }

    public void Help(View view) {
        Intent intent = new Intent(this, Pomoc.class);
        startActivity(intent);
    }

    //public void Wynik(View view) {
      //  Intent intent = new Intent(this, Wynik.class);
        //startActivity(intent);
    //}


}
