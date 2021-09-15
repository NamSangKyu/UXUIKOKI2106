package org.korea.service;

import java.util.ArrayList;

import org.korea.dao.MemberDAO;
import org.korea.dto.MemberDTO;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	private MemberDAO dao;
	
	//DIContainer에 Bean으로 등록되어있으면 자동으로 역주입
	public MemberService(MemberDAO dao) {
		this.dao = dao;
	}

	public MemberDTO login(String id, String pass) {
		return dao.login(id,pass);
	}

	public ArrayList<MemberDTO> selectAllMember() {
		return dao.selectAllMember();
	}
}
