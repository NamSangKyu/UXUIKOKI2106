package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCTest5 {

	public static void main(String[] args) {
		try {
			Connection conn = DBManager.getInstance().getConn();
			String sql = "insert into student values(?,?,?,?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, "20201133");
			stmt.setString(2, "테스트");
			stmt.setInt(3, 4);
			stmt.setDouble(4, 3.5);
			
			int count = stmt.executeUpdate();//insert, update, delete
			System.out.println(count + "건 적용");
			conn.commit();//commit 적용
			
			stmt.close();
			conn.close();
		}  catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
