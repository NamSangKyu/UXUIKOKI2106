package controller;

public class HandlerMapping {
	//싱글톤 패턴 적용
	private static HandlerMapping instance = new HandlerMapping();
	
	private HandlerMapping() {	}

	public static HandlerMapping getInstance() {
		if(instance == null)
			instance = new HandlerMapping();
		return instance;
	}
	
	public Controller createController(int no) {
		Controller controller = null;
		switch(no) {
		
		}
		return controller;
	}

}










