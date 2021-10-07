package com.example.papago;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edtText;
    EditText edtResult;
    Button btnTranslate;
    Button btnVoice;
    Spinner spinner;
    PaPaGo papago;

    InputMethodManager imm;

    private static final String TAG = "PAPAGO";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtText = findViewById(R.id.edt_text);
        edtResult = findViewById(R.id.edt_traslate);
        btnTranslate = findViewById(R.id.btn_translate);
        btnVoice = findViewById(R.id.btn_voice_translate);
        spinner = findViewById(R.id.spn_lang_code);
        String arr[] = {"ja","zh-CN","fr","en"};
        imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

        btnVoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                        RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                startActivityForResult(intent, 2000);
            }
        });

        btnTranslate.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,spinner.getSelectedItemId()+"",Toast.LENGTH_SHORT).show();
                papago = new PaPaGo();
                String str = arr[(int) spinner.getSelectedItemId()];
                papago.execute(str);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK && requestCode == 2000){
            ArrayList<String> list = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            edtText.setText(list.get(0));
            for(int i=0;i<list.size();i++)
                Log.i(TAG, "onActivityResult: "+list.get(i));
        }else{
            edtText.setText("음성인식에 실패 하였습니다");
        }

    }

    public class PaPaGo extends AsyncTask<String, String, String>{

        @Override
        protected String doInBackground(String... strings) {
            //파파고 서버 호출
            String clientId = "_1rIIr0u6hwdD4VpqYnd";//애플리케이션 클라이언트 아이디값";
            String clientSecret = "k5ERzutCdQ";//애플리케이션 클라이언트 시크릿값";
            String msg = null;
            HttpURLConnection con = null;
            DataOutputStream dos = null;
            BufferedReader br = null;
            String text = edtText.getText().toString();
            try {
                text = URLEncoder.encode(text, "UTF-8");
                //해당 주소 url 연결
                URL url = new URL("https://openapi.naver.com/v1/papago/n2mt");
                con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("POST");
                con.setRequestProperty("X-Naver-Client-Id", clientId);
                con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
                //요청 데이터 셋팅
                String postParams = "source=ko&target="+strings[0]+"&text=" + text;
                //데이터 전송
                con.setDoOutput(true);
                dos = new DataOutputStream(con.getOutputStream());
                dos.writeBytes(postParams);
                dos.flush();
                dos.close();
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
                Log.i(TAG, "onClick: "+msg);
                System.out.println(msg);
                JSONObject json = new JSONObject(msg);
                msg = json.getJSONObject("message").getJSONObject("result").getString("translatedText");

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
            return msg;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            //UI처리
            edtResult.setText(s);
        }
    }
}