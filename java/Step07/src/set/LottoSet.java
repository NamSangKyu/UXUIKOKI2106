package set;

import java.util.Random;
import java.util.TreeSet;

public class LottoSet {

	public static void main(String[] args) {
		/*
		 * 로또번호 생성을 배열에서 TreeSet으로 바꾸어서 작업
		 */
		TreeSet<Integer> set = new TreeSet<Integer>();
		Random r = new Random();
		
		while(set.size()<7)
			set.add(r.nextInt(45)+1);
		
		System.out.println(set);
	}

}









