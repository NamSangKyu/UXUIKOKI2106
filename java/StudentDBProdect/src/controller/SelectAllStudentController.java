package controller;

import java.util.ArrayList;
import java.util.Scanner;

import service.StudentService;
import vo.StudentVO;

public class SelectAllStudentController implements Controller {

	@Override
	public void excute(Scanner sc) {
		ArrayList<StudentVO> list = StudentService.getInstance().selectAllStudent();
		for(int i=0;i<list.size();i++)
			list.get(i).printStudentInfo();
	}

}
