package org.product;

import org.product.service.ProductService;
import org.springframework.stereotype.Controller;

@Controller
public class MainController {
	private ProductService service;

	public MainController(ProductService service) {
		super();
		this.service = service;
	}
	
	
}
