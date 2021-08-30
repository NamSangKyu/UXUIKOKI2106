package sevlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.MemberDTO;

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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("dto", new MemberDTO("A0001", "12345", "홍길동", 20, "남", 33000, "VVIP"));
		request.setAttribute("age", 19);
		request.getSession().setAttribute("msg", "session message");
		//ArrayList로 MemberDTO 3건이상 저장해서 list로 request 영역에 저장
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		list.add(new MemberDTO("A0001","1234","AAAA",20,"남",33333,"Gold"));
		list.add(new MemberDTO("A0002","1234","BBBB",20,"남",33333,"Gold"));
		list.add(new MemberDTO("A0003","1234","CCCC",20,"남",33333,"Gold"));
		request.setAttribute("list", list);
		request.getRequestDispatcher("jstl_el.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
