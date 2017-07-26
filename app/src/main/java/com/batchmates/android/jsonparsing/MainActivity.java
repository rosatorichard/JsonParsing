package com.batchmates.android.jsonparsing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String response="{\"menu\": {\n" +
                "  \"id\": \"file\",\n" +
                "  \"value\": \"File\",\n" +
                "  \"popup\": {\n" +
                "    \"menuitem\": [\n" +
                "      {\"value\": \"New\", \"onclick\": \"CreateNewDoc()\"},\n" +
                "      {\"value\": \"Open\", \"onclick\": \"OpenDoc()\"},\n" +
                "      {\"value\": \"Close\", \"onclick\": \"CloseDoc()\"}\n" +
                "    ]\n" +
                "  }\n" +
                "}}";

        try {
            parseJson(response);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }




    public void parseJson(String s) throws JSONException {
        Log.d("HERE", "parseJson: ");
        JSONObject JsonObject=new JSONObject(s);
        JSONObject jsonMenu=JsonObject.getJSONObject("menu");
        JSONObject JsonPupup=jsonMenu.getJSONObject("popup");
        JSONArray jsonMenuItem=JsonPupup.getJSONArray("menuitem");


        JSONArray newJson=JsonObject.getJSONObject("menu")
                .getJSONObject("popup")
                .getJSONArray("menuitem");


        for (int i = 0; i < jsonMenuItem.length(); i++) {
//            JSONObject jsonObject= (JSONObject) jsonMenuItem.get(i);
            JSONObject jsonObject= (JSONObject) newJson.get(i);
            System.out.println(jsonObject.getString("onclick"));
        }
    }
}
