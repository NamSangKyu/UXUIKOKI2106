package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.ProductDTO;
import service.ProductService;
import view.ModelAndView;

public class ProductListController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ArrayList<ProductDTO> list = ProductService.getInstance().selectAllProduct();
		request.setAttribute("list", list);
		return new ModelAndView("/product_manager.jsp", false);
	}

}









