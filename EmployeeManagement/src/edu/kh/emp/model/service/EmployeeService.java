package edu.kh.emp.model.service;

import java.sql.Connection;
import java.util.List;

import static edu.kh.emp.common.JDBCTemplate.*;
import edu.kh.emp.model.dao.EmployeeDAO;
import edu.kh.emp.model.vo.Employee;

public class EmployeeService {

	private EmployeeDAO dao = new EmployeeDAO();
	
	/** 전체 사원 정보 조회 서비스
	 * @return list
	 */
	public List<Employee> selectAll() throws Exception{
		Connection conn = getConnection();
		List<Employee> list = dao.selectAll(conn);
		close(conn);
		return list;
	}
	
	
	public int insertEmployee(Employee emp) throws Exception {
		Connection conn = getConnection();
		int result = dao.insertEmployee(conn, emp);
		if(result > 0) commit(conn);
		else           rollback(conn);
		close(conn);
		return 0;
	}


	public Employee selectEmployee(int id) throws Exception {
		Connection conn = getConnection();
		Employee emp = dao.selectEmployee(conn, id);
		close(conn);
		
		return emp;
	}


	public int updateEmployee(Employee emp) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		int result = dao.updateEmployee(conn, emp);
		if(result > 0) commit(conn);
		else           rollback(conn);
		close(conn);
		
		return result;
	}


	public int deleteEmployee(int empId) throws Exception {
		Connection conn = getConnection();
		int result = dao.deleteEmployee(conn, empId);
		if(result > 0) commit(conn);
		else           rollback(conn);
		close(conn);
		return result;
	}


	public List<Employee> selectDeptEmp(String empDept) throws Exception {
		Connection conn = getConnection();
		List<Employee> list = dao.selectDeptEmp(conn, empDept);
		close(conn);
		return list;
	}


	public List<Employee> selectSalEmp(int empsal) {
		// TODO Auto-generated method stub
		
		return null;
	}


	
	
	
	
	
	
	
}
