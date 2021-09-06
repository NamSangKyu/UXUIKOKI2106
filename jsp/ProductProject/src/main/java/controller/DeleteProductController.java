package controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ProductService;
import view.ModelAndView;

public class DeleteProductController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String pno = request.getParameter("pno");
		
		ProductService.getInstance().deleteProduct(pno);
		
		return new ModelAndView("productList.do", false);
	}

}
