package step01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientMain {

	public static void main(String[] args) {
		try {
			//1. 서버 접속
			Socket server = new Socket("127.0.0.1",1234);
			//2. 스트림 초기화
			BufferedReader br = new BufferedReader(new InputStreamReader(server.getInputStream()));
			PrintWriter pw = new PrintWriter(server.getOutputStream());
			//3. 데이터 전송
			pw.println("안녕하세요");
			pw.flush();
			//4. 데이터 받음
			String msg = br.readLine();
			System.out.println(msg);
			//5. 닫기
			br.close();
			pw.close();
			server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}


