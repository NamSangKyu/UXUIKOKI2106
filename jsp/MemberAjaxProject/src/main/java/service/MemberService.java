package service;

import java.util.List;

import dto.MemberDTO;
import mapper.MemberMapper;

public class MemberService {
	private static MemberService instance = new MemberService();

	public MemberService() {
	}

	public static MemberService getInstance() {
		if(instance == null)
			instance = new MemberService();
		return instance;
	}

	public List<MemberDTO> selectAllMember() {
		return MemberMapper.getInstance().selectAllMember();
	}

	public void insertMember(MemberDTO dto) {
		MemberMapper.getInstance().insertMember(dto);		
	}

	public void deleteMember(String id) {
		MemberMapper.getInstance().deleteMember(id);
	}

	public void updatetMember(MemberDTO dto) {
		MemberMapper.getInstance().updateMember(dto);
	}

	public List<MemberDTO> search(String kind, String search) {
		return MemberMapper.getInstance().selectMember(kind,search);
	}
	
	
}







