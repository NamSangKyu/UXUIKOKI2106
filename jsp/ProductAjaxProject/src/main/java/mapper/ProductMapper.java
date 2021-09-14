package mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import config.DBManager;
import dto.ProductDTO;

public class ProductMapper {
	private static ProductMapper instance = new ProductMapper();
	private DBManager manager;
	public ProductMapper() {
		manager = DBManager.getInstance();
	}

	public static ProductMapper getInstance() {
		if(instance == null)
			instance = new ProductMapper();
		return instance;
	}

	public int insertProduct(ProductDTO dto) {
		SqlSession session = manager.getSession();
		int count = session.insert("insertProduct",dto);
		if(count == 1)
			session.commit();
		else
			session.rollback();
		session.close();
		return count;
	}
	public List<Map<String, Object>> selectAllProduct(){
		SqlSession session = manager.getSession();
		List<Map<String, Object>> list = session.selectList("selectAllProduct");
		return list;
	}
	
}








