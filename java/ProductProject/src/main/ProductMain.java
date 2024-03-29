package main;

import java.util.Scanner;

import service.ProductService;

public class ProductMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ProductService service = ProductService.getInstance();
		while(true) {
			System.out.println("----제품관리 프로그램----");
			System.out.println("1. 제품정보 등록");
			System.out.println("2. 제품정보 제조사 검색");
			System.out.println("3. 제품정보 수정");
			System.out.println("4. 전체 제품정보 출력");
			System.out.println("0. 프로그램 종료");
			System.out.print("원하시는 메뉴 번호를 입력하세요 : ");
			int no = sc.nextInt();
			sc.nextLine();//엔터를 메모리에서 비움
			if(no == 0) break;
			
			switch(no) {
			case 1:
				service.insertProduct(sc);
				break;
			case 2:
				service.selectSearchProduct(sc);
				break;
			case 3:
				service.updateProduct(sc);
				break;
			case 4:
				service.selectAllProduct();
				break;
			}
			
			
		}		
	}

}
