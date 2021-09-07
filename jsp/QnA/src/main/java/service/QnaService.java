package service;

import java.util.ArrayList;

import dao.QnaDAO;
import dto.QnaDTO;

public class QnaService {
	private static QnaService instance = new QnaService();

	private QnaService() {
		super();
	}

	public static QnaService getInstance() {
		if(instance == null)
			instance = new QnaService();
		return instance;
	}

	public ArrayList<QnaDTO> selectQnaList(String id) {
		return QnaDAO.getInstance().selectQnaList(id);
	}
	
}






