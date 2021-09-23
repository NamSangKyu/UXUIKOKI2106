package test;

import java.util.Scanner;

public class ThreadTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str;
		
		System.out.print("검색어 입력하세요 > ");
		str = sc.nextLine();
		SearchWorker s1 = new SearchWorker(str);
		s1.start();
		System.out.print("검색어 입력하세요 > ");
		str = sc.nextLine();
		SearchWorker s2 = new SearchWorker(str);
		s2.start();
		System.out.print("검색어 입력하세요 > ");
		str = sc.nextLine();
		SearchWorker s3 = new SearchWorker(str);
		s3.start();
		System.out.print("검색어 입력하세요 > ");
		str = sc.nextLine();
		SearchWorker s4 = new SearchWorker(str);
		s4.start();
	}

}
