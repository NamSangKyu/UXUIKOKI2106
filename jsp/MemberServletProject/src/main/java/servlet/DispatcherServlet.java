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
 * Servlet implementation class DispatcherServlet
 */
@WebServlet("*.action")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String  CONTEXT_PATH = "";
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatcherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CONTEXT_PATH = arg0.getContextPath();
		//System.out.println(CONTEXT_PATH);
		super.service(arg0, arg1);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String[] arr = request.getRequestURI().split("/");
		String command = arr[arr.length-1];
		//response.getWriter().print(command);
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
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
