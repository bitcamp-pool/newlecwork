package com.bitcamp.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnect {
	static final String DRIVER 	= "com.mysql.cj.jdbc.Driver";
	static final String URL 	= "jdbc:mysql://localhost:3306/bit901?serverTimezone=Asia/Seoul";
	
	public DbConnect() {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("Mysql 드라이버 오류" + e.getMessage());
		}
	}
	
	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, "root", "1234");
		} catch (SQLException e) {
			System.out.println("Mysql 연결실패:" + e.getMessage());
		}
		
		return conn;
	}
}
