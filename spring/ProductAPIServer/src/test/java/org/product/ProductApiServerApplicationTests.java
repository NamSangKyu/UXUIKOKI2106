package org.product;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.product.dto.ProductDTO;
import org.product.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//@RunWith(SpringRunner.class)  -- jUnit4 버전일때
@SpringBootTest
class ProductApiServerApplicationTests {

	@Autowired
	ProductMapper mapper;
	

	@Test
	@DisplayName("검색 테스트")
	void searchTest() {
		String search = "Gar";
		List<ProductDTO> list = mapper.searchList(search);
		System.out.println(list.size());
		assertNotEquals(list.size(),0, "검색 결과가 정상적입니다..");
	}

}




