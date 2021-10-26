package com.example.product;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

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

public class MainActivity extends AppCompatActivity {
    CustomListAdapter adapter;
    EditText edtSearch;
    Button btnSearch;
    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtSearch = findViewById(R.id.edt_search);
        btnSearch = findViewById(R.id.btn_search);
        list = findViewById(R.id.list);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Product product = new Product();
                product.execute(edtSearch.getText().toString());
            }
        });

    }
    class Product extends AsyncTask<String, String, Integer>{

        @Override
        protected Integer doInBackground(String... strings) {
            String search = strings[0];
            String apiUrl = "http://nsk2626.cafe24.com/search.do?search="+search;
            int r=0;
            try {
                URL url = new URL(apiUrl);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(),"UTF-8"));

                String line;
                String result = new String();
                while((line = br.readLine())!= null)
                    result += line;

                Log.i("result", "doInBackground: "+result);

                JSONObject json = new JSONObject(result);
                r = json.getInt("code");
                if(json.getInt("code")==200){
                    adapter = new CustomListAdapter();
                    JSONArray arr = json.getJSONArray("responseMessage");
                    for(int i=0;i<arr.length();i++) {
                        JSONObject o = arr.getJSONObject(i);
                        adapter.addItem(new ProductDTO(o.getString("pno"),o.getString("pname"),o.getString("maker"),o.getInt("price")));
                    }
                }
                br.close();
                urlConnection.disconnect();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return r;
        }

        @Override
        protected void onPostExecute(Integer s) {
            super.onPostExecute(s);
            if(s == 200)
                list.setAdapter(adapter);
            else
                Toast.makeText(MainActivity.this,"조회 결과가 없습니다.",Toast.LENGTH_SHORT).show();

        }
    }
}