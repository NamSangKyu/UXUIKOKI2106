package service;

public class ProductService {
	private static ProductService instance = new ProductService();

	private ProductService() {
		super();
	}

	public static ProductService getInstance() {
		if(instance == null)
			instance = new ProductService();
		return instance;
	}

}
