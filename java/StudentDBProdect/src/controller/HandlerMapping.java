package controller;

public class HandlerMapping {
	private static HandlerMapping instance = new HandlerMapping();

	private HandlerMapping() {

	}

	public static HandlerMapping getInstance() {
		if(instance == null)
			instance = null;
		return instance;
	}
	
	public Controller createController(int no) {
		Controller controller = null;
		switch(no) {
		case 1:
			controller = new InsertStudentController();
			break;
		case 2:
			controller = new SelectSnoStudentController();
			break;
		case 3:
			controller = new UpdateStudentController();
			break;
		case 5:
			controller = new SelectAllStudentController();
			break;
		}
		return controller;
	}
	
	
	
	
}


