package com.servlet.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GetDataFromDatabase {
//	public static  ResultSet getDetail() throws SQLException {
//		Connection conn = DbConnect.getConnection();
//		String query = "select * from userdetail";
//		Statement st = conn.createStatement();
//		return st.executeQuery(query);
//		
//	}
	
	public static void Main(String[] args) throws SQLException {
		Connection con = DbConnect.getConnection();
		String query = "Select * from userdetail";
		Statement stmt = con.createStatement();
		List<Student> list = new ArrayList<Student>();
		ResultSet rs = stmt.executeQuery(query);
		while(rs.next()) {
		String id = rs.getString("id");
		String name = rs.getString("name");
		String address = rs.getString("address");
		String age = rs.getString("age");
		 Student student = new Student();
   
		}
		
	}
		
		
public static void main(String[] args) throws SQLException {
	new GetDataFromDatabase();
}
 
}

