package com.example.ziom.jtr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


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

        punktyAdepter = new PunktyAdepter(this, R.layout.row_layout);
        listView.setAdapter(punktyAdepter);
        JSON_String = getIntent().getExtras().getString("json_data");
        try {
            jsonObject = new JSONObject(JSON_String);
            jsonArray = jsonObject.getJSONArray("serwer_response");
            int count=0;
            String username, points;

            while (count<jsonArray.length())
            {
                JSONObject JO = jsonArray.getJSONObject(count);
                username = JO.getString("username");
                points = JO.getString("points");
                Punkty punkty = new Punkty(username, points);
                punktyAdepter.add(punkty);

                count++;
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}
