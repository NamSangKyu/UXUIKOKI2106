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
	public MemberDTO selectMember(String id) {
		MemberDTO dto = MemberDAO.getInstance().selectMember(id);
		return dto;
	}
	
	public ArrayList<MemberDTO> selectAllMember(){
		return MemberDAO.getInstance().selectAllMember();
	}
	public ArrayList<MemberDTO> searchMember(String kind,String search){
		return MemberDAO.getInstance().searchMember(kind,search);
	}
	
	public int insertMember(MemberDTO dto) {
		return MemberDAO.getInstance().insertMember(dto);
	}
	public int updateMember(MemberDTO dto) {
		return MemberDAO.getInstance().updateMember(dto);
	}
	
	public void deleteMember(String id) {
		MemberDAO.getInstance().deleteMember(id);
	}
}






