package service;

import dao.ProfessorDAO;

public class ProfessorService {
	private static ProfessorService instance = new ProfessorService();
	private ProfessorDAO dao;
	private ProfessorService() {
		dao = ProfessorDAO.getInstance();
	}
	public static ProfessorService getInstance() {
		if(instance == null)
			instance = new ProfessorService();
		return instance;
	}
	public boolean login(String no, String name) {
		return dao.login(no,name);
	}
	
	
}
