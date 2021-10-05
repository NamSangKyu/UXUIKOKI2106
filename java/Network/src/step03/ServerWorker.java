package step03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerWorker extends Thread {
	private Socket client;
	private PrintWriter pw;
	private BufferedReader br;

	public ServerWorker(Socket client) {
		super();
		this.client = client;

		try {
			pw = new PrintWriter(client.getOutputStream());
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
				if(str == null || str.equals("exit")) break;
				pw.println(str);
				pw.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pw != null)pw.close();
				if(br != null)br.close();
				if(client != null)client.close();
				MultiEchoServer.list.remove(this);//접속자 목록에서 제거
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}




