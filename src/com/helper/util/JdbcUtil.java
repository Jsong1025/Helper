package com.helper.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtil {
	
	static String url = null;
	static String user = null;
	static String password = null;
	static String driver = null;

	private JdbcUtil(){}

	// 加载驱动
	static{
		try {
			loadParam();
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	// 加载参数
	public static void loadParam() throws IOException{
		Properties prop = new Properties();
		InputStream inStream = JdbcUtil.class.getClassLoader().getResourceAsStream("DB.properties");
		
		prop.load(inStream);
		driver = prop.getProperty("driver");
		url = prop.getProperty("url");
		user = prop.getProperty("user");
		password = prop.getProperty("password");
	}
	
	//获取链接
	public static Connection getConnection() throws Exception{
		Connection conn =DriverManager.getConnection(url, user, password);
		return conn;
	}
	
	//关闭链接
	public static void close( ResultSet rs,Statement stmt,Connection conn) throws Exception{
		if(rs != null){
			rs.close();
		}
		if(stmt != null){
			stmt.close();
		}
		if(conn != null){
			conn.close();
		}
	}
	
	public static void main(String[] args) throws Exception {
		Connection conn = JdbcUtil.getConnection();
		System.out.println(conn);
		JdbcUtil.close(null, null, conn);
	}

}
