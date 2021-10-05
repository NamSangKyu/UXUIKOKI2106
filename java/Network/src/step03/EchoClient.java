package step03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {

	public static void main(String[] args) {
		Socket server = null;
		BufferedReader br = null;
		PrintWriter pw = null;
		Scanner sc = new Scanner(System.in);
		try {
			server = new Socket("127.0.0.1", 1234);
			
			br = new BufferedReader(new InputStreamReader(server.getInputStream()));
			pw = new PrintWriter(server.getOutputStream());
			
			while(true) {
				System.out.print("메세지 입력 : ");
				String msg  = sc.nextLine();
				pw.println(msg);
				pw.flush();
				if(msg == null || msg.equals("exit"))break;
				msg = br.readLine();
				System.out.println(msg);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if (br != null)
					br.close();
				if (pw != null)
					pw.close();
				if (server != null)
					server.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
