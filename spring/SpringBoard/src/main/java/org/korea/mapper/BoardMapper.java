package org.korea.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;
import org.korea.dto.BoardDTO;
import org.korea.dto.FileDTO;

@Mapper
public interface BoardMapper {
	ArrayList<BoardDTO> selectBoard(int pageNo);
	int selectBoardNo();
	int insertBoard(BoardDTO dto);
	int insertFileInfo(FileDTO fileDTO);
	BoardDTO selectBoardContent(int bno);
	ArrayList<FileDTO> selectFileList(int bno);
	FileDTO selectFile(int fno);
	int deleteBoard(int bno);
	int updateBoard(HashMap<String, Object> map);
	int selectBoardCount();
	int addBoardCount(int bno);
}




