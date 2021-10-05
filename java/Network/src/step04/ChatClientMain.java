package step04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatClientMain {

	public static void main(String[] args) {
		Socket server = null;
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = null;
		
		try {
			server = new Socket("192.168.2.101",1234);
			pw = new PrintWriter(server.getOutputStream());
			MessageReceive worker = new MessageReceive(server);
			worker.start();
			
			while(true) {
				System.out.print("메세지 입력 : ");
				String msg = sc.nextLine();
				pw.println(msg);
				pw.flush();
				if(msg.equals("exit")) break;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pw != null)pw.close();
				if(server != null)server.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	public static class MessageReceive extends Thread {
		private BufferedReader br;

		public MessageReceive(Socket client) {
			try {
				br = new BufferedReader(new InputStreamReader(client.getInputStream()));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void run() {
			try {
				while (true) {
					String str = br.readLine();
					if (str == null || str.equals("exit"))
						break;
					System.out.println(str);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				try {
					if(br != null)br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
