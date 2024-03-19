package edu.kh.jdbc.board.model.service;

import java.sql.Connection;
import java.util.List;
import static 

import edu.kh.jdbc.board.model.dao.BoardDAO;
import edu.kh.jdbc.board.model.dto.Board;

public class BoardService {

	private BoardDAO dao = new BoardDAO();

	public static List<Board> selectAllBoard() {
		// TODO Auto-generated method stub
		
		// 커넥션 생성
		Connection conn = getConnection();
				
		List<Board> selectAllBoard(Connection conn){
			
		}
		
		return null;
	}
}
