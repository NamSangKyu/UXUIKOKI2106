package controller;

import java.util.ArrayList;
import java.util.Scanner;

import exception.StudentException;
import service.StudentService;
import session.LoginSession;
import vo.SubjectVO;

public class RegisterLectureController implements Controller {

	@Override
	public void excute(Scanner sc) {
		//수강 가능한 전체 과목 리스트를 조회
		ArrayList<SubjectVO> list = StudentService.getInstance().selectAllLecture();
		for(int i = 0;i < list.size();i++)
			list.get(i).printInfo();
		//과목번호 입력을 받고 실행
		System.out.print("신청할 과목번호 입력 : ");
		String subjectNo = sc.nextLine();
		try {
			StudentService.getInstance().registerLecture(subjectNo,
					LoginSession.getInstance().getSno());
			System.out.println("수강 등록 완료");
		} catch (StudentException e) {
			System.out.println(e.getMessage());
		}

	}

}







