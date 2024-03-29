package mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import config.DBManager;
import dto.MemberDTO;

public class MemberMapper {
	private static MemberMapper instance = new MemberMapper();
	private DBManager manager;
	public MemberMapper() {
		manager = DBManager.getInstance();
	}

	public static MemberMapper getInstance() {
		if(instance == null)
			instance = new MemberMapper();
		return instance;
	}

	public List<MemberDTO> selectAllMember() {
		SqlSession session = manager.getSession();
		List<MemberDTO> list = session.selectList("selectAllMember");
		session.close();
		return list;
	}

	public void insertMember(MemberDTO dto) {
		SqlSession session = manager.getSession();
		session.insert("insertMember",dto);
		session.commit();
		session.close();		
	}

	public void deleteMember(String id) {
		SqlSession session = manager.getSession();
		session.delete("deleteMember",id);
		session.commit();
		session.close();		
		
	}

	public void updateMember(MemberDTO dto) {
		SqlSession session = manager.getSession();
		session.update("updateMember",dto);
		session.commit();
		session.close();		
	}

	public List<MemberDTO> selectMember(String kind, String search) {
		SqlSession session = manager.getSession();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("kind", kind);
		map.put("search", search);
		List<MemberDTO> list = session.selectList("selectMember",map);
		return list;
	}
}








