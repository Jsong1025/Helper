package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcUtil {
	static {
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch (ClassNotFoundException e) {
			System.out.println("类不存在");
		}
	}
	public static Connection getConnection() throws Exception{
		Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/helper","root","root");
		return conn;
	}
	
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

}
