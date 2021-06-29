package set;

import java.util.HashSet;
import java.util.Iterator;

public class SetTest {
	/*
	 *  set의 특징
	 *  	1. 중복 X
	 *  	2. 자동 정렬
	 */
	public static void main(String[] args) {
		HashSet<Integer> set1 = new HashSet<Integer>();
		//데이터 추가
		set1.add(1);
		set1.add(10);
		set1.add(11);
		set1.add(4);
		set1.add(5);
		set1.add(1);
		set1.add(1);
		set1.add(1);
		//데이터 전체 조회
		Iterator<Integer> it = set1.iterator();//it이 맨처음을 나타냄(header)
		//다음위치에 데이터가 있냐?
		while(it.hasNext()) {
			//다음 위치로 이동 후에 해당 데이터 리턴
			System.out.println(it.next());
		}
	}

}








