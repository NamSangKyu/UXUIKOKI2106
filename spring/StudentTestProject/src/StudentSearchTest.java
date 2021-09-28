import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

class StudentSearchTest {

	@Test
	void searchTest() {
		try {
			String search = URLEncoder.encode("수", "utf-8");
			String apiURL = "http://localhost:9999/search.do?kind=name&search="+search;
			URL url = new URL(apiURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String result = "";
			String temp;
			
			while((temp = br.readLine())!=null)
				result += temp;
			
			JSONObject object = new JSONObject(result);
			
			if(object.getInt("code") == 500) {
				fail("검색 결과 없음");
			}else {
				JSONArray arr = object.getJSONArray("result");					
				for(int i=0;i<arr.length();i++) {
					JSONObject obj = arr.getJSONObject(i);
					System.out.println(obj.getString("sno") + " " +obj.getString("name") +
							obj.getString("major") + " " + obj.getDouble("score"));
				}
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

}
