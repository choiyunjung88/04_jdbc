package edu.kh.jdbc.main.model.service;

import java.util.Scanner;

public class MainService {
	private Scanner sc = new Scanner(System.in);
	
	public ic signUp(Member member) {
		// DAO 호출
		
		int result = dao.signUp(conn, member); //INSERT 수행
		
		//트랜잭션 처리
		if(result > 0) commit(conn);
		else           rollback(conn);
		
		close(conn)
		return result
	}
}
