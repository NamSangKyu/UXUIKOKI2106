package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ChatServerMain {
	private static ArrayList<ServerWorker> list = new ArrayList<ServerWorker>();
	public static void main(String[] args) {
		ServerSocket server = null;
		
		try {
			server = new ServerSocket(1234);
			System.out.println("채팅 서버 오픈");
			
			while(true) {
				System.out.println("클라이언트 접속 대기중.....");
				Socket client = server.accept();
				System.out.println("클라이언트 접속 - "+client.getInetAddress());
				ServerWorker sw = new ServerWorker(client);
				sw.start();
				list.add(sw);
				System.out.println("현재 접속한 클라이언트 숫자 : "+list.size());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//모든 클라이언트에게 메세지 전송
	private static void broadCasting(String msg) {
		for(int i=0;i<list.size();i++) {
			list.get(i).sendMessage(msg);
		}
	}
	public static class ServerWorker extends Thread{
		private Socket client;
		private BufferedReader br;
		private PrintWriter pw;
		
		public ServerWorker(Socket client) {
			this.client = client;
			
			try {
				br = new BufferedReader(new InputStreamReader(client.getInputStream()));
				pw = new PrintWriter(client.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		@Override
		public void run() {
			try {
				while (true) {
					String msg = br.readLine();
					if (msg == null || msg.equals("exit"))
						break;
					broadCasting(client.getInetAddress() + "님의 메세지 : "+msg );
				}
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				 list.remove(this);
				 System.out.println(client.getInetAddress() + "님이 접속을 종료하였습니다");
				 System.out.println("현재 접속한 클라이언트 숫자 : "+list.size());
			}
		}
		//클라이언트에게 메세지 전송
		public void sendMessage(String msg) {
			pw.println(msg);
			pw.flush();
		}
		
	}

}




