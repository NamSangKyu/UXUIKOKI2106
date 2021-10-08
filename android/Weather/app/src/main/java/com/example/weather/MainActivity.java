package com.example.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Weather weather;
    TextView detail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        detail = findViewById(R.id.detail);
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
            numOfRows = "14";
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
            JSONObject r = new JSONObject();
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
                JSONObject json = new JSONObject(result);
                //reponse -> body -> items -> item -> 배열
                JSONArray arr = json.getJSONObject("response").getJSONObject("body").getJSONObject("items").getJSONArray("item");

                for(int i=0;i<arr.length();i++) {
                    //Log.i("result", "doInBackground: "+arr.get(i));
                    JSONObject obj = (JSONObject) arr.get(i);

                    if (obj.getString("category").equals("TMP")) {
                        Log.i("result", obj.getString("category") + " : " + obj.getString("fcstValue"));
                        r.put(obj.getString("category"), obj.getString("fcstValue"));
                    }else if(obj.getString("category").equals("PTY")) {
                        Log.i("result", obj.getString("category") + " : " + obj.getString("fcstValue"));
                        r.put(obj.getString("category"), obj.getString("fcstValue"));
                    }else if(obj.getString("category").equals("REH")) {
                        Log.i("result", obj.getString("category") + " : " + obj.getString("fcstValue"));
                        r.put(obj.getString("category"), obj.getString("fcstValue"));
                    }else if(obj.getString("category").equals("SKY")) {
                        Log.i("result", obj.getString("category") + " : " + obj.getString("fcstValue"));
                        r.put(obj.getString("category"), obj.getString("fcstValue"));
                    }
                    }
                } catch (ProtocolException protocolException) {
                protocolException.printStackTrace();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (JSONException jsonException) {
                jsonException.printStackTrace();
            }
            return r.toString();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                JSONObject json = new JSONObject(s);
                String msg = "온도 : "+json.getString("TMP") +"\n" +
                        "강수형태 : "+json.getString("PTY") +"\n" +
                        "하늘상태 : "+json.getString("SKY") +"\n" +
                        "습도 : "+json.getString("REH") +"\n";
                
                detail.setText(msg);
                        
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}












