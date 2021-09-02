package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.HandlerMapping;
import view.ModelAndView;

/**
 * Servlet implementation class DispatcjerServlet
 */
@WebServlet("*.do")
public class DispatcjerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatcjerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String[] arr = request.getRequestURI().split("/");
		String command = arr[arr.length-1];
		System.out.println(command);
		Controller controller = HandlerMapping.getInstance().createController(command);
		ModelAndView view = null;
		if(controller != null)
			view = controller.execute(request, response);
		
		if(view == null) return;
		System.out.println(view.getPath());
		if(view.isRedirect()) {
			response.sendRedirect(view.getPath());
		}else {
			request.getRequestDispatcher(view.getPath()).forward(request, response);
		}
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
