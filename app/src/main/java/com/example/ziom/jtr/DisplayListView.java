package com.example.ziom.jtr;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class DisplayListView extends AppCompatActivity {
    String JSON_String;
    JSONObject jsonObject;
    JSONArray jsonArray;
    PunktyAdepter punktyAdepter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_listview_layout);
        listView = (ListView)findViewById(R.id.listview);

        android.support.v7.app.ActionBar bar = getSupportActionBar();
        if (bar != null) {
            bar.hide();
        }

        new BacgroundTask().execute();


        punktyAdepter = new PunktyAdepter(this, R.layout.row_layout);
        listView.setAdapter(punktyAdepter);
        JSON_String = getIntent().getExtras().getString("json_data");
        try {
            jsonObject = new JSONObject(JSON_String);
            jsonArray = jsonObject.getJSONArray("serwer_response");
            int count=0;
            int nr = 1;
            String username, points, id;


            while (count<jsonArray.length())
            {
                JSONObject JO = jsonArray.getJSONObject(count);
                username = JO.getString("username");
                points = JO.getString("points");
                id = String.valueOf(nr);
                Punkty punkty = new Punkty(id, username, points);
                punktyAdepter.add(punkty);

                count++;
                nr++;

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    class BacgroundTask extends AsyncTask<Void,Void,String>
    {
        String  json_url;
        @Override
        protected void onPreExecute() {
            json_url = "http://serwer1643032.home.pl/json_get_data2.php";
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
}
