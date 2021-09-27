import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class WeatherEx {

	public static void main(String[] args) {
		String nx, ny, baseTime, serviceKey, dataType, baseDate, numOfRows, url;
		//위치값 셋팅
		nx = "60";
		ny = "127";
		url = "http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtNcst";
		serviceKey = "hpOVfNem4MVro1QdBZTMTq%2FMZs%2B8yylSvxNQlqPiEQec%2Bo99WRRbIvrVqLltto5W0TmluoxR7uQHpHFNZ146qg%3D%3D";
		dataType = "json";
		numOfRows = "10";
		baseDate = "20210927";
		baseTime = "0800";
		
		String apiUrl = url + "?serviceKey="+serviceKey;
		apiUrl += "&base_date="+baseDate;
		apiUrl += "&base_time="+baseTime;
		apiUrl += "&dataType="+dataType;
		apiUrl += "&nx="+nx;
		apiUrl += "&ny="+ny;
		apiUrl += "&numOfRows="+numOfRows;
		System.out.println(apiUrl);
		
		//URL 호출해서 받은 내용 전체 출력
		try {
			URL u = new URL(apiUrl);
			HttpURLConnection connection = (HttpURLConnection) u.openConnection();
			connection.setRequestMethod("GET");
			String result = "";
			
			BufferedReader br = new BufferedReader(
					new InputStreamReader(connection.getInputStream()));
			String temp;
			while((temp = br.readLine())!=null) {
				result += temp;
			}
			System.out.println(result);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}








