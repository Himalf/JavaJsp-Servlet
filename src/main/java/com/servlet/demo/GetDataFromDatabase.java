package com.servlet.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetDataFromDatabase {
	public static  ResultSet getDetail() throws SQLException {
		Connection conn = DbConnect.getConnection();
		String query = "select * from userdetail";
		Statement st = conn.createStatement();
		return st.executeQuery(query);
		
	}
public static void main(String[] args) throws SQLException {
GetDataFromDatabase d = new GetDataFromDatabase();
}
 
}

