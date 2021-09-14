package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import dto.ProductDTO;
import mapper.ProductMapper;

public class InsertController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			response.setContentType("text/html;charset=utf-8");
			String productNo =request.getParameter("pno"); 
			String productName = request.getParameter("pname");
			int price =Integer.parseInt(request.getParameter("price")); 
			int ea = Integer.parseInt(request.getParameter("ea")) ;
			if(price < 0 || ea < 0)
				throw new Exception("1002");
			String maker = request.getParameter("maker");
			ProductDTO dto=new ProductDTO(productNo, productName, price, ea, maker);
			int count = ProductMapper.getInstance().insertProduct(dto);
			JSONObject json = new JSONObject();
			json.put("result", count);
			List<Map<String, Object>> list =ProductMapper.getInstance().selectAllProduct();
			JSONArray arr = new JSONArray(list);
			json.put("data", arr);
			response.getWriter().write(json.toString());
		}catch (NumberFormatException e) {
			response.setStatus(1003);
			response.getWriter().write("금액과 재고는 숫자로 입력하세요");
		}catch (Exception e) {
			String msg = "";
			switch(e.getMessage()) {
			case "1002":
				response.setStatus(1002);
				msg = "금액이나 재고는 양수만 입력하세요";
				break;	
			default:
				response.setStatus(1001);
				msg = "입력한 데이터를 확인하세요";
				
			}
			response.getWriter().write(msg);
		}
	}

}
