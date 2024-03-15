package edu.kh.jdbc.model.service;

import java.sql.Connection;
import java.sql.SQLException;

import static edu.kh.jdbc.common.JDBCTemplate;
import edu.kh.jdbc.model.dao.TestDAO;
import edu.kh.jdbc.model.vo.TestVO;

public class TestService {

	private TestDAO dao = new TestDAO();
	
	public void insert(TestVO vo1) throws SQLException {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.insert(conn, vo1);
		
	}
	
	
	
	public int delete(int testNo) {
		Connection conn = getConnection();
		int result = dao.delete(conn, testNo);
		if(result > 0) commit(conn);
		else            rollack(conn);
		close(conn);
		return result;
	}
	
	
	
	
	
	
	
	
}


//프로젝트명 : EmployeeManagemet
//Run : edu.kh.emp.run.EmployeeRun
//View : edu.kh.emp.view.EmployeeView
//Service : edu.kh.emp.model.service.EmployeeService;
//DAO : edu.kh.emp.model.dao.EmployeeDAO
//VO : edu.kh.emp.model.vo.Employee

//edu.kh.emp.common JDBCTemplate
//edu.kh.emp.common CreateXMLFile

//driver.xml
//query.xml





















