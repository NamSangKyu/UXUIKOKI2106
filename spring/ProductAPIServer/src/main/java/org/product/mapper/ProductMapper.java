package org.product.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.product.dto.ProductDTO;

@Mapper
public interface ProductMapper {

	List<ProductDTO> searchList(String search);

	int insertLog(HashMap<String, Object> map);

}
