package org.korea;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.json.JSONObject;
import org.korea.dto.BoardDTO;
import org.korea.dto.FileDTO;
import org.korea.dto.MemberDTO;
import org.korea.dto.PaggingVO;
import org.korea.service.BoardService;
import org.korea.service.MemberService;
import org.korea.tanslate.TranslateModule;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;

@Controller
public class MainController {
	private BoardService boardService;
	private MemberService memberService;
	private AnnotationConfigApplicationContext ctx ;
	public MainController(BoardService boardService, MemberService memberService) {
		super();
		this.boardService = boardService;
		this.memberService = memberService;
		ctx = new AnnotationConfigApplicationContext(DIContainer.class);
	}

	@RequestMapping("/")
	public String main() {
		return "main";
	}

	@RequestMapping("boardList.do")
	public String boardMain(HttpServletRequest request, HttpSession session) {
		//1. 현재 페이지 번호 - 없으면 페이지 번호 1로 설정
		String pageNo = request.getParameter("pageNo");
		int currentPageNo = pageNo == null || pageNo.equals("") ? 1 : Integer.parseInt(pageNo);
		
		ArrayList<BoardDTO> list = boardService.selectBoard(currentPageNo);
		if(session.getAttribute("target") == null || session.getAttribute("target").equals("ko"))
			request.setAttribute("list", list);
		else {
			TranslateModule module = ctx.getBean("translateModule",TranslateModule.class);
			//선택한 언어로 번역
			for(int i=0;i<list.size();i++) {
				String text = module.translate(
						"ko", session.getAttribute("target").toString(), list.get(i).getTitle());
				
				System.out.println(text);
				list.get(i).setTitle(text);
				request.setAttribute("list", list);
			}
		}
		//페이징 처리
		//전체 게시글 개수
		int count = boardService.selectBoardCount();
		PaggingVO vo = new PaggingVO(count, currentPageNo, 5, 4);
		request.setAttribute("pagging", vo);
		return "board/board_list";
	}

	@RequestMapping("/login.do")
	public String login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");

		MemberDTO dto = memberService.login(id, pass);

		if (dto == null) {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("<script>alert('아이디 비밀번호 확인하세요'); history.back();</script>");
			return null;
		} else {
			request.getSession().setAttribute("client", dto);
			return boardMain(request, request.getSession());
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
		MemberDTO dto = new MemberDTO(id, pass, name, age, gender, 0, null);
		int count = memberService.insertMember(dto);

		if (count == 0) {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("<script>alert('아이디가 중복되었습니다.'); history.back();</script>");
			return null;
		}
		request.getSession().setAttribute("client", dto);
		return boardMain(request, request.getSession());
	}

	@RequestMapping("idCheck.do")
	public String idCheck(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		MemberDTO dto = memberService.idCheck(id);
		JSONObject object = new JSONObject();
		System.out.println(dto);
		if (dto == null)
			object.put("result", true);
		else
			object.put("result", false);
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
		MemberDTO dto = new MemberDTO(id, pass, name, age, null, 0, null);
		int count = memberService.updateMember(dto);
		if (count == 0) {
			request.getSession().invalidate();
			response.setContentType("text/html;charset=utf-8");
			response.getWriter()
					.write("<script>alert('없는 회원 입니다. 확인 후 다시 수행해 주세요');" + "location.href = '/';</script>");
			return null;
		}

		return boardMain(request, request.getSession());
	}

	@RequestMapping("boardWriteView.do")
	public String boardWriteView() {
		return "board/board_write";
	}

	@RequestMapping("boardWrite.do")
	public String boardWrite(MultipartHttpServletRequest request, HttpSession session)
			throws UnsupportedEncodingException {

		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String writer = ((MemberDTO) session.getAttribute("client")).getId();
		int bno = boardService.insertBoard(new BoardDTO(0, title, writer, null, content, 0, 0, 0));
		// 업로드한 파일 목록
		System.out.println(request.getParameterMap());
		List<MultipartFile> fileList = request.getFiles("file");
		System.out.println(fileList.size());
		String path = "c:\\fileupload\\" + writer + "\\";
		ArrayList<FileDTO> flist = new ArrayList<FileDTO>();
		int i = 1;
		for (MultipartFile mf : fileList) {
			// 원본 파일명
			String originalFileName = mf.getOriginalFilename();
			long fileSize = mf.getSize();
			if (fileSize == 0)
				continue;
			// 저장할 파일 경로 완성
			SimpleDateFormat format = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss");
			int idx = originalFileName.lastIndexOf(".");
			// 실제 저장할 파일 경로
			String saveName = format.format(Calendar.getInstance().getTime()) + "_" + writer + "_" + i + "."
					+ originalFileName.substring(idx + 1);
			i++;
			String saveFile = path + saveName;
			System.out.println(saveFile);
			File f = new File(saveFile);
			FileDTO dto = new FileDTO(f);
			dto.setOriginFileName(originalFileName);
			dto.setBno(bno);
			dto.setWriter(writer);
			flist.add(dto);
			System.out.println(dto.toString());
			try {
				// 파일 업로드
				File parentPath = new File(path);
				if (!parentPath.exists())
					parentPath.mkdirs();
				mf.transferTo(f);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		boardService.insertFileList(flist);

		return "redirect:boardList.do";
	}

	@RequestMapping("boardView.do")
	public String boardView(HttpServletRequest request,HttpSession session) {
		System.out.println(session.getAttribute("target"));
		int bno = Integer.parseInt(request.getParameter("bno"));
		boardService.addBoardCount(bno);
		BoardDTO dto = boardService.selectBoardContent(bno);
		request.setAttribute("board", dto);
		if(session.getAttribute("target") != null && !session.getAttribute("target").equals("ko")) {
			TranslateModule module = ctx.getBean("translateModule",TranslateModule.class);
			String text = module.translate(
					"ko", session.getAttribute("target").toString(), dto.getTitle());
			dto.setTitle(text);
			text = module.translate(
					"ko", session.getAttribute("target").toString(), dto.getContent());
			dto.setContent(text);
			
		}
			
		// 파일목록
		ArrayList<FileDTO> flist = boardService.selectFileList(bno);
		request.setAttribute("flist", flist);

		return "board/board_view";
	}

	@RequestMapping("fileDownload.do")
	public String fileDownload(HttpServletRequest request, HttpServletResponse response) {
		int fno = Integer.parseInt(request.getParameter("fno"));

		FileDTO dto = boardService.selectFile(fno);

		File file = new File(dto.getPath());
		FileInputStream fis = null;
		BufferedOutputStream bos = null;
		try {
			fis = new FileInputStream(file);
			String encodingName = URLEncoder.encode(file.getAbsolutePath(), "utf-8");
			response.setHeader("Content-Disposition", "attachment;filename=" + dto.getOriginFileName());
			response.setHeader("Content-Transfer-Encode", "binary");
			bos = new BufferedOutputStream(response.getOutputStream());
			byte[] buffer = new byte[1024 * 1024];
			while (true) {
				int count = fis.read(buffer);
				if (count == -1)
					break;
				bos.write(buffer, 0, count);
				bos.flush();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(fis != null)
					fis.close();
				if(bos != null)
					bos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	//번역하는 부분 추가
	@RequestMapping("language.do")
	public String setlanguage(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
		System.out.println("target");
		session.setAttribute("target", request.getParameter("target"));
		response.getWriter().write("true");
		return null;
	}
	//게시글 삭제
	@RequestMapping("boardDelete.do")
	public String boardDelete(HttpServletRequest request) {
		int bno = Integer.parseInt(request.getParameter("bno"));
		boardService.deleteBoard(bno);
		return "redirect:boardList.do";
	}
	//게시글 수정 페이지로 이동
	@RequestMapping("boardUpdateView.do")
	public String boardUpdateView(HttpServletRequest request) {
		int bno = Integer.parseInt(request.getParameter("bno"));
		BoardDTO dto = boardService.selectBoardContent(bno);
		request.setAttribute("board", dto);
		return "board/board_update_view";
	}
	
	//게시글 수정
	@RequestMapping("boardUpdate.do")
	public String boardUpdate(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		boardService.updateBoard(bno, title, content);
		redirectAttributes.addAttribute("bno",bno);
		return "redirect:/boardView.do";
//		return "redirect:/boardView.do?bno="+bno;
	}
	//좋아요 & 싫어요
	@RequestMapping("boardLike.do")
	public String boardLike(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int bno = Integer.parseInt(request.getParameter("bno"));
		MemberDTO dto = (MemberDTO) request.getSession().getAttribute("client");
		response.setContentType("text/html;charset=utf-8");
		JSONObject json = new JSONObject();
		if(dto == null) {
			json.put("msg", "로그인하셔야 이용하실수 있습니다.");
			json.put("code", 400);
			response.getWriter().write(json.toString());
			return null;
		}
		
		boolean result = boardService.insertBoardLike(bno, dto.getId());
		String msg = result ? "좋아요 표시를 했습니다." : "좋아요를 취소했습니다.";
		json.put("msg",msg);
		json.put("code",200);
		response.getWriter().write(json.toString());
		return null;
	}
	@RequestMapping("boardHate.do")
	public String boardHate(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int bno = Integer.parseInt(request.getParameter("bno"));
		MemberDTO dto = (MemberDTO) request.getSession().getAttribute("client");
		response.setContentType("text/html;charset=utf-8");
		JSONObject json = new JSONObject();
		if(dto == null) {
			json.put("msg", "로그인하셔야 이용하실수 있습니다.");
			json.put("code", 400);
			response.getWriter().write(json.toString());
			return null;
		}
		
		boolean result = boardService.insertBoardHate(bno, dto.getId());
		String msg = result ? "싫어요 표시를 했습니다." : "싫어요를 취소했습니다.";
		json.put("msg",msg);
		json.put("code",200);
		response.getWriter().write(json.toString());
		return null;
	}
}








