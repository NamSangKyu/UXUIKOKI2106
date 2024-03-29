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
		
		switch(command) {
		case "login.do":
			controller = new LoginController();
			break;
		case "logout.do":
			controller = new LogoutController();
			break;
		case "register.do":
			controller = new RegisterController();
			break;
		case "update.do":
			//회원 정보 수정 하는 기능을 붙임
			controller = new UpdateController();
			break;
		case "delete.do":
			//회원 삭제 기능
			controller = new DeleteController();
			break;
		case "boardList.do":
			controller = new MainController();
			break;
		case "boardWrite.do":
			controller = new BoardWriteController();
			break;
		case "boardWriteView.do":
			controller = new BoardWriteViewController();
			break;
		case "boardView.do":
			controller = new BoardViewController();
			break;
		case "boardDelete.do":
			controller = new BoardDeleteController();
			break;
		case "boardUpdateView.do":
			controller = new BoardUpdateViewController();
			break;
		case "boardUpdate.do":
			controller = new BoardUpdateController();
			break;	
		case "boardLike.do":
			controller= new BoardLikeController();
			break;
		case "boardHate.do":
			controller= new BoardHateController();
			break;
		case "insertComment.do":
			controller = new BoardCommentInsertController();
			break;
		case "selectComment.do":
			controller = new BoardCommentSelectController();
			break;
		}
		
		return controller;
	}

}
