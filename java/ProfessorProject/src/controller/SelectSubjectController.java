package controller;

import java.util.ArrayList;
import java.util.Scanner;

import service.ProfessorService;

public class SelectSubjectController implements Controller {

	@Override
	public void excute(Scanner sc) {
		System.out.print("과목명 일부를 입력 하세요 : ");
		String subject = sc.nextLine();
		
		ArrayList<String> list;
		try {
			list = ProfessorService.getInstance().selectSubject(subject);
			
			for(int i=0;i<list.size();i++)
				System.out.println(list.get(i));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}









