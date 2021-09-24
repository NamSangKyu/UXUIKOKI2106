package org.product.service;

import java.util.ArrayList;
import java.util.List;

import org.product.dto.ProductDTO;
import org.product.mapper.ProductMapper;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	private ProductMapper mapper;

	public ProductService(ProductMapper mapper) {
		super();
		this.mapper = mapper;
	}

	public List<ProductDTO> searchList(String search) {
		return mapper.searchList(search);
	}
	
	
}
