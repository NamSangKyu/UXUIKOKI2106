package org.korea;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

	@RequestMapping("/")
	public String main() {
		System.out.println("메인 페이지로 이동");
		return "main";
	}

	@RequestMapping("/login.do")
	//public String login(@RequestParam("id")String id, @RequestParam("pass")String pass, HttpSession session ) {
	public String login(HttpServletRequest request, HttpSession session ) {
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		session.setAttribute("id", id);
		System.out.println(id + " " + pass);
		return "main";
	}
	
}











