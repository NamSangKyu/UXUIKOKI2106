package vo;
//사원은 사번, 이름, 직급, 부서, 연봉 정보를 가지고 있다.
public class EmployeeVO {
	private String employeeNo;
	private String name;
	private String position;
	private String department;
	private int salary;

	public EmployeeVO(String employeeNo, String name, String position, String department, int salary) {
		this.employeeNo = employeeNo;
		this.name = name;
		this.position = position;
		this.department = department;
		this.salary = salary;
	}
	
	public void printEmployeeInfo() {
		System.out.println(employeeNo + " " + name + " " 
						+ position + " " + department + " " + salary);
	}
	
	
}

	
