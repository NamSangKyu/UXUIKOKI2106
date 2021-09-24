package batch;

import static org.junit.jupiter.api.Assertions.fail;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import org.json.JSONException;
import org.json.JSONObject;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;


public class SendLogJob implements Job {

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		File file = new File("log.txt");
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			
			while(true) {
				String str = br.readLine();
				if(str == null) break;
				sendLog(str.split("\t"));
			}
			System.out.println("기존 로그파일 삭제 : "+file.delete());
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(br!=null)br.close();
				if(fr!=null)fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void sendLog(String[] split) {
		//API서버에 내용을 전송
		
		try {
			String apiUrl = "http://localhost:9999/sendLog.do?date=%s&code=%s&conten=%s";
			apiUrl = String.format(apiUrl, URLEncoder.encode(split[0], "utf-8"),
					URLEncoder.encode(split[1], "utf-8"),URLEncoder.encode(split[2], "utf-8"));
			URL url = new URL(apiUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String str = "";
			String temp;
			while((temp = br.readLine())!=null)
				str+=temp;
			System.out.println(str);
			br.close();
			conn.disconnect();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

}













