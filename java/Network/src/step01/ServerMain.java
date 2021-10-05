package step01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {

	public static void main(String[] args) {
		try {
			//1. 서버 오픈
			ServerSocket server = new ServerSocket(1234);
			//2. 클라이언트 접속을 받음
			Socket client = server.accept();
			System.out.println("클라이언트 접속 , " + client.getInetAddress());
			//3. Stream 초기화
			BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
			PrintWriter pw = new PrintWriter(client.getOutputStream());
			
			//4. 클라이언트가 전송한 데이터 받음
			String msg = br.readLine();
			System.out.println("클라이언트로부터 받은 메세지 : "+msg);
			//5. 클라이언트로 데이터 전송
			pw.println("서버가 보낸 메세지");
			pw.flush();
			
			//6. 닫기
			br.close();
			pw.close();
			server.close();
			
			System.out.println("서버 종료");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}








