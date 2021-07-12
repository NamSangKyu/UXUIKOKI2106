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
			controller = new LoginController();
			break;
		case 2:
			controller = new SelectSubjectController();
			break;
		case 3:
			controller = new RegisterSubjectController();
			break;
		case 4:
			controller = new UpdateSubjectController();
			break;
		case 5:
			controller = new RegisterSubjectListController();
			break;
		}
		return controller;
	}
		
}









