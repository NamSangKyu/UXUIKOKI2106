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
		System.out.println("-----------");
		//set 안에 해당 데이터가 있는가?
		System.out.println(set1.contains(15));
		System.out.println(set1.contains(5));
		//set이 비어있는가?(set에 데이터가 하나도 없냐?)
		System.out.println(set1.isEmpty());
//		set1.clear();//set에 내용을 전부 비우겠다.
//		System.out.println(set1.isEmpty());
		//set에 해당 데이터 삭제
		System.out.println(set1.remove(5));
		//현재 set에 저장된 데이터 개수 리턴
		System.out.println(set1.size());
		//전체 set 내용을 출력
		System.out.println(set1);
	}

}








