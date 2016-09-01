package com.example.ziom.jtr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Menu_offline extends AppCompatActivity {
    DatabaseHelper myDb;
    Button NowaGra, Najlepszy, Pomoc;
    String username;
    TextView login;
    String JSON_String;
    final String TAG = this.getClass().getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_offline);
        myDb = new DatabaseHelper(this);
        //btnnaj = (Button) findViewById(R.id.Najlepszy);
        login = (TextView) findViewById(R.id.nick);
        NowaGra = (Button)findViewById(R.id.button);
        Najlepszy = (Button)findViewById(R.id.Najlepszy);
        Pomoc = (Button)findViewById(R.id.button3);
        new BacgroundTask().execute();
        //viewAll();

        android.support.v7.app.ActionBar bar = getSupportActionBar();
        if (bar != null) {
            bar.hide();
        }

        Intent getusername;
        getusername = getIntent();
        username = getusername.getStringExtra("Login");

        login.setText(username);
    }

    class BacgroundTask extends AsyncTask<Void,Void,String>
    {
        String  json_url;
        @Override
        protected void onPreExecute() {
            json_url = "http://serwer1643032.home.pl/json_get_data.php";
        }

        @Override
        protected String doInBackground(Void... voids) {
            try {
                URL url = new URL(json_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder = new StringBuilder();
                while ((JSON_String = bufferedReader.readLine())!=null)
                {
                    stringBuilder.append(JSON_String+"\n");
                }

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return stringBuilder.toString().trim();


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String result) {
            JSON_String = result;
        }


    }

    /*public  void viewAll() {
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
    }*/

    public void New_Game(View view) {
        Thread watek = new Thread() {
            public void run() {
                try {
                    sleep(700);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent intent = new Intent(getBaseContext(), Start.class);
                    startActivity(intent);
                    SharedPreferences sharedPreferences = getSharedPreferences("MyData", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("Login", username);
                    editor.commit();
                }
            }
        };
        final Animation animTranslater = AnimationUtils.loadAnimation(this, R.anim.anim_translater);
        NowaGra.startAnimation(animTranslater);
        watek.start();
    }

    public void Help(View view) {
        Thread watek = new Thread() {
            public void run() {
                try {
                    sleep(700);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent intent = new Intent(getBaseContext(), Pomoc.class);
                    startActivity(intent);
                }
            }
        };
        final Animation animTranslater = AnimationUtils.loadAnimation(this, R.anim.anim_translater);
        Pomoc.startAnimation(animTranslater);
        watek.start();
    }



    public  void login(View view) {
        Intent intent = new Intent(this, Logowanie.class);
        startActivity(intent);
        super.onPause();
        finish();
    }

    //public void off(View view) {
    //  Intent intent = new Intent(this, Menu.class);
    //startActivity(intent);
    //}

    public void Wynik(View view) {
        Thread watek = new Thread() {
            public void run() {
                try {
                    sleep(700);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent intent = new Intent(getBaseContext(), Wynik.class);
                    startActivity(intent);


                }
            }
        };
        final Animation animTranslatel = AnimationUtils.loadAnimation(this, R.anim.anim_translatel);
        Najlepszy.startAnimation(animTranslatel);
        watek.start();
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
        Toast.makeText(Menu_offline.this, "Kliknij dwa razy aby wyjść", Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                twice = false;
                Log.d(TAG, "twice: " + twice);

            }
        }, 3000);

    }


}
