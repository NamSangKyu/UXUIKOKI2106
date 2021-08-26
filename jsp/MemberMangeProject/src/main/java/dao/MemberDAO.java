package dao;

import java.sql.PreparedStatement;
import java.sql.PseudoColumnUsage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.DBManager;
import dto.MemberDTO;

public class MemberDAO {
	private static MemberDAO instance = new MemberDAO();

	private DBManager manager;

	private MemberDAO() {
		manager = DBManager.getInstance();
	}

	public static MemberDAO getInstance() {
		if (instance == null)
			instance = new MemberDAO();
		return instance;
	}

	public MemberDTO login(String id, String pass) {
		MemberDTO dto = null;

		try {
			String sql = "select * from member where id = ? and passwd = ?";
			PreparedStatement pstmt = manager.getConnection().prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				String name = rs.getString(3);
				int age = rs.getInt(4);
				String gender = rs.getString(5);
				int point = rs.getInt(6);
				String grade = rs.getString(7);

				dto = new MemberDTO(id, pass, name, age, gender, point, grade);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return dto;
	}

	public ArrayList<MemberDTO> selectAllMember() {
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();

		try {
			String sql = "select * from member";
			PreparedStatement pstmt = manager.getConnection().prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString(1);
				String name = rs.getString(3);
				int age = rs.getInt(4);
				String gender = rs.getString(5);
				int point = rs.getInt(6);
				String grade = rs.getString(7);
				list.add(new MemberDTO(id, null, name, age, gender, point, grade));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public int insertMember(MemberDTO dto) {
		String sql = "insert into member(id,passwd,name,age,gender) values(?,?,?,?,?)";
		int result = 0;
		PreparedStatement pstmt = null;
		try {
			pstmt = manager.getConnection().prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPass());
			pstmt.setString(3, dto.getName());
			pstmt.setInt(4, dto.getAge());
			pstmt.setString(5, dto.getGender());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

}
