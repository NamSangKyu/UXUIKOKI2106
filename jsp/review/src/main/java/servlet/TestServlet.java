package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/test.do")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    //method 속성이 get이 였을때
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
					//parameter는 사용자가 데이터 보낼때 폼태그의 name 속성
		String search = request.getParameter("param");
		//세션 정보 가져오기, 세션 정보는 request
		HttpSession session = request.getSession();
		session.setAttribute("test", search);
		//페이지 이동
		//response.sendRedirect(request.getContextPath()+"/result.jsp");
		RequestDispatcher dis =  request.getRequestDispatcher("result.jsp");
		System.out.println(dis.FORWARD_REQUEST_URI);
		dis.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	//method 속성이 post 였을때
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
