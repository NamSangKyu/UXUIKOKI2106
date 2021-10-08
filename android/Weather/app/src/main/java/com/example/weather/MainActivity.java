package com.example.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Weather weather;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        weather = new Weather();
        weather.execute();
    }
    class Weather extends AsyncTask<String,Void,String>{
        int timeList[] = new int[]{2,5,8,11,14,17,20,23};
        public String getTime(){
            int time = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
            int i;
            for(i=0;i<timeList.length;i++){
                if(timeList[i] >= time)
                    break;
            }
            if(i<3 && i != 0)
                return "0" + timeList[i-1] + "00";
            return timeList[i-1] + "00";
        }
        @Override
        protected String doInBackground(String... strings) {
            String apiURL = "http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getVilageFcst";
            String nx, ny, baseTime, serviceKey, numOfRows,dataType, baseDate;
            serviceKey = "hpOVfNem4MVro1QdBZTMTq%2FMZs%2B8yylSvxNQlqPiEQec%2Bo99WRRbIvrVqLltto5W0TmluoxR7uQHpHFNZ146qg%3D%3D";

            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            baseDate = sdf.format(Calendar.getInstance().getTime());
            dataType = "json";
            baseTime = getTime();
            numOfRows = "20";
            nx = "60";
            ny="127";
            apiURL += "?serviceKey="+serviceKey;
            apiURL += "&base_date="+baseDate;
            apiURL += "&base_time="+baseTime;
            apiURL += "&dataType="+dataType;
            apiURL += "&nx="+nx;
            apiURL += "&ny="+ny;
            apiURL += "&numOfRows="+numOfRows;
            URL url = null;
            try {
                url = new URL(apiURL);
                Log.i("result", "doInBackground: "+url.toString());

                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(),"UTF-8"));

                String line;
                String result = new String();
                while((line = br.readLine())!= null)
                    result += line;

                Log.i("result", "doInBackground: "+result);

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}












