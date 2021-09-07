package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.DBManager;
import dto.QnaDTO;

public class QnaDAO {
	private static QnaDAO instance = new QnaDAO();
	private DBManager manager;
	private QnaDAO() {
		super();
		manager= DBManager.getInstance();
	}

	public static QnaDAO getInstance() {
		if(instance == null)
			instance = new QnaDAO();
		return instance;
	}

	public ArrayList<QnaDTO> selectQnaList(String id) {
		String sql = "select * from qna where qwriter = ?";
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;
		ArrayList<QnaDTO> list = new ArrayList<QnaDTO>();
		try {
			conn = manager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int qno = rs.getInt(1);
				String qcode = rs.getString(2);
				String qcontent= rs.getString(3);
				String qdate= rs.getString(4);
				String qwriter= rs.getString(5);
				String status= rs.getString(6);
				String acontent= rs.getString(7);
				String awriter= rs.getString(8);
				String adate= rs.getString(9);
				list.add(new QnaDTO(qno, qcode, qcontent, qdate, qwriter, status, acontent, awriter, adate));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			manager.close(conn, pstmt, rs);
		}
		
		return list;
	}
	
}










