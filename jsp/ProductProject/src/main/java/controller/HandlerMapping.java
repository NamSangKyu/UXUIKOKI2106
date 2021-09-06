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
		case "productList.do":
			controller = new ProductListController();
			break;
		case "insertProduct.do":
			controller = new InsertProductController();
			break;
		case "deleteProduct.do":
			controller = new DeleteProductController();
			break;
		case "updateProduct.do":
			controller = new UpdateProductController();
			break;
		}
		
		return controller;
	}
}








