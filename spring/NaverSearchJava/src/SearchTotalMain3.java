import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SearchTotalMain3 {
	// 블로그 검색
	public static String searchShop(String text) {
		String clientId = "_1rIIr0u6hwdD4VpqYnd";// 애플리케이션 클라이언트 아이디값";
		String clientSecret = "k5ERzutCdQ";// 애플리케이션 클라이언트 시크릿값";
		String msg = null;
		HttpURLConnection con = null;
		BufferedReader br = null;
		String result = "";
		try {
			text = URLEncoder.encode(text, "UTF-8");
			// 해당 주소 url 연결
			URL url = new URL("https://openapi.naver.com/v1/search/shop.json?display=10&query=" + text);
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("X-Naver-Client-Id", clientId);
			con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
			// 요청 데이터 셋팅
			// 데이터 전송
			con.setDoOutput(true);
			// 데이터 받는 부분
			int responseCode = con.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) {
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			msg = new String();
			while (true) {
				String str = br.readLine();
				if (str == null)
					break;
				msg += str;
			}
			// System.out.println(msg);
			JSONObject json = new JSONObject(msg);
			JSONArray arr = json.getJSONArray("items");
			System.out.println(arr);
			text = URLDecoder.decode(text);
		
			System.setProperty("webdriver.chrome.driver","chromedriver.exe");
			for (int i = 0; i < arr.length(); i++) {
				JSONObject temp = (JSONObject) arr.get(i);
				System.out.println(temp.getString("link"));
//				System.out.println("\t"+GetHTML(temp.getString("link")));
				testSelenium(temp.getString("link"));
				
			}
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("인코딩 실패", e);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(br != null)br.close();
				if(con != null)con.disconnect();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return result;
	}
	public static void testSelenium(String url) {
        //Driver SetUp
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
        ChromeDriver driver = new ChromeDriver(options);
        
        driver.get(url);
        System.out.println(driver.getPageSource());
		
	}
	public static String GetHTML(String url) {
		
		String str = "";
		try {
			URL webURL = new URL(url);
			HttpURLConnection conn = (HttpURLConnection) webURL.openConnection();
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String msg;
			while((msg = br.readLine())!=null) {
				str += msg;
			}
			System.out.println(str);
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;
	}
	


	public static void main(String[] args) {
		//검색어 입력
		Scanner sc = new Scanner(System.in);
		String str;
		System.out.print("검색어 입력 : ");
		str = sc.nextLine();
		String result = searchShop(str);
		System.out.println(result);

	}

}
