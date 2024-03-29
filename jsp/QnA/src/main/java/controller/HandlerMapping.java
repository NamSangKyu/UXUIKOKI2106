package controller;

public class HandlerMapping {
	private static HandlerMapping instance = new HandlerMapping();

	private HandlerMapping() {
		super();
	}

	public static HandlerMapping getInstance() {
		if(instance == null)
			instance = new HandlerMapping();
		return instance;
	}
	
	public Controller createController(String command) {
		Controller controller = null;
		switch(command) {
		case "login.do":
			controller = new LoginController();
			break;
		case "adminMain.do":
			controller = new AdminMainController();
			break;
		case "memberMain.do":
			controller = new MemberMainController();
			break;
		case "qnaWrite.do":
			controller = new QnaInsertController();
			break;
		case "qnaView.do":
			controller = new QnaViewController();
			break;
		case "qnaAdminView.do":
			controller = new QnaAdminViewController();
			break;
		case "answerUpdate.do":
			controller = new QnaAnswerUpdateController();
			break;
		case "fileDownload.do":
			controller = new FileDownloadController();
			break;
		}
		
		return controller;
	}
}








