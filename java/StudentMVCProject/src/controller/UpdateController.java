package controller;

import java.util.Scanner;

import service.StudentService;
import vo.StudentVO;

public class UpdateController implements Controller {

	@Override
	public void excute(Scanner sc) {
		System.out.println("학생정보 수정을 시작합니다.......");
		System.out.print("수정학 학생번호를 입력하세요 : ");
		String no = sc.nextLine();
		StudentVO vo = StudentService.getInstance().searchStudent(no);
		if (vo == null) {
			System.out.println("수정할 학생 정보가 없습니다.");
			return;
		}
		System.out.print("수정할 이름 : ");
		String name = sc.nextLine();
		System.out.print("수정할 학과 : ");
		String major = sc.nextLine();
		System.out.print("수정할 평점 : ");
		double score = sc.nextDouble();
		sc.nextLine();
		//데이터 수정
		vo.setName(name);
		vo.setMajor(major);
		vo.setScore(score);
		System.out.println("데이터 수정이 완료되었습니다.");

	}

}


