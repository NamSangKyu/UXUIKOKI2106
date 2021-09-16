package org.korea.service;

import org.korea.mapper.BoardMapper;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
	private BoardMapper mapper;

	public BoardService(BoardMapper mapper) {
		super();
		this.mapper = mapper;
	}
	
}
