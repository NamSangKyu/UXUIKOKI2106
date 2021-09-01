package controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import dto.MemberDTO;
import service.BoardService;
import view.ModelAndView;

public class BoardHateController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int bno = Integer.parseInt(request.getParameter("bno"));
		MemberDTO dto = (MemberDTO) request.getSession().getAttribute("obj");
		JSONObject json = new JSONObject();
		if(dto == null) {
			json.put("msg", "로그인하셔야 이용하실수 있습니다.");
			json.put("code", 400);
			response.getWriter().write(json.toString());
			return null;
		}
		
		boolean result = BoardService.getInstance().insertBoardHate(bno, dto.getId());
		String msg = result ? "싫어요 표시를 했습니다." : "싫어요를 취소했습니다.";
		json.put("msg",msg);
		json.put("code",200);
		response.getWriter().write(json.toString());
		return null;
	}

}
