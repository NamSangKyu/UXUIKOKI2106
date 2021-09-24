package org.product.service;

import org.product.mapper.ProductMapper;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	private ProductMapper mapper;

	public ProductService(ProductMapper mapper) {
		super();
		this.mapper = mapper;
	}
	
	
}
