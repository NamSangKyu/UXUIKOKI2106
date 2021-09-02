package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import org.json.JSONArray;
import org.json.JSONObject;

import dto.BoardCommentDTO;
import dto.MemberDTO;
import service.BoardService;
import view.ModelAndView;

public class BoardCommentInsertController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int bno = Integer.parseInt(request.getParameter("bno"));
		String comment = request.getParameter("content");
		String writer = ((MemberDTO)request.getSession().getAttribute("obj")).getId();
		int result = BoardService.getInstance().insertBoardComment(new BoardCommentDTO(bno, writer, comment) );
		ArrayList<BoardCommentDTO> list =BoardService.getInstance().selectAllComment(bno);
		
		JSONObject json = new JSONObject();
		if(result != 0) {
			json.put("code", 200);//정상 처리 되었을때
			JSONArray arr = new JSONArray();
			for(int i=0;i<list.size();i++)
				arr.put(list.get(i).toJSON());
			json.put("list", arr);
		}else {
			json.put("code", 400);//정상 처리 되었을때
		}
		response.getWriter().write(json.toString());
		return null;
	}

}
