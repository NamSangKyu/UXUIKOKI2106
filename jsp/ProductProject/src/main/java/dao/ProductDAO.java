package dao;

public class ProductDAO {
	private static ProductDAO instance = new ProductDAO();

	private ProductDAO() {
		super();
	}

	public static ProductDAO getInstance() {
		if(instance == null)
			instance = new ProductDAO();
		return instance;
	}

}
