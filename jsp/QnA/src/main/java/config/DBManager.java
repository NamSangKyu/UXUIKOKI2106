package config;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBManager {
	private static DBManager instance = new DBManager();
	private DataSource source;
	
	private DBManager() {
		Context context;
		
		try {
			context = new InitialContext();
			source = (DataSource) context.lookup("java:/comp/env/myoracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	public Connection getConnection() throws SQLException {
		return source.getConnection();
	}
	public static DBManager getInstance() {
		if(instance == null)
			instance = new DBManager();
		return instance;
	}
}
