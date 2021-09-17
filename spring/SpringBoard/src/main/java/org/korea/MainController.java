package org.korea;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.korea.dto.BoardDTO;
import org.korea.dto.FileDTO;
import org.korea.dto.MemberDTO;
import org.korea.service.BoardService;
import org.korea.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class MainController {
	private BoardService boardService;
	private MemberService memberService;
	
	public MainController(BoardService boardService, MemberService memberService) {
		super();
		this.boardService = boardService;
		this.memberService = memberService;
	}

	@RequestMapping("/")
	public String main() {
		return "main";
	}
	@RequestMapping("boardList.do")
	public String boardMain(HttpServletRequest request) {
		ArrayList<BoardDTO> list = boardService.selectBoard(1);
		request.setAttribute("list", list);
		return "board/board_list";
	}
	
	@RequestMapping("/login.do")
	public String login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		MemberDTO dto = memberService.login(id,pass);
		
		if(dto == null) {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("<script>alert('아이디 비밀번호 확인하세요'); history.back();</script>");
			return null;
		}else {
			request.getSession().setAttribute("client", dto);
			return boardMain(request);
		}
		
	}
	@RequestMapping("registerView.do")
	public String registerView() {
		return "member/member_register";
	}
	@RequestMapping("memberRegister.do")
	public String memberRegister(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");
		MemberDTO dto = new MemberDTO(id,pass,name,age,gender , 0, null);
		int count = memberService.insertMember(dto);
		
		if(count == 0) {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("<script>alert('아이디가 중복되었습니다.'); history.back();</script>");
			return null;
		}
		request.getSession().setAttribute("client", dto);
		return boardMain(request);
	}
	@RequestMapping("idCheck.do")
	public String idCheck(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		MemberDTO dto = memberService.idCheck(id);
		JSONObject object = new JSONObject();
		System.out.println(dto);
		if(dto == null) 
			object.put("result",true);
		else
			object.put("result",false);
		response.getWriter().write(object.toString());	
		return null;
	}
	
	@RequestMapping("logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "main";
	}
	
	@RequestMapping("memberUpdateView.do")
	public String memberUpdateView(HttpSession session) {
		return "member/member_update";
	}
	@RequestMapping("memberUpdate.do")
	public String memberUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		MemberDTO dto = new MemberDTO(id,pass,name,age,null, 0, null);
		int count = memberService.updateMember(dto);
		if(count == 0) {
			request.getSession().invalidate();
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("<script>alert('없는 회원 입니다. 확인 후 다시 수행해 주세요');"
					+ "location.href = '/';</script>");
			return null;
		}
		
		return boardMain(request);
	}
	
	@RequestMapping("boardWriteView.do")
	public String boardWriteView() {
		return "board/board_write";
	}
	@RequestMapping("boardWrite.do")
	public String boardWrite(MultipartHttpServletRequest request, HttpSession session) throws UnsupportedEncodingException {
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String writer = ((MemberDTO)session.getAttribute("client")).getId();
		int bno = boardService.insertBoard(
				new BoardDTO(0, title, writer, null, content, 0, 0, 0));
		//업로드한 파일 목록
		System.out.println(request.getParameterMap());
		List<MultipartFile> fileList = request.getFiles("file"); 
		System.out.println(fileList.size());
		String path = "c:\\fileupload\\"+writer+"\\";
		ArrayList<FileDTO> flist = new ArrayList<FileDTO>();
		
		for(MultipartFile mf : fileList) {
			//원본 파일명
			String originalFileName = mf.getOriginalFilename();
			long fileSize = mf.getSize();
			if(fileSize == 0) continue;
			//저장할 파일 경로 완성
			String saveFile = path+originalFileName;
			System.out.println(saveFile);
			File f = new File(saveFile);
			FileDTO dto = new FileDTO(f);
			dto.setBno(bno);
			dto.setWriter(writer);
			flist.add(dto);
			System.out.println(dto.toString());
			try {
				//파일 업로드
				File parentPath = new File(path);
				if(!parentPath.exists()) parentPath.mkdirs();
				mf.transferTo(f);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		boardService.insertFileList(flist);
		
		return boardMain(request);
	}
	
	
}











