package step03;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MultiEchoServer {
	public static ArrayList<ServerWorker> list = new ArrayList<ServerWorker>();
	public static void main(String[] args) {
		ServerSocket server = null;
		try {
			server = new ServerSocket(1234);
			System.out.println("서버 오픈");
			while(true) {
				Socket client = server.accept();
				System.out.println("클라이언트 접속 - " + client.getInetAddress());
				ServerWorker worker = new ServerWorker(client);
				worker.start();
				list.add(worker);
				System.out.println("현재 접속 중인 클라이언트 개수 : "+list.size());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}







