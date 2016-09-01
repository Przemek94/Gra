package com.example.ziom.jtr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class BonusKoniec extends AppCompatActivity {
    //DatabaseHelper myDb;
    //  EditText editNick;
    // Button btnSave, btnView, bttnUpdate;

    TextView Wynik, NajleszyWynik,login, points;
    long punkty;
   /// long punkty1;
    long ppunkty;
    //public static final String SAVE = "Najlepszy Wynik";
    public static final String DEFAULT = "Login";
    Intent intent;
    String username;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bonus_koniec);
       /* myDb = new DatabaseHelper(this);
        editNick = (EditText) findViewById(R.id.Nick);
        btnSave = (Button) findViewById(R.id.Save);
        btnView = (Button) findViewById(R.id.View);
        bttnUpdate = (Button) findViewById(R.id.Update);


        AddData();
        viewAll();
        UpdateData();*/
        Wynik = (TextView) findViewById(R.id.Wynik);
       // NajleszyWynik = (TextView) findViewById(R.id.NajlepszyWynik);
        login = (TextView)findViewById(R.id.login);

        Wynik.setText("punkty");


        Intent getpytanie;
        getpytanie = getIntent();
        punkty = getpytanie.getLongExtra("Punkty", 0);

        ppunkty = punkty;



        SharedPreferences sharedPreferences = getSharedPreferences("MyData" ,MODE_PRIVATE);
        username = sharedPreferences.getString("Login", DEFAULT);




        /*SharedPreferences LNW = getSharedPreferences(SAVE, 0);
        punkty1 = LNW.getLong("Punkty", 0);
        if(ppunkty>punkty1){
            String wynik =  String.format("%02d", ppunkty);
            System.out.println(wynik);
            NajleszyWynik.setText(wynik);
            punkty1 = ppunkty;
            SharedPreferences SNW = getSharedPreferences(SAVE, MODE_PRIVATE);
            SharedPreferences.Editor editor = SNW.edit();
            editor.putLong("Punkty", punkty1);
            editor.apply();
        }
        else
            NajleszyWynik.setText(String.valueOf(punkty1));
*/



        String wynik =  String.format("%02d", punkty);
        System.out.println(wynik);
        Wynik.setText(wynik);




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
}
