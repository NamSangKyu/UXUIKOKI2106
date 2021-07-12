package dao;

import java.sql.Connection;

import config.DBManager;

public class StudentDAO {
	private static StudentDAO instance = new StudentDAO();
	
	private Connection conn;
	
	private StudentDAO() {
		conn = DBManager.getInstance().getConn();
	}

	public static StudentDAO getInstance() {
		if(instance == null)
			instance = new StudentDAO();
		return instance;
	}

	
}
