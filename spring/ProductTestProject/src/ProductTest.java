import static org.junit.jupiter.api.Assertions.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

class ProductTest {

	@Test
	void test() {
		String search = "수";

		try {
			search = URLEncoder.encode(search,"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String apiUrl = "http://localhost:9999/search.do?search="+search;
		try {
			URL url = new URL(apiUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String str = "";
			String temp;
			while((temp = br.readLine())!=null)
				str+=temp;
			System.out.println(str);
			JSONObject obj = new JSONObject(str);
			System.out.println(obj.get("code"));
			if(obj.getInt("code")==500) {
				fail("검색 결과 없음");
			}
			br.close();
			conn.disconnect();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

}
