package service;

import java.util.ArrayList;
import java.util.Scanner;

import vo.ProductVO;

public class ProductService {
	private ArrayList<ProductVO> list;
	private static ProductService instance = new ProductService();
	
	private ProductService() {
		list = new ArrayList<ProductVO>();
	}

	public static ProductService getInstance() {
		if(instance == null)
			instance = new ProductService();
		return instance;
	}
	
	//제품 등록
	public void insertProduct(Scanner sc) {
		System.out.println("제품정보 등록을 시작합니다..........");

		//제품데이터 입력
		System.out.print("제품번호 입력 : ");
		String no = sc.nextLine();
		System.out.print("제품명 입력 : ");
		String name = sc.nextLine();
		System.out.print("제조사 입력 : ");
		String maker = sc.nextLine();
		System.out.print("창고위치 입력 : ");
		String storage = sc.nextLine();
		
		System.out.print("재고 입력 : ");
		int ea = sc.nextInt();
		sc.nextLine();
		list.add(new ProductVO(no, name, maker, ea, storage));
		System.err.println("학생 정보 등록 성공");
	}
	//전체조회
	public void selectAllProduct() {
		System.out.println("전체 제품정보 조회를 시작합니다..........");
		for(int i=0;i<list.size();i++) {
			list.get(i).printProductInfo();
		}
	}
	//제조사로 제품 조회
	public void selectSearchProduct(Scanner sc) {
		System.out.println("제조사별 제품정보 조회를 시작합니다..........");
		System.out.print("검색할 제조사 입력 : ");
		String maker = sc.nextLine();
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getMaker().equals(maker))
				list.get(i).printProductInfo();
		}
	}
	//제품 수정
	public void updateProduct(Scanner sc) {
		System.out.println("제품정보 수정을 시작합니다..........");
		System.out.print("수정할 제품번호 입력 : ");
		String no = sc.nextLine();
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getNo().equals(no)) {
				System.out.print("제품명 입력 : ");
				String name = sc.nextLine();
				System.out.print("제조사 입력 : ");
				String maker = sc.nextLine();
				System.out.print("창고위치 입력 : ");
				String storage = sc.nextLine();
				
				System.out.print("재고 입력 : ");
				int ea = sc.nextInt();
				sc.nextLine();
				
				list.set(i, new ProductVO(no, name, maker, ea, storage));
				System.out.println("제품 수정 완료");
				return;
			}
		}
		System.out.println("제품 수정 실패 해당 제품이 없습니다.");
	}
}
