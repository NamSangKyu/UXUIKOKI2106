package controller;

import java.util.Scanner;

import service.StudentService;

public class SelectAllController implements Controller {

	@Override
	public void excute(Scanner sc) {
		StudentService.getInstance().selectAllStudent();
	}

}
