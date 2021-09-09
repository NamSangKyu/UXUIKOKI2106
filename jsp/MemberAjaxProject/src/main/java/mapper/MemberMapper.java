package mapper;

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
}



