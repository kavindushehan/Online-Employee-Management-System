package com.oop.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ManagerDBUtil{
	
	String sql = "select * from manager where username=? and password=?";
	
	private static Connection con = null;
	public boolean check(String username, String password) {	
		try {
			con = DBConnection.getConnection();
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, username);
			st.setString(2, password);
			
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				return true;
			}
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return false;
	}
}