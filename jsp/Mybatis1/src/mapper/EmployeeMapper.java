package mapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import dto.EmployeeDTO;

public class EmployeeMapper {
	private SqlSessionFactory factory;
	private SqlSession session;
	public EmployeeMapper() {
		String resource = "config/mybatis-config.xml";
		
		InputStream inputStream;
		
		try {
			inputStream = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(inputStream);
			session = factory.openSession(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	
	public List<EmployeeDTO> selectAllEmployeeDTO(){
		List<EmployeeDTO> list = session.selectList("config.sqlmapper.selectAllEmployee");
		return list;
	}
	
}




