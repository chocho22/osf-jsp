package com.osf.test.dao;

import java.util.List;

import com.osf.test.vo.PhotoBoardVO;

public interface PBoardDAO2 {
	public int insertPBoard(PhotoBoardVO pBoard);
	public List<PhotoBoardVO> selectPBoardList();
	public PhotoBoardVO selectPBoard(int pbNum);
}
