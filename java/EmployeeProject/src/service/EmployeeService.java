package service;

import java.util.ArrayList;
import java.util.Scanner;

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
	public void insertEmployee(Scanner sc) {
		//1. 사원 정보 입력
		System.out.println("사원정보 등록을 시작합니다.......");
		System.out.println("사번 : ");
		String employeeNo = sc.nextLine();
		System.out.println("이름 : ");
		String name = sc.nextLine();
		System.out.println("부서 : ");
		String major= sc.nextLine();
		System.out.println("직급 : ");
		String position= sc.nextLine();
		System.out.println("연봉 : ");
		int salary = sc.nextInt();
		sc.nextLine();
		//2. 리스트에 추가
		list.add(new EmployeeVO(employeeNo, name, position, position, salary));
	}
	//4. 사원정보를 삭제하는 기능을 만드시오
	public void deleteEmployee(Scanner sc) {
		//1. 삭제할 사번 입력
		System.out.println("사원정보 삭제 시작합니다.......");
		System.out.println("삭제할 사번 : ");
		String employeeNo = sc.nextLine();
		//2. 검색 해서 삭제
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getEmployeeNo().equals(employeeNo)) {
				list.remove(i);
				System.out.println("사원정보 삭제 완료");
				return;
			}
		}
		System.out.println("삭제할 사원 정보가 없습니다.");
		
	}
	//5. 전체 사원정보 중 연봉정보가 3000이상인 사람들을 조회하여 출력하시오
}









