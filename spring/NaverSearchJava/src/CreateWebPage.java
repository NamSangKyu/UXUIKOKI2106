import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class CreateWebPage {
	public static void main(String[] args) {
		String url = "https://search.shopping.naver.com/catalog/27327337525";
		
		try {
			URL webURL = new URL(url);
			HttpURLConnection conn = (HttpURLConnection) webURL.openConnection();
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String str = "";
			String msg;
			while((msg = br.readLine())!=null) {
				str += msg;
			}
			System.out.println(str);
			FileWriter fw = new FileWriter("test.html");
			fw.write(str);
			fw.flush();
			fw.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
