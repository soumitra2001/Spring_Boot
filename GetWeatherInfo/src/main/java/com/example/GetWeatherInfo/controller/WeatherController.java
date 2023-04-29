package com.example.GetWeatherInfo.controller;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


@RestController
public class WeatherController {

    public static void main(String[] args) throws Exception {
        URL getURL = new URL("https://api.open-meteo.com/v1/forecast?latitude=22.65&longitude=88.45&current_weather=true");

        HttpURLConnection connection =(HttpURLConnection) getURL.openConnection();

        int statusCode=connection.getResponseCode();

        if(statusCode==200){
            BufferedReader resource = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuffer data = new StringBuffer();
            String readLine=null;

            while((readLine=resource.readLine()) != null){
                data.append(readLine);
            }
            JSONObject jsonData=new JSONObject(data.toString());
            JSONObject weatherInfo=(JSONObject) jsonData.get("current_weather");

            System.out.println("Temperature: "+weatherInfo.getDouble("temperature"));
            System.out.println("Wind Speed: "+weatherInfo.getDouble("windspeed"));
            System.out.println("Time: "+weatherInfo.get("time"));

        }else {
            System.out.println("Enter a Valid URL : "+statusCode);
        }

    }

}
