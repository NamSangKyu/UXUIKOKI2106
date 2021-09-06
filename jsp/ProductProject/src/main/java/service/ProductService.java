package service;

import java.util.ArrayList;

import dao.ProductDAO;
import dto.ProductDTO;

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

	public ArrayList<ProductDTO> selectAllProduct() {
		return ProductDAO.getInstance().selectAllProduct();
	}

	public int insertProduct(ProductDTO dto) {
		return ProductDAO.getInstance().insertProduct(dto);
	}

}







