package controller;

import java.util.ArrayList;
import java.util.Scanner;

import exception.StudentException;
import service.StudentService;
import session.LoginSession;
import vo.SubjectVO;

public class SelectLectureController implements Controller {

	@Override
	public void excute(Scanner sc) {
		try {
			ArrayList<SubjectVO> list = 
					StudentService.getInstance().
					selectLecture(LoginSession.getInstance().getSno());
			for(int i=0;i<list.size();i++)
				list.get(i).printInfo();
		} catch (StudentException e) {
			System.out.println(e.getMessage());
		}

	}

}











