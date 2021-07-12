package jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.OracleTypes;

public class ProcedureCallObject {

	public static void main(String[] args) {
		Connection conn = DBManager.getInstance().getConn();
		
		String sql = "call GET_MAJOR_LIST(?)";
		CallableStatement stmt = null;
		try {
			stmt = conn.prepareCall(sql);
			stmt.registerOutParameter(1, OracleTypes.CURSOR);
			stmt.execute();
			ResultSet rs = (ResultSet) stmt.getObject(1);
			while(rs.next()) {
				System.out.println(rs.getString(1) + " " +rs.getString(2));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}






