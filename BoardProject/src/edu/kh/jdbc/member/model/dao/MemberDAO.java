package edu.kh.jdbc.member.model.dao;

import java.util.Properties;

public class MemberDAO {

	//JDBC 객체 참조 변수
	private Statment stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	// 기본생성자 member-sql.xml 읽어오고 prop 저장
	public MemberDAO() {
		try {
			prop = new Properites();
			prop.loadFromXML(new FileInputStream(""));
		}
	}
}
