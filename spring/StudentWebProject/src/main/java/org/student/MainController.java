package org.student;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.student.dto.StudentDTO;
import org.student.service.StudentService;

@Controller
public class MainController {
	private StudentService service;

	public MainController(StudentService service) {
		this.service = service;
	}
	
	@RequestMapping("/")
	public String main(HttpServletRequest request) {
		List<StudentDTO> list = service.selectAllStudent();
		request.setAttribute("list", list);
		return "student_search";
	}
	
	@RequestMapping("/search.do")
	public String search(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String kind = request.getParameter("kind");
		String search = request.getParameter("search");
		
		List<StudentDTO> list = service.selectStudent(kind,search);
		
		JSONArray arr = new JSONArray(list);
		JSONObject obj = new JSONObject();
		obj.put("result", arr);
		if(list.size() != 0) {
			obj.put("code", 200);
			obj.put("message", "정상적으로 조회되었습니다.");
		}else {
			obj.put("code", 500);
			obj.put("message", "조회된 데이터가 없습니다.");
			
		}
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(obj.toString());
		
		return null;
	}
	
	@RequestMapping("sendLog.do")
	public String sendLog(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String code = request.getParameter("code");
		String date= request.getParameter("date");
		String content= request.getParameter("content");
		
		service.insertLog(code, date, content);
		
		response.setContentType("text/html;charset=uft-8");
		response.getWriter().write("전송 완료");
		return null;	
	}
}





