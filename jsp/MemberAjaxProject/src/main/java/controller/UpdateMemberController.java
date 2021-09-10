package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.exceptions.PersistenceException;
import org.json.JSONArray;

import dto.MemberDTO;
import service.MemberService;

public class UpdateMemberController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		try {
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");
		int point = Integer.parseInt(request.getParameter("point"));
		String grade = request.getParameter("grade");

		MemberDTO dto = new MemberDTO(id, passwd, name, age, gender, point, grade);

		MemberService.getInstance().updatetMember(dto);

		// 전체 데이터
		List<MemberDTO> list = MemberService.getInstance().selectAllMember();
		// json 객체 생성
		JSONArray array = new JSONArray(list);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(array.toString());
		}catch (Exception e) {
			String msg = "";
			int status = 1000;
			
			if(e instanceof NumberFormatException) {
				status = 1001;
				msg = "나이와 포인트에는 숫자 입력하세요";
			}else if(e instanceof PersistenceException) {
				status = 1002;
				msg = "입력하신 데이터에 문제가 있습니다 확인 후 다시 입력하세요";
			}else {
				msg = "알수없는 오류";
			}
			response.setContentType("text/html;charset=utf-8");
			response.setStatus(status);
			response.getWriter().write(msg);
			
		}
	}

}
