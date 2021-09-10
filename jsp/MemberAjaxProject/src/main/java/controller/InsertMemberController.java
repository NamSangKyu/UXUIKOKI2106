package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.exceptions.PersistenceException;
import org.json.JSONArray;
import org.json.JSONObject;

import dto.MemberDTO;
import service.MemberService;

public class InsertMemberController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html;charset=utf-8");
		try {
			String id = request.getParameter("id");
			String passwd = request.getParameter("passwd");
			String name = request.getParameter("name");
			int age = Integer.parseInt(request.getParameter("age"));
			String gender = request.getParameter("gender");
			int point = Integer.parseInt(request.getParameter("point"));
			String grade = request.getParameter("grade");

			MemberDTO dto = new MemberDTO(id, passwd, name, age, gender, point, grade);

			MemberService.getInstance().insertMember(dto);

			// 전체 데이터
			List<MemberDTO> list = MemberService.getInstance().selectAllMember();
			// json 객체 생성
			JSONArray array = new JSONArray(list);
			response.getWriter().write(array.toString());
		} catch (NumberFormatException e) {
			response.setStatus(1001);
			response.getWriter().write(e.getMessage());
		}catch (PersistenceException e) {
			response.setStatus(1002);
			response.getWriter().write("아이디가 중복되었습니다.");
		}
	}

}
