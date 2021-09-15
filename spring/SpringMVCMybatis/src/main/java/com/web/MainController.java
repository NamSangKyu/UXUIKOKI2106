package com.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.dto.MemberDTO;
import com.web.service.MemberService;

@Controller
public class MainController {
	private MemberService service;

	public MainController(MemberService service) {
		this.service = service;
	}
	
	@RequestMapping("/")
	public String main(HttpServletRequest request) {
		List<MemberDTO> list = service.selectAllMember();
		request.setAttribute("list", list);
		return "member_manager";
	}
	
}






