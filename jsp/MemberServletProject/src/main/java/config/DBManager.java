package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//싱글톤 적용
//생성자 DB 연결
public class DBManager {
	private static DBManager instance = new DBManager();
	
	private Connection connection;	

	private DBManager() {
		try {
			Class.forName(DBConfig.DB_DRIVER);
			connection = DriverManager.getConnection(DBConfig.DB_URL, 
					DBConfig.DB_USER, DBConfig.DB_PASS);
	//		System.out.println("DB 접속 완료");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return connection;
	}

	public static DBManager getInstance() {
		if(instance == null)
			instance = new DBManager();
		return instance;
	}
	/*
	 * public static void main(String[] arg) {
	 * DBManager.getInstance().getConnection(); }
	 */
	
}





