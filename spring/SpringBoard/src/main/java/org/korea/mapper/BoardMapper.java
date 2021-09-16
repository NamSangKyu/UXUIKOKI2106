package org.korea.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.korea.dto.BoardDTO;

@Mapper
public interface BoardMapper {

	ArrayList<BoardDTO> selectBoard(int pageNo);

}
