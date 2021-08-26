package service;

import java.util.ArrayList;

import dao.MemberDAO;
import dto.MemberDTO;

public class MemberService {
	private static MemberService instance = new MemberService();

	private MemberService() {
	}

	public static MemberService getInstance() {
		if(instance == null)
			instance = new MemberService();
		return instance;
	}

	public MemberDTO login(String id, String pass) {
		MemberDTO dto = MemberDAO.getInstance().login(id,pass);
		return dto;
	}
	
	public ArrayList<MemberDTO> selectAllMember(){
		return MemberDAO.getInstance().selectAllMember();
	}
	
	public int insertMember(MemberDTO dto) {
		return MemberDAO.getInstance().insertMember(dto);
	}
	
}






