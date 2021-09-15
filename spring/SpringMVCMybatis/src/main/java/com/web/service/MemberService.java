package com.web.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.web.dto.MemberDTO;
import com.web.mapper.MemberMapper;

@Service
public class MemberService {
	private MemberMapper mapper;

	public MemberService(MemberMapper mapper) {
		super();
		this.mapper = mapper;
	}

	public List<MemberDTO> selectAllMember() {
		return mapper.selectAllMember();
	}
	
	
}
