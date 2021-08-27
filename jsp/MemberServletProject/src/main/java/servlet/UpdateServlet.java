package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import dto.MemberDTO;
import service.MemberService;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/update.do")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");
		int point = Integer.parseInt(request.getParameter("point"));
		String grade = request.getParameter("grade");
		
		int count = MemberService.getInstance().updateMember(new MemberDTO(id,null,name,age,gender,point,grade));
		
		if(count == 1){
			response.sendRedirect("main.jsp");
			//수정후 데이터를 다시 읽어오는 부분
			ArrayList<MemberDTO> list = MemberService.getInstance().selectAllMember();
			request.getSession().setAttribute("list", list);
		}else{
			response.getWriter().write("<script>history.back();</script>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}





