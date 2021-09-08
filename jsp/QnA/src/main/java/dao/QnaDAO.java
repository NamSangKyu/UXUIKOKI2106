package dao;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.DBManager;
import dto.FileDTO;
import dto.QnaDTO;
import oracle.net.aso.f;

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

	public int getQno() {
		String sql = "select qna_no_seq.nextval from dual";
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;
		int result = 0;
		try {
			conn = manager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next())
				result = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			manager.close(conn, pstmt, rs);
		}
		
		return result;
	}


	public int insertQna(QnaDTO dto) {
		String sql = "insert into qna(qno,qcode,qcontent,qdate,qwriter, status) "
				+ "values(?,0,?,sysdate,?,'0')";
		PreparedStatement pstmt = null;
		Connection conn = null;
		int result = 0;
		try {
			conn = manager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getQno());
			pstmt.setString(2, dto.getQcontent());
			pstmt.setString(3, dto.getQwriter());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			manager.close(conn, pstmt, null);
		}
		return result;
	}

	public void insertFile(QnaDTO dto, ArrayList<FileDTO> flist) {
		String sql = "insert into QNA_FILE_LIST(fno,qno,writer,file_url,fdate ) "
				+ "values(file_no_seq.nextval,?,?,?,sysdate)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = manager.getConnection();
			for(int i=0;i<flist.size();i++) {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, dto.getQno());
				String path = flist.get(i).getPath();
				pstmt.setString(2, dto.getQwriter());
				pstmt.setString(3, path);
				pstmt.executeUpdate();
				pstmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	public QnaDTO selectQna(int qno) {
		String sql = "select * from qna where qno = ?";
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;
		QnaDTO dto = null;
		try {
			conn = manager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, qno);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String qcode = rs.getString(2);
				String qcontent= rs.getString(3);
				String qdate= rs.getString(4);
				String qwriter= rs.getString(5);
				String status= rs.getString(6);
				String acontent= rs.getString(7);
				String awriter= rs.getString(8);
				String adate= rs.getString(9);
				dto = new QnaDTO(qno, qcode, qcontent, qdate, qwriter, status, acontent, awriter, adate);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			manager.close(conn, pstmt, rs);
		}
		
		return dto;
	}

	public ArrayList<QnaDTO> selectQnaAllList() {
		String sql = "select * from qna";
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;
		ArrayList<QnaDTO> list = new ArrayList<QnaDTO>();
		try {
			conn = manager.getConnection();
			pstmt = conn.prepareStatement(sql);
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

	public void updateStatus(int qno, int status) {
		String sql = "update qna set status = ? where qno = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = manager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, String.valueOf(status));
			pstmt.setInt(2, qno);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			manager.close(conn, pstmt, null);
		}
		
		
	}

	public void updateQna(QnaDTO dto) {
		String sql = "update qna set acontent=?,adate=sysdate,awriter=?,status=? "
				+ "where qno = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = manager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getAcontent());
			pstmt.setString(2, dto.getAwriter());
			pstmt.setString(3, dto.getStatus());
			pstmt.setInt(4, dto.getQno());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			manager.close(conn, pstmt, null);
		}
	}

	public ArrayList<FileDTO> selectFileList(int qno) {
		ArrayList<FileDTO> list = new ArrayList<FileDTO>();
		String sql = "select file_url, fno from qna_file_list where qno = ?";
		
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;
		
		try {
			conn = manager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, qno);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				FileDTO dto = new FileDTO(new File(rs.getString(1)));
				dto.setFileNo(rs.getInt(2));
				list.add(dto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			manager.close(conn, pstmt, rs);
		}
		
		return list;
	}

	public String getFilePath(int fno) {
		ArrayList<FileDTO> list = new ArrayList<FileDTO>();
		String sql = "select file_url, fno from qna_file_list where fno = ?";
		String path = null;
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;
		
		try {
			conn = manager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fno);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				path = rs.getString(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			manager.close(conn, pstmt, rs);
		}
		
		return path;
	}
	
}










