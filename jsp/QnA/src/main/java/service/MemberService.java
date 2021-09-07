package service;

import dao.MemberDAO;
import dto.MemberDTO;

public class MemberService {
	private static MemberService instance = new MemberService();

	private MemberService() {
		super();
	}

	public static MemberService getInstance() {
		if(instance == null)
			instance = new MemberService();
		return instance;
	}

	public MemberDTO login(String id, String pass) {
		return MemberDAO.getInstance().login(id,pass);
	}
	
	
	
}
