package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.json.JSONArray;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import config.DBManager;
import dto.ProductDTO;
import mapper.ProductMapper;

class TestProduct {
	static SqlSession session; 
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		FileReader fr = new FileReader("product.json");
		BufferedReader br = new BufferedReader(fr);
		String jsonData = "";
		session = DBManager.getInstance().getSession();
		while(true) {
			String temp = br.readLine();
			if(temp == null)  break;
			jsonData += temp;
		}
		JSONArray j = new JSONArray(jsonData);
		
		for(int i=0;i<j.length();i++) {
			String productNo = j.getJSONObject(i).getString("product_no");
			String productName = j.getJSONObject(i).getString("product_name");
			String maker = j.getJSONObject(i).getString("maker");
			int ea = j.getJSONObject(i).getInt("ea");
			int price= j.getJSONObject(i).getInt("price");
			session.insert("insertProduct",
					new ProductDTO(productNo, productName, price, ea, maker));
		}
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		session.rollback();
	}


	@Test
	@DisplayName("제품정보 검색 테스트")
	void test() {
		Map<String, Object> map = session.selectOne("selectProduct", "89451111152");
		//assertNotNull(map, "오류, 검색결과가 없습니다. SQL문을 확인해 보세요");
		if(map == null)
			fail("오류, 검색결과가 없습니다. SQL문을 확인해 보세요");
	}

}







