import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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
	public static void writeFile(String fileName, String text) {
		//text의 내용을 fileName의 있는 값으로 텍스트 파일로 출력
		//FileWriter, PrintWriter, 파일명 : fileName.html
		FileWriter fw = null;
		PrintWriter pw = null;
		try {
			fw = new FileWriter(fileName+".html");
			pw = new PrintWriter(fw);
			
			pw.println(text);
			pw.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
				try {
					if(pw!=null)pw.close();
					if(fw!=null)fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		
	}
	public static void main(String[] args) {
		String tag = readHTML();
		tag = String.format(tag, "코로나","<table><tr><th>제목</th><th>링크</th><th>블로그명</th></tr><tr><td><b>코로나</b> 방역 믿고 맡길수 있었죠</td><td>https://blog.naver.com/jjanggyo?Redirect=Log&logNo=222494087403</td><td>MENTE CREATIVA - 짱꾜</td></tr></table>");
		System.out.println(tag);
		writeFile("코로나", tag);
	}

}


