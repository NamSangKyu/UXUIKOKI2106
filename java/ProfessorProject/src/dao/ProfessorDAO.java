package dao;

import java.sql.Connection;

import db.DBManager;

public class ProfessorDAO {
	private static ProfessorDAO instance = new ProfessorDAO();
	private Connection conn;
	private ProfessorDAO() {
		conn = DBManager.getInstance().getConn();
	}
	public static ProfessorDAO getInstance() {
		if(instance == null)
			instance = new ProfessorDAO();
		return instance;
	}
	public boolean login(String no, String name) {
		return false;
	}
	
}





