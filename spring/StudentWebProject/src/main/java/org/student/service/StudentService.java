package org.student.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;
import org.student.dto.StudentDTO;
import org.student.mapper.StudentMapper;

@Service
public class StudentService {
	StudentMapper mapper;

	public StudentService(StudentMapper mapper) {
		this.mapper = mapper;
	}

	public List<StudentDTO> selectStudent(String kind, String search) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("kind", kind);
		map.put("search", search);
		return mapper.selectStudent(map);
	}

	public List<StudentDTO> selectAllStudent() {
		return mapper.selectAllStudent();
	}

	public void insertLog(String code, String date, String content) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("code", code);
		map.put("content", content);
		map.put("date", date);
		
		mapper.insertLog(map);
	}
	
}






