import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class SearchTotalMain {
	// 블로그 검색
	public static String searchBlog(String text) {
		String clientId = "_1rIIr0u6hwdD4VpqYnd";// 애플리케이션 클라이언트 아이디값";
		String clientSecret = "k5ERzutCdQ";// 애플리케이션 클라이언트 시크릿값";
		String msg = null;
		HttpURLConnection con = null;
		BufferedReader br = null;
		String result = "";
		try {
			text = URLEncoder.encode(text, "UTF-8");
			// 해당 주소 url 연결
			URL url = new URL("https://openapi.naver.com/v1/search/blog.json?query=" + text);
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
			text = URLDecoder.decode(text);
			result = "<h2>"+text+" 블로그 검색 결과</h2><table>";
			result += "<tr><th>제목</th><th>링크</th><th>요약내용</th><th>블로그명</th></tr>";
			for (int i = 0; i < arr.length(); i++) {
				JSONObject temp = (JSONObject) arr.get(i);
				result += String.format("<tr><td>%s</td><td><a href='%s' target='_blank'>%s</a>"
						+ "</td><td>%s</td><td>%s</td></tr>", 
						temp.getString("title"),temp.getString("link"),
						temp.getString("link"),temp.getString("description"),
						temp.getString("bloggername"));
			}
			result += "</table>";
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

	// 뉴스 검색
	public static String searchNews(String text) {
		String clientId = "_1rIIr0u6hwdD4VpqYnd";// 애플리케이션 클라이언트 아이디값";
		String clientSecret = "k5ERzutCdQ";// 애플리케이션 클라이언트 시크릿값";
		String msg = null;
		HttpURLConnection con = null;
		BufferedReader br = null;
		String result = "";
		try {
			text = URLEncoder.encode(text, "UTF-8");
			// 해당 주소 url 연결
			URL url = new URL("https://openapi.naver.com/v1/search/news.json?query=" + text);
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
			text = URLDecoder.decode(text);
			result = "<h2>"+text+" 뉴스 검색 결과</h2><table>";
			result += "<tr><th>제목</th><th>링크</th><th>요약내용</th><th>올라온시간</th></tr>";
			for (int i = 0; i < arr.length(); i++) {
				JSONObject temp = (JSONObject) arr.get(i);
				result += String.format("<tr><td>%s</td><td><a href='%s' target='_blank'>%s</a>"
						+ "</td><td>%s</td><td>%s</td></tr>", 
						temp.getString("title"),temp.getString("link"),
						temp.getString("link"),temp.getString("description"),
						temp.getString("pubDate"));
			}
			result += "</table>";
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("인코딩 실패", e);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

		}

		return result;
	}

	// 책 검색
	public static String searchBook(String text) {
		String clientId = "_1rIIr0u6hwdD4VpqYnd";// 애플리케이션 클라이언트 아이디값";
		String clientSecret = "k5ERzutCdQ";// 애플리케이션 클라이언트 시크릿값";
		String msg = null;
		HttpURLConnection con = null;
		BufferedReader br = null;
		String result = "";
		try {
			text = URLEncoder.encode(text, "UTF-8");
			// 해당 주소 url 연결
			URL url = new URL("https://openapi.naver.com/v1/search/book.json?query=" + text);
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
			text = URLDecoder.decode(text);
			result = "<h2>"+text+" 관련 서적 검색 결과</h2><table>";
			result += "<tr><th>도서명</th><th>링크</th><th>요약내용</th><th>저자</th><th>출판사</th><th>출간일</th></tr>";
			for (int i = 0; i < arr.length(); i++) {
				JSONObject temp = (JSONObject) arr.get(i);
				result += String.format("<tr><td>%s</td><td><a href='%s' target='_blank'>%s</a>"
						+ "</td><td>%s</td><td>%s</td></tr>", 
						temp.getString("title"),temp.getString("link"),
						temp.getString("link"),temp.getString("description"),
						temp.getString("author"),temp.getString("publisher"),temp.getString("pubdate"));
			}
			result += "</table>";
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("인코딩 실패", e);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

		}

		return result;
	}

	public static String readHTML() {
		String result = "";
		// 파일 읽기 처리
		// template.html 파일 내용을 전부 result에 저장
		// FileReader, BufferedReader
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader("template.html");
			br = new BufferedReader(fr);
			String temp;
			while ((temp = br.readLine()) != null) {
				result += temp;
			}
			System.out.println(result);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
				if (fr != null)
					fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public static void writeFile(String fileName, String text) {
		// text의 내용을 fileName의 있는 값으로 텍스트 파일로 출력
		// FileWriter, PrintWriter, 파일명 : fileName.html
		FileWriter fw = null;
		PrintWriter pw = null;
		try {
			fw = new FileWriter(fileName + ".html");
			pw = new PrintWriter(fw);

			pw.println(text);
			pw.flush();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pw != null)
					pw.close();
				if (fw != null)
					fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {
		//검색어 입력
		Scanner sc = new Scanner(System.in);
		String str;
		System.out.print("검색어 입력 : ");
		str = sc.nextLine();
		String result = searchBlog(str);
		result += searchNews(str);
		result += searchBook(str);
		System.out.println(result);
		String tag = String.format(readHTML(), str,result);
		writeFile(str, tag);
	}

}
