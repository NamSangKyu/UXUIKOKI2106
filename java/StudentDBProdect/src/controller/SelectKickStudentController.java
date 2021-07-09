package controller;

import java.util.ArrayList;
import java.util.Scanner;

import service.StudentService;
import vo.StudentVO;

public class SelectKickStudentController implements Controller {

	@Override
	public void excute(Scanner sc) {
		ArrayList<StudentVO> list = StudentService.getInstance().selectKickStudent();
		System.out.println("----제적 대상자 목록----");
		for(int i=0;i<list.size();i++) {
			list.get(i).printStudentInfo();
		}
	}

}
