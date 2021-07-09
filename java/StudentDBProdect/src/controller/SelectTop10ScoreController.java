package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

import service.StudentService;
import vo.StudentVO;

public class SelectTop10ScoreController implements Controller {

	@Override
	public void excute(Scanner sc) {
		HashMap<Integer, ArrayList<StudentVO>> map = 
				StudentService.getInstance().selectTop10Score();
		
		Iterator<Integer> it = map.keySet().iterator();
		while(it.hasNext()) {
			int rank = it.next();
			ArrayList<StudentVO> list = map.get(rank);
			System.out.println(rank + "등");
			for(int i=0;i<list.size();i++)
				list.get(i).printStudentInfo();
		}
	}

}











