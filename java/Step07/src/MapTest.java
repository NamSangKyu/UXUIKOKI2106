import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import obj.Person;

public class MapTest {
	/*
	 * 	맵은 키값을 이용해서 데이터를 저장
	 */
	public static void main(String[] args) {
		HashMap<String, Person> map = new HashMap<String, Person>();
		//데이터 추가
		map.put("홍길동", new Person("홍길동", 20));
		map.put("김철수", new Person("김철수", 44));
		map.put("이영희", new Person("이영희", 33));
		map.put("박영수", new Person("박영수", 36));
		map.put("홍길동", new Person("홍길동", 44));
		//데이터 읽기
		System.out.println(map.get("김철수").toString());
		
		//전체 데이터 꺼내기
		Set<String> set = map.keySet();//맵에 있는 모든 키값을 set로 리턴
		Iterator<String> it = set.iterator();
		while(it.hasNext())
			System.out.println(map.get(it.next()));
		
		//맵에 저장된 데이터 개수
		System.out.println(map.size());
		//맵에 해당 키값이 있냐?
		System.out.println(map.containsKey("홍길동"));
		//맵에 해당 값이 있냐?
		System.out.println(map.containsValue(new Person("박영수", 36)));
		//맵에 데이터가 없냐?
		System.out.println(map.isEmpty());
		//맵에 있는 데이터를 비우기
//		map.clear();
		//특정 데이터 지우기
		map.remove("홍길동");//키값도 같이 삭제
		System.out.println(map.containsKey("홍길동"));
		System.err.println(map.get("홍길동"));
		
		System.out.println(map);
		
	}

}





