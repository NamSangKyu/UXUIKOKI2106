package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import config.DBManager;
import dto.MemberDTO;

class TestMember {
	static SqlSession session;
	//모든 테스트가 시작전에 실행
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		//테스트용 데이터 읽기
		//1. JSON 파일 읽기
		FileReader file = new FileReader("member.json");
		BufferedReader br = new BufferedReader(file);
		String txt = new String();
		
		while(true) {
			String temp = br.readLine();
			if(temp == null) break;
			txt += temp;
		}
		//System.out.println(txt);
		JSONArray array = new JSONArray(txt);
		//2. 읽은 내용을 ArrayList<MemberDTO>에 저장
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		for(int i=0;i<array.length();i++) {
				JSONObject j = array.getJSONObject(i);
				System.out.println(j);
				String id = j.getString("id");
				String passwd = j.getString("passwd");
				String name = j.getString("name");
				int age = j.getInt("age");
				String grade = j.getString("grade");
				String gender = j.getString("gender");
				int point = j.getInt("point");
				list.add(new MemberDTO(id, passwd, name, age, gender, point, grade));
				
		}
		//세션 획득
		session = DBManager.getInstance().getSession();
		//3.데이터 추가 - DB에 추가
		for(int i=0;i<list.size();i++)
			session.insert("insertMember", list.get(i));
	}

	//모든 테스트가 끝난후 실행
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		//테스트 끝나면 롤백
		session.rollback();
	}

	@Test
	@DisplayName("포인트 업데이트 테스트")
	void updatePoint() {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("point", 1000000);
		map.put("id", "A0005");
		assertEquals(session.update("updatePoint", map),1,"포인트 업데이트 실패");
	}
	@Test
	@DisplayName("회원 삭제 테스트")
	void deletePoint() {
		String id = "A0006";
		assertEquals(session.delete("deleteMember",id), 1);
	}
	
	@Test
	@DisplayName("회원 조회 테스트")
	void selectMember() {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("search", "A0004");
		map.put("kind", "id");
		
		MemberDTO dto = session.selectOne("selectMember",map);
		//System.out.println(dto);
		assertNotNull(dto, "조회 결과가 없습니다.");
	}
}






