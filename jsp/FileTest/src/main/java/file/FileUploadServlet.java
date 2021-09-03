package file;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class FileUploadServlet
 */
@WebServlet("/upload.do")
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileUploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String encoding  = "utf-8";
		//파일 업로드할 기본 폴더 c:\\fileupload\\ 해당 폴더에 업로드
		String root = "c:\\fileupload\\";
		File userRoot = new File(root);
		if(!userRoot.exists())
			userRoot.mkdirs();
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(userRoot);//업로드될 폴더 설정
		factory.setSizeThreshold(1024*1024);//버퍼 메모리
		
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		try {
			List<FileItem> list = upload.parseRequest(request);
			ArrayList<FileDTO> flist = new ArrayList<FileDTO>();
			String user = "default";
			for(int i=0;i<list.size();i++) {
				FileItem item = list.get(i);
				//받은 내용 중에 파일이 아니고 type="text,password....." 인경우
				if(item.isFormField()) {
					if(item.getFieldName().equals("writer"))
						user = item.getString(encoding);
					System.out.println(item.getFieldName() + " : " + item.getString(encoding));
				}else {
					//받은 내용이 파일인 경우
					System.out.println("매개변수 명 : "+item.getFieldName());
					System.out.println("파일명 : "+item.getName());
					System.out.println("파일 크기 : "+item.getSize());
					System.out.println("파일 타입 : "+item.getContentType());
					if(item.getSize() > 0) {
						int idx = item.getName().lastIndexOf("\\");
						if(idx==-1)
							idx = item.getName().lastIndexOf("/");
						String fileName = item.getName().substring(idx+1);
						//파일 경로 완성
						File uploadFile = new File(root+"\\"+fileName);
						if(!uploadFile.getParentFile().exists())
							uploadFile.getParentFile().mkdirs();
						System.out.println("셋팅된 파일 전체 경로 : "+uploadFile);
						item.write(uploadFile);//실제로 원하는 위치에 파일 쓰기
						flist.add(new FileDTO(uploadFile));
					}
				}
			}
			request.setAttribute("file", flist);
			request.setAttribute("user", user);
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("file_result.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
