package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.DBManager;
import dto.BoardDTO;

public class BoardDAO {
	private static BoardDAO instance = new BoardDAO();
	private Connection conn;

	private BoardDAO() {
		super();
		conn = DBManager.getInstance().getConnection();
	}

	public static BoardDAO getInstance() {
		if (instance == null)
			instance = new BoardDAO();
		return instance;
	}

	public void insertBoard(BoardDTO dto) {
		String sql = "insert into board(bno, title, content, writer, bdate,bcount)"
				+ " values(board_no.nextval, ?,?,?,sysdate,0)";
		// DB 처리
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContent());
			pstmt.setString(3, dto.getWriter());
			int count = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public ArrayList<BoardDTO> selectAllBoard(String order, int currentPageNo) {
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		order = order == null  || order.equals("")? "bno" : order;
		String sql = "select * from (select b.*, ceil(rownum / 5) as pageno from "
				+ "(select * from board_list order by "+order+" desc) b) where pageno = ?";
		System.out.println(sql);
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, currentPageNo);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				list.add(new BoardDTO(rs.getInt(1), rs.getString(2), rs.getString(5), rs.getString(3), rs.getString(4),
						rs.getInt(7), rs.getInt(8), rs.getInt(6)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return list;
	}

	public BoardDTO selectBoard(int bno) {
		String sql = "select b.bno, b.title, b.writer, b.bdate, b.content, b.bcount, "
				+ "(select count(*) from BOARD_LIKE bl where b.bno = bl.bno) as blike, "
				+ "(select count(*) from BOARD_hate bh where b.bno = bh.bno) as bhate "
				+ "from board b where b.bno = ? order by bno desc";
		BoardDTO dto = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new BoardDTO(rs.getInt(1), rs.getString(2), rs.getString(5), rs.getString(3), rs.getString(4),
						rs.getInt(7), rs.getInt(8), rs.getInt(6));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return dto;
	}

	public void addBoardCount(int bno) {
		PreparedStatement pstmt = null;
		String sql = "update board set bcount = bcount + 1 where bno = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void deleteBoard(int bno) {
		PreparedStatement pstmt = null;
		String sql = "delete from board where bno = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	public void updateBoard(int bno, String title, String content) throws Exception {
		PreparedStatement pstmt = null;
		String sql = "update board set title=?,content=? where bno = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, bno);
			int count = pstmt.executeUpdate();
			if(count == 0)
				throw new Exception("수정할 게시글이 없습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public int insertBoardLike(int bno, String id) {
		String sql = "insert into board_like values(?,?)";
		PreparedStatement pstmt = null;
		int count = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			pstmt.setString(2, id);
			count = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	}
	public int deleteBoardLike(int bno, String id) {
		String sql = "delete from board_like where bno = ? and id like ?";
		PreparedStatement pstmt = null;
		int count = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			pstmt.setString(2, id);
			count = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	}

	public int insertBoardHate(int bno, String id) {
		String sql = "insert into board_hate values(?,?)";
		PreparedStatement pstmt = null;
		int count = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			pstmt.setString(2, id);
			count = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	}
	public int deleteBoardHate(int bno, String id) {
		String sql = "delete from board_hate where bno = ? and id like ?";
		PreparedStatement pstmt = null;
		int count = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			pstmt.setString(2, id);
			count = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	}

	public int selectBoardCount() {
		String sql = "select count(*) from board_list";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next())
				count = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	}
}






