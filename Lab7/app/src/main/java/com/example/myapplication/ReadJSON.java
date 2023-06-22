package com.example.myapplication;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class ReadJSON {

    public static Company readCompanyJSONFile (Context context) throws
            IOException,JSONException{
        String jsonText = readText(context, R.raw.company);

        Log.d("text1",jsonText);
        JSONObject jsonRoot = new JSONObject(jsonText);

        String id = jsonRoot.getString("id");
        String name = jsonRoot.getString("name");

        JSONArray jsonArray = jsonRoot.getJSONArray("website");
        String[] websites =  new String[jsonArray.length()];

        for(int i = 0;i < jsonArray.length();i++){
            websites[i] = jsonArray.getString(i);
        }

        JSONObject jsonAddress = jsonRoot.getJSONObject("address");
        String street = jsonAddress.getString("street");
        String city = jsonAddress.getString("city");
        Address address = new Address(street,city);

        Company company = new Company();
        company.setId(id);
        company.setName(name);
        company.setAddress(address);
        company.setWebsites(websites);
        return company;
    }

    private static String readText(Context context, int resId) throws IOException {
        InputStream is = context.getResources().openRawResource(resId);
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String s = "";
        while(br.readLine() !=null){
             s += br.readLine()+"\n";
        }
        return s;
    }
}
