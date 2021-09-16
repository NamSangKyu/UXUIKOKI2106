package org.korea;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.json.JSONObject;
import org.korea.dto.BoardDTO;
import org.korea.dto.FileDTO;
import org.korea.dto.MemberDTO;
import org.korea.service.BoardService;
import org.korea.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String boardWrite(HttpServletRequest request, HttpSession session) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		String encoding = "utf-8";
		String root = "c:\\fileupload\\";
		File userRoot = new File(root);
		
		if(!userRoot.exists())
			userRoot.mkdirs();
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(userRoot);
		factory.setSizeThreshold(1024*1024);
		
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List<FileItem> list = upload.parseRequest(request);
			ArrayList<FileDTO> flist = new ArrayList<FileDTO>();
			String user = ((MemberDTO)session.getAttribute("client")).getId();
			BoardDTO dto = new BoardDTO();
			dto.setWriter(user);

			for(int i=0;i<list.size();i++) {
				FileItem item = list.get(i);
				
				if(item.isFormField()) {
					//폼일 경우
					switch(item.getFieldName()) {
					case "title":
						dto.setTitle(item.getString(encoding));
						break;
					case "content":
						dto.setContent(item.getString(encoding));
						break;
					}
				}else {
					//파일일 경우
					if(item.getSize()>0) {
						int idx = item.getName().lastIndexOf("\\");
						if(idx == -1)
							idx = item.getName().lastIndexOf("/");
						String fileName = item.getName().substring(idx+1);
						File uploadFile = new File(root + "\\" + fileName);
						if(!uploadFile.getParentFile().exists())
							uploadFile.getParentFile().mkdirs();
						item.write(uploadFile);//주어진 경로로 파일 쓰기
						flist.add(new FileDTO(uploadFile));
					}
				}
			}
			//게시글 등록
			int bno = boardService.insertBoard(dto);
			//파일테이블에 경로 등록
			boardService.insertFileList(bno,flist);
		}catch (FileUploadException e) {
			// TODO: handle exception
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return boardMain(request);
	}
	
	
}











