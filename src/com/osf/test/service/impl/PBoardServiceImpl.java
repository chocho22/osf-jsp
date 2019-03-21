package com.osf.test.service.impl;

import java.util.List;
import java.util.Map;

import com.osf.test.dao.PBoardDAO;
import com.osf.test.dao.impl.PBoardDAOImpl;
import com.osf.test.service.PBoardService;

public class PBoardServiceImpl implements PBoardService {
	private PBoardDAO pbdao = new PBoardDAOImpl();
	
	@Override
	public int insertPBoard(Map<String, String> pBoard) {
		return pbdao.insertPBoard(pBoard);
		
	}

	@Override
	public List<Map<String, String>> selectPBoardList() {
		return pbdao.selectPBoardList();
	}

	@Override
	public Map<String, String> selectPBoard(int pbNum) {
		return pbdao.selectPBoard(pbNum);
	}
}
