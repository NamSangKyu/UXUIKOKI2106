package org.korea.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.korea.dto.BoardDTO;
import org.korea.dto.FileDTO;

@Mapper
public interface BoardMapper {
	ArrayList<BoardDTO> selectBoard(int pageNo);
	int selectBoardNo();
	void insertBoard(BoardDTO dto);
	void insertFileInfo(FileDTO fileDTO);
}
