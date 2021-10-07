package com.example.searchapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {
    EditText edtSearch;
    Button btnSearch;
    BlogSearch blogSearch;
    NewsSearch newsSearch;
    ListView blogList;
    ListView newList;
    CustomListAdapter adapterBlog;
    CustomListAdapter adapterNews;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        blogList = findViewById(R.id.lst_blog);
        newList = findViewById(R.id.lst_news);
        edtSearch = findViewById(R.id.edt_search);
        btnSearch = findViewById(R.id.btn_search);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                blogSearch  = new BlogSearch();
                blogSearch.execute();
                newsSearch = new NewsSearch();
                newsSearch.execute();
            }
        });
        blogList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ListViewItem item = (ListViewItem) adapterBlog.getItem(i);
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(item.getUrl()));
                startActivity(intent);

            }
        });
        newList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ListViewItem item = (ListViewItem) adapterNews.getItem(i);
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(item.getUrl()));
                startActivity(intent);

            }
        });
    }
    class BlogSearch extends AsyncTask<String,String,String>{

        @Override
        protected String doInBackground(String... strings) {
            String clientId = "_1rIIr0u6hwdD4VpqYnd";//애플리케이션 클라이언트 아이디값";
            String clientSecret = "k5ERzutCdQ";//애플리케이션 클라이언트 시크릿값";
            String msg = null;
            HttpURLConnection con = null;
            BufferedReader br = null;
            String result = "";
            String text = edtSearch.getText().toString();
            try {
                text = URLEncoder.encode(text, "UTF-8");
                //해당 주소 url 연결
                URL url = new URL("https://openapi.naver.com/v1/search/blog.json?query=" + text);
                con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                con.setRequestProperty("X-Naver-Client-Id", clientId);
                con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
                //요청 데이터 셋팅
                //데이터 전송
                //con.setDoOutput(true);
                //데이터 받는 부분
                int responseCode = con.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    br = new BufferedReader(new InputStreamReader(con.getInputStream()));
                }else {
                    br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
                }
                msg = new String();
                while(true) {
                    String str = br.readLine();
                    if(str == null) break;
                    msg += str;
                }
                Log.i("test", "doInBackground: "+msg);
                JSONObject json = new JSONObject(msg);
                JSONArray arr;
                arr = json.getJSONArray("items");
                adapterBlog = new CustomListAdapter();
                for(int i=0;i<arr.length();i++) {
                    JSONObject temp = (JSONObject) arr.get(i);
                    result+=temp.getString("title") +
                            " " + temp.getString("link") + " " +
                            temp.getString("bloggername") + " " + temp.getString("postdate")+"\n";
                    adapterBlog.addItem(temp.getString("title"),temp.getString("link"),temp.getString("bloggername"));
                }
                Log.i("test", "doInBackground: "+result);

            }catch (UnsupportedEncodingException e) {
                throw new RuntimeException("인코딩 실패", e);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            } finally {

            }

            return result;
        }

        @Override
        protected void onPostExecute(String s) {
            blogList.setAdapter(adapterBlog);
            super.onPostExecute(s);
        }
    }
    class NewsSearch extends AsyncTask<String,String,String>{

        @Override
        protected String doInBackground(String... strings) {
            String clientId = "_1rIIr0u6hwdD4VpqYnd";//애플리케이션 클라이언트 아이디값";
            String clientSecret = "k5ERzutCdQ";//애플리케이션 클라이언트 시크릿값";
            String msg = null;
            HttpURLConnection con = null;
            BufferedReader br = null;
            String result = "";
            String text = edtSearch.getText().toString();
            try {
                text = URLEncoder.encode(text, "UTF-8");
                //해당 주소 url 연결
                URL url = new URL("https://openapi.naver.com/v1/search/news.json?query=" + text);
                con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                con.setRequestProperty("X-Naver-Client-Id", clientId);
                con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
                //요청 데이터 셋팅
                //데이터 전송
                //con.setDoOutput(true);
                //데이터 받는 부분
                int responseCode = con.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    br = new BufferedReader(new InputStreamReader(con.getInputStream()));
                }else {
                    br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
                }
                msg = new String();
                while(true) {
                    String str = br.readLine();
                    if(str == null) break;
                    msg += str;
                }
                Log.i("test", "doInBackground: "+msg);
                JSONObject json = new JSONObject(msg);
                JSONArray arr;
                arr = json.getJSONArray("items");
                adapterNews = new CustomListAdapter();
                for(int i=0;i<arr.length();i++) {
                    JSONObject temp = (JSONObject) arr.get(i);
                    result+=temp.getString("title") +
                            " " + temp.getString("link") + " " +
                            temp.getString("description") +"\n";
                    adapterNews.addItem(temp.getString("title"),temp.getString("link"),temp.getString("description"));
                }
                Log.i("test", "doInBackground: "+result);

            }catch (UnsupportedEncodingException e) {
                throw new RuntimeException("인코딩 실패", e);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            } finally {

            }

            return result;
        }

        @Override
        protected void onPostExecute(String s) {
            newList.setAdapter(adapterNews);
            super.onPostExecute(s);
        }
    }
}