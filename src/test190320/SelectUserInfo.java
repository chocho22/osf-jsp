package test190320;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SelectUserInfo {
	
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER = "osfu";
	private static final String PASSWORD = "12345678";
	private static Connection con;
	
	private static void open() {
		if(con==null) { 
			try {
				Class.forName("oracle.jdbc.OracleDriver");
				con = DriverManager.getConnection(URL, USER, PASSWORD);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static Connection getCon() {
		if(con==null) {
			open();
		}
		return con;
	}
	
	public static void close() {
		if(con!=null) {
			try {
				if(!con.isClosed()) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		con = null;
	}
	
	public List<Map<String,String>> selectUserList() {
		String sql = "select ui_num,ui_name,ui_age from user_info";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<Map<String,String>> userList = new ArrayList<>();
			while(rs.next()) {
				Map<String,String> user = new HashMap<>();
				user.put("ui_num",rs.getString("ui_num"));
				user.put("ui_name",rs.getString("ui_name"));
				user.put("ui_age",rs.getString("ui_age"));
				userList.add(user);
			}
			return userList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return null;
	}
	
	public void insertUser() {
		String sql = "insert into user_info(ui_num,ui_name,ui_age)" +
				" values((select nvl(max(ui_num),0)+1 from user_info), " +
				" ?,?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, "사람");
			ps.setString(2, "20");
			int cnt = ps.executeUpdate();
			if(cnt==1) {
				System.out.println("등록 완료");
			} else {
				System.out.println("등록 실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}
	public void updateUser() {
		String sql = "update user_info set ui_name=?,ui_age=? " +
				" where ui_num=?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, "인간");
			ps.setString(2, "21");
			ps.setInt(3, 1);
			int cnt = ps.executeUpdate();
			if(cnt==1) {
				System.out.println("수정 완료");
			} else {
				System.out.println("수정 실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}
	public void deleteUser() {
		String sql = "delete from user_info where ui_num=?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, 1);
			int cnt = ps.executeUpdate();
			if(cnt==1) {
				System.out.println("삭제 완료");
			} else {
				System.out.println("삭제 실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}
}
