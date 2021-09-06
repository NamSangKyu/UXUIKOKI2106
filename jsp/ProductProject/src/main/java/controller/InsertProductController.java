package controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.ProductDTO;
import service.ProductService;
import view.ModelAndView;

public class InsertProductController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String pno = request.getParameter("pno");
		String pname = request.getParameter("pname");
		String price = request.getParameter("price");
		String maker = request.getParameter("maker");
		ModelAndView view = null;
		try {
		int p = Integer.parseInt(price);
		if(p < 0)
			throw new Exception("금액은 양수만 입력하세요");
		
		int count = ProductService.getInstance().insertProduct(new ProductDTO(pno, pname, p, maker));
		if(count == 1)
			view = new ModelAndView("productList.do", false);
		else {
			response.getWriter().write("<script>alert('제품 등록에 실패했습니다. 입력한 정보를 확인하세요');"
					+ "history.back();</script>");
		}
			
		}catch (NumberFormatException e) {
			response.getWriter().write("<script>alert('금액에는 숫자만 입력하세요');"
					+ "history.back();</script>");
		} catch (Exception e) {
			response.getWriter().write("<script>alert('"+e.getMessage()+"');"
					+ "history.back();</script>");
		}
		
		return view;
	}

}
