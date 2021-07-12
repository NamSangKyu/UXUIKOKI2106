package controller;

import java.util.ArrayList;
import java.util.Scanner;

import service.StudentService;
import vo.SubjectVO;

public class SelectAllSubjectController implements Controller {

	@Override
	public void excute(Scanner sc) {
		ArrayList<SubjectVO> list = StudentService.getInstance().selectAllLecture();
		System.out.println("수강 신청 가능한 강의 목록......");
		System.out.printf("  %s %s %s %s\n","과목번호", "과목명", "담당교수", "남은인원");
		for(int i=0;i<list.size();i++) {
			list.get(i).printInfo();
		}

	}

}
