package org.student.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.student.dto.StudentDTO;

@Mapper
public interface StudentMapper {
	List<StudentDTO> selectStudent(Map<String, Object> map);
	List<StudentDTO> selectAllStudent();
	int insertLog(HashMap<String, Object> map);
}
