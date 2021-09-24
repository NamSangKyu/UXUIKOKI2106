package org.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.product.dto.ProductDTO;
import org.product.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	private ProductService service;

	public MainController(ProductService service) {
		super();
		this.service = service;
	}
	
	@RequestMapping("search.do")
	public String search(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//클라이언트가 보낸 제품명 일부를 가지고 검색 - parameter : search
		String search = request.getParameter("search");
		List<ProductDTO> list = service.searchList(search);
		//검색 결과를 json으로 만들어서 클라이언트에게 전송
		JSONObject result = new JSONObject();
		if(list.size() == 0) {
			result.put("code", 500);//검색 실패했을 때
			result.put("responseMessage", "검색 결과가 없습니다.");
		}else {
			result.put("code", 200);//검색 성공했을 때
			JSONArray arr = new JSONArray(list);
			result.put("responseMessage",arr);			
		}
		System.out.println(result.toString());
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(result.toString());
		return null;
	}
	@RequestMapping("sendLog.do")
	public String sendLog(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String date = request.getParameter("date");
		String code = request.getParameter("code");
		String content = request.getParameter("content");
		
		int result = service.insertLog(date,code,content);
		
		response.getWriter().write(String.valueOf(result));
		return null;
	}
}









