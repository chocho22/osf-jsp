package com.osf.test.service;

import java.util.List;

import com.osf.test.vo.PhotoBoardVO;

public interface PBoardService2 {
	public int insertPBoard(PhotoBoardVO pBoard);
	public List<PhotoBoardVO> selectPBoardList();
	public PhotoBoardVO selectPBoard(int pbNum);
}
