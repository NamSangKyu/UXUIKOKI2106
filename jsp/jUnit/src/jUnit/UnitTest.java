package jUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

//해당 어노테이션이 있어야 Order가 됨
@TestMethodOrder(OrderAnnotation.class)
class UnitTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("테스트 수행전 맨처음 한번 수행되는 메서드");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("테스트 수행 후 맨 마지막에서 한번 수행되는 메서드");
	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("테스트 메서드 수행전에 실행되는 메서드");
		
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("테스트 메서드 수행 후에 실행되는 메서드");
		
	}
	@Test
	@Order(4)
	void test() {
		System.out.println("테스트 메서드 수행");
		//fail("테스트 실패 하였습니다.");
	}
	@Test
	@DisplayName("사각형 넓이 테스트")
	@Order(3)
	void rectAreaTest() {
		//마지막 인수는 에러 발생시 메서드
		assertSame(TestService.getInstance().rectArea(3, 5), 3*5,"사각형 넓이 구하는 메서드 테스트 실패");
		
	}
	
	@Test
	@DisplayName("두개 숫자 비교")
	@Order(2)
	void equalNumber() {
		//비교할 두개의 값
		assertEquals(TestService.getInstance().rectArea(3, 5), 3*5,"사각형 넓이 구하는 메서드 테스트 실패");		
	}
	@Test
	@Order(1)
	@DisplayName("true js 테스트") 
	void testNumber(){
		//첫번쨰 인수가 true/false일때
		assumeTrue(true,"결과가 거짓이 나왔습니다");
	}
}







