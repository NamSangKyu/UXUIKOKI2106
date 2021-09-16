package org.korea.service;

import java.util.HashMap;

import org.korea.dto.MemberDTO;
import org.korea.mapper.MemberMapper;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	private MemberMapper mapper;

	public MemberService(MemberMapper mapper) {
		this.mapper = mapper;
	}

	public MemberDTO login(String id, String pass) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("pass", pass);
		return mapper.login(map);
	}
	
	
}




