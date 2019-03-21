package com.osf.test.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.osf.test.dao.PBoardDAO;
import com.osf.test.db.DBCon;

public class PBoardDAOImpl implements PBoardDAO {
	private static final String INSERT_PBOARD =
			"insert into photo_board(pb_num,pb_title, " +
			" pb_content,pb_credat,pb_cretim, " +
			" pb_file_path,pb_real_path)" +
			" values(seq_pb_num.nextval,?,?, " +
			" to_char(sysdate,'yyyymmdd'), " +
			" to_char(sysdate,'hh24miss'),?,?)";
	
	private static final String SELECT_PBOARD_LIST = 
			"select * from photo_board";
	private static final String SELECT_PBOARD = 
			"select * from photo_board where pb_num=?";		

	@Override
	public int insertPBoard(Map<String, String> pBoard) {
		try {
			PreparedStatement ps = DBCon.getCon().prepareStatement(INSERT_PBOARD);
			ps.setString(1, pBoard.get("pb_title"));
			ps.setString(2, pBoard.get("pb_content"));
			ps.setString(3, pBoard.get("pb_file_path"));
			ps.setString(4, pBoard.get("pb_real_path"));
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCon.close();
		}
		return 0;
	}
	
	public static void main(String[] args) {
		PBoardDAO pbdao = new PBoardDAOImpl();
		System.out.println(pbdao.selectPBoardList());
	}

	@Override
	public List<Map<String, String>> selectPBoardList() {
		try {
			PreparedStatement ps = DBCon.getCon().prepareStatement(SELECT_PBOARD_LIST);
			List<Map<String,String>> pBoardList = new ArrayList<>();
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Map<String,String> pBoard = new HashMap<>();
				pBoard.put("pb_num", rs.getString("pb_num"));
				pBoard.put("pb_title", rs.getString("pb_title"));
				pBoard.put("pb_content", rs.getString("pb_content"));
				pBoard.put("pb_credat", rs.getString("pb_credat"));
				pBoard.put("pb_cretim", rs.getString("pb_cretim"));
				pBoard.put("pb_real_path", rs.getString("pb_real_path"));
				pBoard.put("pb_file_path", rs.getString("pb_file_path"));
				pBoardList.add(pBoard);
			}
			return pBoardList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Map<String, String> selectPBoard(int pbNum) {
		try {
			PreparedStatement ps = DBCon.getCon().prepareStatement(SELECT_PBOARD);
			ps.setInt(1, pbNum);
			ResultSet rs = ps.executeQuery();
			Map<String,String> pBoard = new HashMap<>();
			while(rs.next()) {
				pBoard.put("pb_num", rs.getString("pb_num"));
				pBoard.put("pb_title", rs.getString("pb_title"));
				pBoard.put("pb_content", rs.getString("pb_content"));
				pBoard.put("pb_credat", rs.getString("pb_credat"));
				pBoard.put("pb_cretim", rs.getString("pb_cretim"));
				pBoard.put("pb_real_path", rs.getString("pb_real_path"));
				pBoard.put("pb_file_path", rs.getString("pb_file_path"));
				return pBoard;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
