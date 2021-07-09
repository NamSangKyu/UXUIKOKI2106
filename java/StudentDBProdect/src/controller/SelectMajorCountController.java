package controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

import service.StudentService;

public class SelectMajorCountController implements Controller {

	@Override
	public void excute(Scanner sc) {
		HashMap<String, Integer> map = StudentService.getInstance().selectMajorCount();
		
		System.out.println("학과별 인원수 현황....");
		Iterator<String> it = map.keySet().iterator();
		
		while(it.hasNext()) {
			String major = it.next();
			System.out.printf("%s %d명\n",major, map.get(major));			
		}
		
	}

}









