package service;

import java.util.Scanner;

import vo.StudentVO;

public class StudentService {
	private StudentVO[] arr;
	private int index;

	public StudentService() {
		arr = new StudentVO[10];
		index = 0; //데이터가 등록될 배열 인덱스 번호
	}
	//학생 데이터 등록
	//	학생데이터 입력 받아서 배열에 등록
	public void insertStudent(Scanner sc) {
		System.out.println("학생정보 등록을 시작합니다..........");
		if(index == arr.length) {
			System.out.println("더 이상 저장할 공간이 없습니다.");
			return;
		}
		//학생데이터 입력
		System.out.print("학번 입력 : ");
		String studentNo = sc.nextLine();
		System.out.print("이름 입력 : ");
		String name = sc.nextLine();
		System.out.print("학과 입력 : ");
		String major = sc.nextLine();
		System.out.print("평점 입력 : ");
		double score = sc.nextDouble();
		sc.nextLine();
		//Student 객체 생성
		//배열에 저장
		arr[index] = new StudentVO(studentNo, name, major, score);
		//index 증가
		index++;
	}
	//학생 데이터 검색
	//학생 데이터 삭제
	//학생 데이터 수정
	//전체 학생 데이터 출력
	
	

}










