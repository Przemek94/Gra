package com.example.ziom.jtr;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class Logowanie extends AppCompatActivity {

    private EditText username, password;
    private Button logowanie;
    private RequestQueue requestQueue;
    private static final String URL = "http://serwer1643032.home.pl/user_control.php";
    private StringRequest request;
    String login;
    final String TAG = this.getClass().getName();


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logowanie);

        ConnectivityManager cMenager = (ConnectivityManager) getSystemService(this.CONNECTIVITY_SERVICE);
        NetworkInfo nInfo = cMenager.getActiveNetworkInfo();
        if (nInfo != null && nInfo.isConnected()) {
            Toast.makeText(this, "Połączono", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Brak połączenia z internetem", Toast.LENGTH_LONG).show();

        }

        android.support.v7.app.ActionBar bar = getSupportActionBar();
        if (bar != null) {
            bar.hide();
        }

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        logowanie = (Button) findViewById(R.id.logowanie);


        requestQueue = Volley.newRequestQueue(this);
    }



        //logowanie.setOnClickListener(new View.OnClickListener() {
        public void Zaloguj(View view){

            ConnectivityManager cMenager = (ConnectivityManager) getSystemService(this.CONNECTIVITY_SERVICE);
            NetworkInfo nInfo = cMenager.getActiveNetworkInfo();
            if (nInfo != null && nInfo.isConnected()) {
                request = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            if (jsonObject.names().get(0).equals("success")) {
                                Toast.makeText(getApplicationContext(), "Zalogowano." + jsonObject.getString("success"), Toast.LENGTH_SHORT).show();
                                //startActivity(new Intent(getApplicationContext(), Menu.class));
                                Intent intent = new Intent(getApplicationContext(), Menu.class);
                                intent.putExtra("Login", username.getText().toString());
                                startActivity(intent);


                            } else {
                                Toast.makeText(getApplicationContext(), "Błąd logowania " + jsonObject.getString("error"), Toast.LENGTH_SHORT).show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        HashMap<String, String> hashMap = new HashMap<String, String>();
                        hashMap.put("username", username.getText().toString());
                        hashMap.put("password", password.getText().toString());

                        return hashMap;
                    }
                };

                requestQueue.add(request);
            }
            else {
                Toast.makeText(this, "Brak połączenia z internetem", Toast.LENGTH_LONG).show();
            }














    }


    public void Rejestracja(View view) {
        Intent intent = new Intent(this, Rejestracja.class);
        startActivity(intent);
    }


    public void off(View view) {
        Intent intent = new Intent(this, Menu_offline.class);
        startActivity(intent);
    }

    @Override
    public void onPause() {
        super.onPause();
        finish();
    }

    boolean twice=false;
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
        Toast.makeText(Logowanie.this, "Kliknij dwa razy aby wyjść", Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                twice = false;
                Log.d(TAG, "twice: " + twice);

            }
        }, 3000);

    }

}








