package list;

import java.util.ArrayList;
import java.util.Iterator;

public class ListTest {
	/*
	 * 리스트는 데이터를 조회하거나 추가 삭제하는 용도
	 * 		1. 데이터가 중복 허용
	 * 		2. 사용자가 추가한 순서를 보장
	 * 
	 */
	public static void main(String[] args) {
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		//데이터 5개 추가
		list1.add(10);
		list1.add(11);
		list1.add(13);
		list1.add(10);
		list1.add(20);
		list1.add(22);
		//리스트에 있는 모든 데이터 출력 - 1
		Iterator<Integer> it = list1.iterator();
		while(it.hasNext()) {
			System.out.print(it.next() + " ");
		}
		System.out.println();
		//리스트에 있는 모든 데이터 출력 - 2
		for(int i=0;i<list1.size();i++) {
			System.out.print(list1.get(i) + " ");
		}
		System.out.println();
		//리스트에 저장된 데이터 확인
		System.out.println(list1);
		
		//데이터 있는지 확인
		System.err.println(list1.contains(10));
		//해당 데이터가 몇번 인덱스에 있는지 확인
		System.out.println(list1.indexOf(11));
		//검색 결과가 없으면 -1
		System.out.println(list1.indexOf(113));
		//숫자를 넣으면 인덱스 번호로 삭제
		System.out.println(list1.remove((Integer)11));
		System.out.println(list1);
		
		
		
	}

}










