package controller;

import java.util.ArrayList;
import java.util.Scanner;

import service.ProfessorService;
import session.LoginSession;

public class RegisterSubjectListController implements Controller {

	@Override
	public void excute(Scanner sc) {
		String pno = LoginSession.getInstance().getPno();
		ArrayList<String> list = 
				ProfessorService.getInstance().selectRegisterSubjectList(pno);
		if(list.size() == 0) {
			System.out.println("등록된 강의가 없습니다.");
			return;
		}
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
	}

}








