package controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.QnaService;
import view.ModelAndView;

public class FileDownloadController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int fno = Integer.parseInt(request.getParameter("fno"));
		String path = QnaService.getInstance().getFilePath(fno);
		File file = new File(path);
		String fileName = file.getName();
		FileInputStream fis = new FileInputStream(file);
		String encodingName=URLEncoder.encode(path,"utf-8");
		fileName = URLEncoder.encode(fileName,"utf-8");
		System.out.println(fileName);
		System.out.println(path);
		System.out.println(request.getParameter("path"));
		response.setHeader("Content-Disposition", "attachement;fileName="+fileName);
		response.setHeader("Content-Transfer-Encoding", "binary");
		response.setContentLength((int)file.length());
		
		BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
		byte[] buffer = new byte[1024*1024];
		
		while(true) {
			int size = fis.read(buffer);
			if(size == -1) break;
			bos.write(buffer,0,size);
			bos.flush();
		}
		fis.close();
		bos.close();
		
		return null;
	}

}
