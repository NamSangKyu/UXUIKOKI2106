package org.korea.service;

import java.util.ArrayList;

import org.korea.dto.BoardDTO;
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
	
}
