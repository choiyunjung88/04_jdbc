package edu.kh.jdbc.common;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTemplate {

	private static Connection conn = null;
	
	/**DB연결정보를 담고 있는 Connection 객체 생성 및 반환 메서드
	 * @return conn
	 */
	public static Connection getConnection() {
		try {
			
			if(conn == null || conn.isClosed()) {
				Properties prop = new Properties();
				prop.loadFromXML(new FileInputStream("driver.xml"));
				String driver = prop.getProperty("driver");
				String url = prop.getProperty("url");
				String user = prop.getProperty("user");
				String password = prop.getProperty("password");
				
				Class.forName(driver);
				
				conn = DriverManager.getConnection(url, user, password);
				
				conn.setAutoCommit(false);
			}
			
			
			
			
			
		}catch (Exception e) {
			System.out.println("[Connection 생성 중 예외 발생]");
			e.printStackTrace();
		}
		return conn;
	}
	
	/**Connection 객체 자원 반환 메서드
	 * @param conn
	 */
	public static void close(Connection conn) {
		
		try {
			// 전달받은 conn이
			// 참조하는 Connection 객체가 있고
			// 그 Connection 객체가 close 상태가 아니라면
			if(conn != null && !conn.isClosed())
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	/** Statement, PreparedStatement(자식) 객체 자원 반환 메서드
	 * @param stmt
	 */
	public static void close(Statement stmt) {

		try {
			if(stmt != null && !stmt.isClosed()) stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/** ResultSet 객체 자원 반환 메서드
	 * @param rs
	 */
	public static void close(ResultSet rs) {
		try {
			if(rs != null && !rs.isClosed()) stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/** 트랜잭션 commit 메서드
	 * @param conn
	 */
	public static void commit(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) conn.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/** 트랜잭션 rollback 메서드
	 * @param conn
	 */
	public static void rollback(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) conn.rollback();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
