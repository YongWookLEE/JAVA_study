package com.jdbc.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GuestDAO {
	Connection conn;
	PreparedStatement pstm;
	ResultSet rs;
	
	public GuestVO getInfo(String id) {
		String query = "select userId, userAge, birth from guest where userId = ?";
		GuestVO guest = new GuestVO();
		try {
			conn = DBConnecter.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, id);
			rs = pstm.executeQuery();
			rs.next();
			guest.setUserId(rs.getString(1));
			guest.setUserAge(rs.getInt(2));
			guest.setBirth(rs.getString(3));
		} catch (SQLException e) {
			System.out.println("getInfo(String) SQL 오류");
			e.printStackTrace();
		}
		
		return guest;
	}
	
}
