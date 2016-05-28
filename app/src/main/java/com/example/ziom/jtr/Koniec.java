package com.example.ziom.jtr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Koniec extends AppCompatActivity {
    //DatabaseHelper myDb;
    //  EditText editNick;
    // Button btnSave, btnView, bttnUpdate;

    TextView Wynik, NajleszyWynik,login, points;
    long punkty;
    long punkty1;
    long ppunkty;
    public static final String SAVE = "Najlepszy Wynik";
    public static final String DEFAULT = "Login";
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_koniec);
       /* myDb = new DatabaseHelper(this);
        editNick = (EditText) findViewById(R.id.Nick);
        btnSave = (Button) findViewById(R.id.Save);
        btnView = (Button) findViewById(R.id.View);
        bttnUpdate = (Button) findViewById(R.id.Update);


        AddData();
        viewAll();
        UpdateData();*/
        Wynik = (TextView) findViewById(R.id.Wynik);
        NajleszyWynik = (TextView) findViewById(R.id.NajlepszyWynik);
        login = (TextView)findViewById(R.id.login);

        Wynik.setText("punkty");


        Intent getpytanie;
        getpytanie = getIntent();
        punkty = getpytanie.getLongExtra("Punkty", 0);

        ppunkty = punkty;



        SharedPreferences sharedPreferences = getSharedPreferences("MyData" ,MODE_PRIVATE);
        String username = sharedPreferences.getString("Login", DEFAULT);
        login.setText(username);



        SharedPreferences LNW = getSharedPreferences(SAVE, 0);
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




        String wynik =  String.format("%02d", punkty);
        System.out.println(wynik);
        Wynik.setText(wynik);

        String str_username = login.getText().toString();
        String str_points = Wynik.getText().toString();
        String type = "points";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, str_username, str_points);



        android.support.v7.app.ActionBar bar = getSupportActionBar();
        if (bar != null) {
            bar.hide();
        }
    }





   /* public  void UpdateData() {
        bttnUpdate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isUpdate = myDb.updateData(editNick.getText().toString(), punkty);
                        if(isUpdate = true)
                            Toast.makeText(Koniec.this, "Wynik Zaktualizowany", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(Koniec.this, "Błąd aktualizacji wyniku", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }



    public void AddData() {
        btnSave.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertData(editNick.getText().toString(), punkty);
                        if(isInserted = true)
                            Toast.makeText(Koniec.this, "Wynik Zapisany", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(Koniec.this, "Błąd zapisu wyniku", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    public  void viewAll() {
        btnView.setOnClickListener(
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
    }*/

    @Override
    public void onPause() {
        super.onPause();
        finish();


    }
}
