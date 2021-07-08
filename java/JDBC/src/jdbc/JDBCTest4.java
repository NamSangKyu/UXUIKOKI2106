package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCTest4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("조회할 포인트 기준값 입력 : ");
		String grade = sc.nextLine();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager
					.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe",
					"scott", "tiger"); 
			String sql = "select * from member where grade like ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, grade);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				System.out.println( rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3)
				+ " " + rs.getInt(4) + " " + rs.getString(5) + " " + rs.getInt(6) + " " + rs.getString(7));
			}
				
			rs.close();
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
