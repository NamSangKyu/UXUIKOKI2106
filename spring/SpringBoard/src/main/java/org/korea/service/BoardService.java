package org.korea.service;

import java.util.ArrayList;

import org.apache.ibatis.javassist.tools.framedump;
import org.korea.dto.BoardDTO;
import org.korea.dto.FileDTO;
import org.korea.mapper.BoardMapper;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
	private BoardMapper mapper;

	public BoardService(BoardMapper mapper) {
		super();
		this.mapper = mapper;
	}

	public ArrayList<BoardDTO> selectBoard(int pageNo) {
		return mapper.selectBoard(pageNo);
	}

	public int insertBoard(BoardDTO dto) {
		int bno = mapper.selectBoardNo();
		dto.setBno(bno);
		mapper.insertBoard(dto);
		return bno;
	}

	public void insertFileList(ArrayList<FileDTO> flist) {
		for(int i=0;i<flist.size();i++) {
			mapper.insertFileInfo(flist.get(i));
		}
	}

	public BoardDTO selectBoardContent(int bno) {
		return mapper.selectBoardContent(bno);
	}

	public ArrayList<FileDTO> selectFileList(int bno) {
		return mapper.selectFileList(bno);
	}

	public FileDTO selectFile(int fno) {
		return mapper.selectFile(fno);
	}

	public void deleteBoard(int bno) {
		mapper.deleteBoard(bno);
	}
	
}





