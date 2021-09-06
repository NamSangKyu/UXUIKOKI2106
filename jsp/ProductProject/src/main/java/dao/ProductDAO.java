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

	public int insertProduct(ProductDTO dto) {
		String sql = "insert into product values(?,?,?,?)";
		PreparedStatement pstmt = null;
		int count = 0;
		try {
			pstmt = DBManager.getInstance().getConnection().prepareStatement(sql);
			pstmt.setString(1, dto.getPno());
			pstmt.setString(2, dto.getPname());
			pstmt.setInt(3, dto.getPrice());
			pstmt.setString(4, dto.getMaker());
			count = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	}

	public void deleteProduct(String pno) {
		String sql = "delete from product where pno = ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = DBManager.getInstance().getConnection().prepareStatement(sql);
			pstmt.setString(1, pno);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}






