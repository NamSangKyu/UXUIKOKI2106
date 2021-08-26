package step01;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileWriteMain {

	public static void main(String[] args) {
		FileWriter fw = null;
		PrintWriter pw = null;
		try {
			// 1. 노드 스트림 연결
			fw = new FileWriter("writer.txt", true);//true 추가 모드
			// 2. 프로세스 스트림 연결
			pw = new PrintWriter(fw);
			// 3. 입출력 처리
			// 출력 -> 버퍼에 전송
//			fw.write("안녕하세요\n");
//			fw.write("오늘은 목요일 입니다.");
//			fw.flush();// 실제 데이터를 전송
			pw.println("프로세스 스트림으로 출력");
			pw.println("프로세스 스트림으로 출력");
			pw.println("프로세스 스트림으로 출력");
			pw.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//4. close
			try {
				if (fw != null)
					fw.close();
				if(pw != null)
					pw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
