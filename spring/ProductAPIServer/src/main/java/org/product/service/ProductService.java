package org.product.service;

import java.util.ArrayList;
import java.util.HashMap;
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

	public int insertLog(String date, String code, String content) {
		HashMap<String, Object> map= new HashMap<String, Object>();
		map.put("date",date);
		map.put("code",code);
		map.put("content",content);
		return mapper.insertLog(map);
	}
	
	
}
