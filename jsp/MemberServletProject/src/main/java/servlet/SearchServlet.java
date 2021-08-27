package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import dto.MemberDTO;
import service.MemberService;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/search.do")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String kind = request.getParameter("kind");
		String search = request.getParameter("search");
		ArrayList<MemberDTO> list = MemberService.getInstance().searchMember(kind, search);
		
		JSONArray array = new JSONArray();
		
		for(int i=0;i<list.size();i++) {
			JSONObject obj = new JSONObject();
			obj.put("id", list.get(i).getId());
			obj.put("name", list.get(i).getName());
			obj.put("age", list.get(i).getAge());
			obj.put("point", list.get(i).getPoint());
			obj.put("grade", list.get(i).getGrade());
			obj.put("gender", list.get(i).getGender());
			array.put(obj);
		}
		
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(array.toString());			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
