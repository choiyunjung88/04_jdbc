package edu.kh.emp.model.dao;

import static edu.kh.emp.common.JDBCTemplate.close;


import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.emp.model.vo.Employee;

public class EmployeeDAO {

	// JDBC 객체 참조변수 선언
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	private int result1;
	
	public EmployeeDAO() {
		try {
			prop = new Properties();
			prop.loadFromXML(new FileInputStream("query.xml"));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public List<Employee> selectAll(Connection conn) throws Exception {
		// TODO Auto-generated method stub
		List<Employee> list = new ArrayList<Employee>();
		try {
			String sql = prop.getProperty("selectAll");
			
			// Statement 객체 생성
			stmt = conn.createStatement();
			
			// SQL을 수행 후 결과(ResultSet) 반환 받음
			rs = stmt.executeQuery(sql);
			
			// 조회 결과를 얻어와 한 행씩 접근하여
			// Employee 객체 생성 후 컬럼값 담기
			// -> List 담기
			while(rs.next()) {
				
				int empId = rs.getInt("EMP_ID");
				// EMP_ID 컬럼은 문자열 컬럼이지만
				// 저장된 값들은 모두 숫자형태
				// -> DB에서 자동으로 형변환 진행해서 얻어옴
				
				String empName = rs.getString("EMP_NAME");
				String empNo = rs.getString("EMP_NO");
				String email = rs.getString("EMAIL");
				String phone = rs.getString("PHONE");
				String departmentTitle = rs.getString("DEPT_TITLE");
				String jobName = rs.getString("JOB_NAME");
				int salary = rs.getInt("SALARY");
				
				Employee emp = new Employee(empId, empName, empNo, email, phone, departmentTitle, jobName, salary);
				
				list.add(emp); //List 담기
			}  // while문 종료
			
			
			
		} finally {
			
			// 사용한 JDBC 객체 자원 반환
			close(rs);
		}
		
		return list;
	}

	public int insertEmployee(Connection conn, Employee emp) throws Exception {
		int result = 0;


		try {
			// SQL 작성
			String sql = prop.getProperty("insertEmployee");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, emp.getEmpId());
			pstmt.setString(2, emp.getEmpName());
			pstmt.setString(3, emp.getEmpNo());
			pstmt.setString(4, emp.getEmail());
			pstmt.setString(5, emp.getPhone());
			pstmt.setString(6, emp.getDeptCode());
			pstmt.setString(7, emp.getJobCode());
			pstmt.setString(8, emp.getSalLevel());
			pstmt.setInt(9, emp.getSalary());
			pstmt.setDouble(10, emp.getBonus());
			pstmt.setInt(11, emp.getManagerId());
			result = pstmt.executeUpdate(sql);
			
		}finally {
			close(pstmt);
		}
		return 0;
	}

	public Employee selectEmployee(Connection conn, int empId) throws Exception {
		Employee emp = null;
		try {
			String sql = prop.getProperty("selectEmployee");

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, empId);
			// stmt - ? (위치홀더 없을 때)
			// pstmt - ? (위치홀더 있을 때)
			//executeQuery - Select -> ResultSet
			//executeUpdate - DML(update, delete,insert) -> int(성공한 행의 개수)
			rs = pstmt.executeQuery(); 
			
			if(rs.next()) {
				String empName = rs.getString("EMP_NAME");
				String empNo = rs.getString("EMP_NO");
				String email = rs.getString("EMAIL");
				String phone = rs.getString("PHONE");
				String departmentTitle = rs.getString("DEPT_TITLE");
				String jobName = rs.getString("JOB_NAME");
				int salary = rs.getInt("SALARY");
				
				emp = new Employee(empId, empName, empNo, email, phone, departmentTitle, jobName, salary);
				
				
			}
		} finally {
			close(rs);
			close(pstmt);
		}
		
		
		return emp;
	}

	public int updateEmployee(Connection conn, Employee emp) throws Exception {
		// TODO Auto-generated method stub
		
		int result = 0;
		try {
			String sql = prop.getProperty("updateEmployee");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, emp.getEmail());
			pstmt.setString(2, emp.getPhone());
			pstmt.setInt(3, emp.getSalary());
			pstmt.setInt(4, emp.getEmpId());
			result = pstmt.executeUpdate();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int deleteEmployee(Connection conn, int empId) throws Exception{
		// TODO Auto-generated method stub
		int result = 0;
		
		try {
			String sql = prop.getProperty("deleteEmployee");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, empId);
			result = pstmt.executeUpdate();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public List<Employee> selectDeptEmp(Connection conn, String empDept) throws Exception {
		// TODO Auto-generated method stub
				List<Employee> list = new ArrayList<Employee>();
				try {
					String sql1 = prop.getProperty("dept");
					pstmt = conn.prepareStatement(sql1);
					pstmt.setString(1, empDept);
					rs = pstmt.executeQuery(); 
					while(rs.next()) {
						
						
						int empId = rs.getInt("EMP_ID");
						// EMP_ID 컬럼은 문자열 컬럼이지만
						// 저장된 값들은 모두 숫자형태
						// -> DB에서 자동으로 형변환 진행해서 얻어옴
						
						String empName = rs.getString("EMP_NAME");
						String empNo = rs.getString("EMP_NO");
						String email = rs.getString("EMAIL");
						String phone = rs.getString("PHONE");
						String departmentTitle = rs.getString("DEPT_TITLE");
						String jobName = rs.getString("JOB_NAME");
						int salary = rs.getInt("SALARY");
						
						Employee emp = new Employee(empId, empName, empNo, email, phone, departmentTitle, jobName, salary);
						
						list.add(emp); //List 담기
						}  // while문 종료
					
					
					
				} finally {
					
					// 사용한 JDBC 객체 자원 반환
					close(rs);
					close(pstmt);
				}
				
				return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
