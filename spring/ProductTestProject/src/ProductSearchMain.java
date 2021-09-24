import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class ProductSearchMain {

	public static void main(String[] args) {
		//API 서버 호출
		Scanner sc = new Scanner(System.in);
		String search = null;
		
		System.out.print("검색어 입력 : ");
		search = sc.nextLine();
		
		//HTTP로 데이터 요청
		//데이터를 요청할 API 서버 주소를 문자열로 선언 - 검색어 인코딩 작업
		try {
			search = URLEncoder.encode(search,"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String apiUrl = "http://localhost:9999/search.do?search="+search;
		try {
			//open connection
			URL url = new URL(apiUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			//Reader로 데이터 받음 
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String str = "";
			String temp;
			while((temp = br.readLine())!=null)
				str+=temp;
			JSONObject obj = new JSONObject(str);
			System.out.println(obj.get("code"));
			if(obj.getInt("code")==500) throw new Exception(obj.getString("responseMessage"));
			JSONArray arr = obj.getJSONArray("responseMessage");
			for(int i=0;i<arr.length();i++) {
				JSONObject o = arr.getJSONObject(i);
				System.out.println(String.format("%s %s %s %d", 
						o.getString("pno"),o.getString("pname"),o.getString("maker")
						,o.getInt("price")
						));
			}
			br.close();
			conn.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (Exception e) {
			//받은 결과 코드가 500일때 텍스파일에 로그 기록
			//기록 형식 년_월_일_시_분_초\t에러메세지,  파일명 log.txt
			//단 파일 기록시 기존 내용은 유지가 되어야 됨
			System.out.println(e.getMessage());
		}
	}

}











