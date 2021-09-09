package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import dto.MemberDTO;
import service.MemberService;

public class DeleteMemberController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String id = request.getParameter("id");
		MemberService.getInstance().deleteMember(id);

		// 전체 데이터
		List<MemberDTO> list = MemberService.getInstance().selectAllMember();
		// json 객체 생성
		JSONArray array = new JSONArray(list);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(array.toString());
	}

}
