package org.korea;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/")
	public String main() {
		System.out.println("메인 페이지로 이동");
		return "main";
	}
}
