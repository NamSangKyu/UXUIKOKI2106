package papago;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	@RequestMapping("/")
	public String main() {
		return "papago_main";
	}
	@RequestMapping("translate.do")
	public String translate(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String target = request.getParameter("target");
		String source= request.getParameter("source");
		String text = request.getParameter("text");
		System.out.println(source + " "+target + " " + text);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(papagoTranslate(target, source, text));
		return null;		
	}
	
	public String papagoTranslate(String target,String source, String text) {
		String clientId = "_1rIIr0u6hwdD4VpqYnd";//애플리케이션 클라이언트 아이디값";
		String clientSecret = "k5ERzutCdQ";//애플리케이션 클라이언트 시크릿값";
		String msg = null;
		HttpURLConnection con = null;
		DataOutputStream dos = null;
		BufferedReader br = null;
		try {
			text = URLEncoder.encode(text, "UTF-8");
			//해당 주소 url 연결
			URL url = new URL("https://openapi.naver.com/v1/papago/n2mt");
	        con = (HttpURLConnection) url.openConnection();
	        con.setRequestMethod("POST");
	        con.setRequestProperty("X-Naver-Client-Id", clientId);
	        con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
	        //요청 데이터 셋팅
	        String postParams = "source="+source+"&target="+target+"&text=" + text;
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
	        System.out.println(msg);
	        JSONObject json = new JSONObject(msg);
	        msg = json.getJSONObject("message").getJSONObject("result").getString("translatedText");
		}catch (UnsupportedEncodingException e) {
			throw new RuntimeException("인코딩 실패", e);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			
		}
		
		return msg;
	}
}










