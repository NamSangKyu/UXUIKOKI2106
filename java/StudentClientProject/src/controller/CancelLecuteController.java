package controller;

import java.util.ArrayList;
import java.util.Scanner;

import exception.StudentException;
import service.StudentService;
import session.LoginSession;
import vo.SubjectVO;

public class CancelLecuteController implements Controller {

	@Override
	public void excute(Scanner sc) {
		try {
			ArrayList<SubjectVO> list = StudentService.getInstance().
					selectLecture(LoginSession.getInstance().getSno());
			for(int i=0;i<list.size();i++)
				list.get(i).toString();
			System.out.print("취소할 수강번호 입력 : ");
			String sno = sc.nextLine();
			StudentService.getInstance().cancelLecture(sno);//삭제할 수강번호 - sno
			System.out.println("수강 취소 완료");
		} catch (StudentException e) {
			System.out.println(e.getMessage());
		}
	}

}












