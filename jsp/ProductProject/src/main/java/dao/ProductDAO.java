package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.DBManager;
import dto.ProductDTO;

public class ProductDAO {
	private static ProductDAO instance = new ProductDAO();

	private ProductDAO() {
		super();
	}

	public static ProductDAO getInstance() {
		if(instance == null)
			instance = new ProductDAO();
		return instance;
	}

	public ArrayList<ProductDTO> selectAllProduct() {
		String sql = "select * from product";
		PreparedStatement pstmt = null;
		ArrayList<ProductDTO> list = new ArrayList<ProductDTO>();
		ResultSet rs = null;
		try {
			pstmt = DBManager.getInstance().getConnection().prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new ProductDTO(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null)
					rs.close();
				if(pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

}






