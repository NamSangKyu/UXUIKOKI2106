package service;

import java.util.ArrayList;

import dao.QnaDAO;
import dto.FileDTO;
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

	public int insertQna(QnaDTO dto) {
		//문의글 번호 받음
		int qno = QnaDAO.getInstance().getQno();
		//문의글 등록
		dto.setQno(qno);
		int result = QnaDAO.getInstance().insertQna(dto);
		return result == 0 ? 0 : qno;
	}

	public void insertFile(QnaDTO dto, ArrayList<FileDTO> flist) {
		QnaDAO.getInstance().insertFile(dto,flist);
	}

	public QnaDTO selectQna(int qno) {
		return QnaDAO.getInstance().selectQna(qno);
	}
	
}





