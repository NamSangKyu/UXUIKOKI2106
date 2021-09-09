package controller;

public class HandlerMapping {
	private static HandlerMapping instance = new HandlerMapping();

	private HandlerMapping() {
	}

	public static HandlerMapping getInstance() {
		if(instance == null)
			instance = new HandlerMapping();
		return instance;
	}
	
	public Controller createController(String command) {
		Controller controller = null;
		switch (command) {
		case "main.do":
			controller = new MainController();
			break;
		case "insertMember.do":
			controller = new InsertMemberController();
			break;
		case "deleteMember.do":
			controller = new DeleteMemberController();
			break;
		
		}
		return controller;
	}
	
}



