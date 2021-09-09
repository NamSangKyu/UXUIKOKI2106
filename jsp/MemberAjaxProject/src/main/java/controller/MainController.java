package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.MemberDTO;
import service.MemberService;

public class MainController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		//모든 데이터를 읽어들임
		List<MemberDTO> list = MemberService.getInstance().selectAllMember();
		//데이터 셋팅
		request.setAttribute("list", list);
		//페이지 설정
		request.getRequestDispatcher("/member_manager.jsp").forward(request, response);		
	}

}










