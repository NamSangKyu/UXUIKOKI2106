package service;

import java.util.ArrayList;

import vo.EmployeeVO;
//실제 작업을 하는 클래스
public class EmployeeService {
	private ArrayList<EmployeeVO> list;
	
	public EmployeeService() {
		list = new ArrayList<EmployeeVO>();
	}
	//2. 리스트에 보관중인 사원 정보를 전체 출력하는 기능을 만드시오
	public void selectAllEmployee() {
		//리스트에 데이터가 있나? 확인
		if(list.isEmpty()) {
			System.out.println("데이터가 하나도 없습니다.");
			return;
		}
		//리스트에 있는 내용 출력
		for(int i=0;i<list.size();i++)
			list.get(i).printEmployeeInfo();
	}
	//3. 사원정보를 추가하는 기능을 만드시오
	
	//4. 사원정보를 삭제하는 기능을 만드시오
	//5. 전체 사원정보 중 연봉정보가 3000이상인 사람들을 조회하여 출력하시오
}









