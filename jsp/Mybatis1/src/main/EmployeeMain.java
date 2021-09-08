package main;

import java.util.List;

import dto.EmployeeDTO;
import mapper.EmployeeMapper;

public class EmployeeMain {

	public static void main(String[] args) {
		EmployeeMapper mapper = new EmployeeMapper();
		/*
		List<EmployeeDTO> list = mapper.selectAllEmployeeDTO();
		
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i).getEno() + " "+list.get(i).getName()
					+ " "+list.get(i).getPosition()+ " "+list.get(i).getDepartment());
		}
		*/
		/*
		 * EmployeeDTO dto = mapper.selectEmployeeDTO("JE10");
		 * System.out.println(dto.getName() + " " + dto.getDepartment());
		 */
		
		EmployeeDTO dto = new EmployeeDTO("AA22", "테스트", "영업", 4);
		int result = mapper.insertEmployee(dto);
		System.out.println(result);
		
	}

}







