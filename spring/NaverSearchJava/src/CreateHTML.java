import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CreateHTML {
	public static String readHTML() {
		String result = "";
		//파일 읽기 처리
		//template.html 파일 내용을 전부 result에 저장
		//FileReader, BufferedReader
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader("template.html");
			br = new BufferedReader(fr);
			String temp;
			while((temp = br.readLine()) != null) {
				result += temp;
			}
			System.out.println(result);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
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
		return result;
	}
	public static void main(String[] args) {
		String tag = readHTML();
		tag = String.format(tag, "코로나","<table><tr><td>제목</td><td>링크</td><td>블로그명</td></tr><tr><td><b>코로나</b> 방역 믿고 맡길수 있었죠</td><td>https://blog.naver.com/jjanggyo?Redirect=Log&logNo=222494087403</td><td>MENTE CREATIVA - 짱꾜</td></tr></table>");
		System.out.println(tag);
	}

}


