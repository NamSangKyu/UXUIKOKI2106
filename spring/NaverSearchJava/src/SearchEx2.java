import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import org.json.JSONArray;
import org.json.JSONObject;

public class SearchEx2 {
	//블로그 검색
	public static String searchBloag(String text) {
		String clientId = "_1rIIr0u6hwdD4VpqYnd";//애플리케이션 클라이언트 아이디값";
		String clientSecret = "k5ERzutCdQ";//애플리케이션 클라이언트 시크릿값";
		String msg = null;
		HttpURLConnection con = null;
		BufferedReader br = null;
		String result = "";
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
	        con.setDoOutput(true);
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
	        //System.out.println(msg);
	        JSONObject json = new JSONObject(msg);
	        JSONArray arr = json.getJSONArray("items");
	        for(int i=0;i<arr.length();i++) {
	        	JSONObject temp = (JSONObject) arr.get(i);
	        	result+=temp.getString("title") + 
	        			" " + temp.getString("link") + " " + 
	        			temp.getString("bloggername") + " " + temp.getString("postdate")+"\n";
	        }
		}catch (UnsupportedEncodingException e) {
			throw new RuntimeException("인코딩 실패", e);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			
		}
		
		return result;
	}
	//뉴스 검색
	public static String searchNews(String text) {
		String clientId = "_1rIIr0u6hwdD4VpqYnd";//애플리케이션 클라이언트 아이디값";
		String clientSecret = "k5ERzutCdQ";//애플리케이션 클라이언트 시크릿값";
		String msg = null;
		HttpURLConnection con = null;
		BufferedReader br = null;
		String result = "";
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
	        con.setDoOutput(true);
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
	        //System.out.println(msg);
	        JSONObject json = new JSONObject(msg);
	        JSONArray arr = json.getJSONArray("items");
	        for(int i=0;i<arr.length();i++) {
	        	JSONObject temp = (JSONObject) arr.get(i);
	        	result+=temp.getString("title") + 
	        			" " + temp.getString("link") + " " + 
	        			temp.getString("originallink") + " " + temp.getString("pubDate")+"\n";
	        }
		}catch (UnsupportedEncodingException e) {
			throw new RuntimeException("인코딩 실패", e);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			
		}
		
		return result;
	}
	//책 검색
	public static String searchBook(String text) {
		String clientId = "_1rIIr0u6hwdD4VpqYnd";//애플리케이션 클라이언트 아이디값";
		String clientSecret = "k5ERzutCdQ";//애플리케이션 클라이언트 시크릿값";
		String msg = null;
		HttpURLConnection con = null;
		BufferedReader br = null;
		String result = "";
		try {
			text = URLEncoder.encode(text, "UTF-8");
			//해당 주소 url 연결
			URL url = new URL("https://openapi.naver.com/v1/search/book.json?query=" + text);
	        con = (HttpURLConnection) url.openConnection();
	        con.setRequestMethod("GET");
	        con.setRequestProperty("X-Naver-Client-Id", clientId);
	        con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
	        //요청 데이터 셋팅
	        //데이터 전송
	        con.setDoOutput(true);
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
	        //System.out.println(msg);
	        JSONObject json = new JSONObject(msg);
	        JSONArray arr = json.getJSONArray("items");
	        for(int i=0;i<arr.length();i++) {
	        	JSONObject temp = (JSONObject) arr.get(i);
	        	result+=temp.getString("title") + 
	        			" " + temp.getString("link") + " " + 
	        			temp.getString("image") + " " + temp.getString("description")+"\n";
	        }
		}catch (UnsupportedEncodingException e) {
			throw new RuntimeException("인코딩 실패", e);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		String result = searchBloag("코로나");
		System.out.println(result);
		result = searchNews("코로나");
		System.out.println(result);
		result = searchBook("코로나");
		System.out.println(result);
	}

}
