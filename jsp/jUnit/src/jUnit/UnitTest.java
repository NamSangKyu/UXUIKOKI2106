package jUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
	void test() {
		System.out.println("테스트 메서드 수행");
		fail("테스트 실패 하였습니다.");
	}

}
