package org.korea.service;

import org.korea.MainController;
import org.korea.dao.MemberDAO;
import org.korea.dto.MemberDTO;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	private MemberDAO dao;

	public MemberService(MemberDAO dao) {
		this.dao = dao;
	}

	public MemberDTO login(String id, String pass) {
		return dao.login(id,pass);
	}
}
