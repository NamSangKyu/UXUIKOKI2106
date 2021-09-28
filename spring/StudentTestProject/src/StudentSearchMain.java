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

public class StudentSearchMain {

	public static void main(String[] args) {
		String search = null;
		String kind = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("검색할 종류를 선택하세요");
		System.out.println("학번 - sno");
		System.out.println("이름 - name");
		System.out.println("명령어를 입력하세요 > ");
		kind = sc.nextLine();
		System.out.println("검색할 단어 일부분을 입력하세요 > ");
		search = sc.nextLine();
		
		try {
			search = URLEncoder.encode(search, "utf-8");
			String apiURL = "http://localhost:9999/search.do?kind="+kind+"&search="+search;
			URL url = new URL(apiURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String result = "";
			String temp;
			
			while((temp = br.readLine())!=null)
				result += temp;
			
			JSONObject object = new JSONObject(result);
			
			if(object.getInt("code") == 500) {
				throw new Exception(object.getInt("code") + "\t" + object.getString("message"));
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
		} catch (Exception e) {
			try {
				FileWriter fw = new FileWriter("error.txt",true);
				PrintWriter pw = new PrintWriter(fw);
				SimpleDateFormat sdf  = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
				pw.println(sdf.format(Calendar.getInstance().getTime())+ "\t" +e.getMessage());
				pw.flush();
				pw.close();
				fw.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
		}
	}

}
