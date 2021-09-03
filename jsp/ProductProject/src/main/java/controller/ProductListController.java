package controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import view.ModelAndView;

public class ProductListController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		return new ModelAndView("/product_manager.jsp", false);
	}

}
