package com.example.day1.network;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class NetManager {

//    page1 = "searchDailyBoxOfficeList.json";
//    page2 = "searchDailyBoxOfficeList.json";
//    page3 = "searchDailyBoxOfficeList.json";
//    page4 = "searchDailyBoxOfficeList.json";
//   domain = http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/

    public void setParam(){

    }

    public void makeRequest() {
        String url = "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=20120101";
        StringRequest request = new StringRequest(
                Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        println("응답 -> " + response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        println("에러 -> " + error.getMessage());
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<String,String>();

                return params;
            }
        };

        request.setShouldCache(false);

        requestQueue.add(request);
        println("요청 보냄.");
    }
}
