package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import dto.BoardCommentDTO;
import service.BoardService;
import view.ModelAndView;

public class BoardCommentSelectController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int bno = Integer.parseInt(request.getParameter("bno"));
		ArrayList<BoardCommentDTO> list =BoardService.getInstance().selectAllComment(bno);
		
		JSONObject json = new JSONObject();
		json.put("code", 200);//정상 처리 되었을때
		JSONArray arr = new JSONArray();
		for(int i=0;i<list.size();i++)
			arr.put(list.get(i).toJSON());
		json.put("list", arr);
		response.getWriter().write(json.toString());
		return null;
	}

}
