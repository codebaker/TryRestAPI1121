package com.codebakery.joan.tryrestapi1121;

import android.os.AsyncTask;
import android.util.JsonReader;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class OpenWeatherAPITask extends AsyncTask<String, Void, String> {
    @Override
    protected String doInBackground(String... params) {

        String id = params[0];
        String apiKey = "90ea006486e913a15ddf36187febc4ec";
        HttpURLConnection urlConnection=null;
        InputStream inputStream=null;
        JSONObject weather = null;
        try {
            URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q=" + id + "&appid=" +apiKey);
            urlConnection = (HttpURLConnection)url.openConnection();
            inputStream = urlConnection.getInputStream();
            byte[] buffer = new byte[1000];
            inputStream.read(buffer);
            weather = new JSONObject(new String(buffer));

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }finally{
            if(urlConnection !=null) urlConnection.disconnect();
            if(inputStream !=null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return weather.toString();
    }
}
