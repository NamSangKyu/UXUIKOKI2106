package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import dto.MemberDTO;
import service.MemberService;

public class SearchMemberController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String kind = request.getParameter("kind");
		String search = request.getParameter("search");
		
		List<MemberDTO> list = MemberService.getInstance().search(kind,search);
		JSONArray arr = new JSONArray(list);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(arr.toString());
	}

}




