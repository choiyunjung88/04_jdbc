package edu.kh.jdbc.board.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.jdbc.board.model.dto.Board;

public class BoardDAO {

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	//XML에 작성된 SQL을 읽어와 저장할 객체를 참조하는 변수
	private Properties prop;
	
	public BoardDAO() {
		try {
			prop = new Properties();
			prop.loadFromXML(new FileInputStream("board-sql.xml"));
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public List<Board> selectAllBoard(Connection conn)throws Exception{
		List<Board> boardList = new ArrayList<Board>();
		try {
			String sql = prop.getProperty("selectAllBoard");
		}finally {
			
		}
		return null;
	}
	
	
}
