package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCTest2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("조회할 회원 등급 입력 : ");
		String grade = sc.nextLine();
		try {
			//1. Driver Load
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2. DB Connect
			Connection conn = DriverManager
					.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe",
					"scott", "tiger"); 
			//3. create SQL
			String sql = "select * from member where grade like '"+grade + "'";
			System.out.println(sql);
			//4. create Statement
			Statement stmt = conn.createStatement();
			//5. SQL Run
			ResultSet rs = stmt.executeQuery(sql);
			//	5-1. ResultSet 데이터 조회
			while(rs.next()) {
				//System.out.println(rs.getString("id") + " " + rs.getString(3));
				System.out.println( rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3)
				+ " " + rs.getInt(4) + " " + rs.getString(5) + " " + rs.getInt(6) + " " + rs.getString(7));
			}
				
			//6. close
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
