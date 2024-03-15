package edu.kh.emp.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import edu.kh.emp.model.service.EmployeeService;
import edu.kh.emp.model.vo.Employee;

//화면용 클래스
public class EmployeeView {

	private Scanner sc = new Scanner(System.in);
	
	//Service 객체 생성
	private EmployeeService service = new EmployeeService();
	
	// 메인 메뉴
	public void displayMenu() {
		int input = 0;
		do {
			try {
				System.out.println("------------------------------------");
				System.out.println("---------사원 관리 프로그램---------");
				System.out.println("1. 전체 사원 정보 조회");
				System.out.println("2. 새로운 사원 추가");
				System.out.println("3. 사번이 일치하는 사원 정보 조회");
				System.out.println("4. 사번이 일치하는 사원 정보 수정");
				System.out.println("5. 사번이 일치하는 사원 정보 삭제");
				
				
				System.out.println("6. 입력받은 부서와 일치하는 모든 사원 정보 조회");
				System.out.println("7. 입력받은 급여 이상을 받는 모든 사원 정보 조회");
				System.out.println("8. 부서별 급여 합 전체 조회");
				System.out.println("9. 주민등록번호가 일치하는 사원 정보 조회");
				System.out.println("10. 직급별 급여 평균 조회");
				
				
				
				
				System.out.println("0. 프로그램 종료");
				
				System.out.println("메뉴 선택 >> ");
				input = sc.nextInt();
				switch(input) {
				case 1: selectAll(); break;
				case 2: insertEmployee(); break;
				case 3: selectEmpId(); break;
				case 4: updateEmployee(); break;
				case 5: deleteEmployee(); break;
				case 6: selectDeptEmp(); break;
				case 7: selectSalaryEmp() ; break; 
				case 8: //selectDeptTotalSalary()
					// D1 : 8000000원
					// D2 : 5200000원
					// ...
					//HashMap<String, Integer>
				case 9: // selectEmpNo() : 주민등록번호 입력
				case 10: // selectJobAvgSalary()  //HashMap<String, Double>
					//대표 : 8000000.0원
					//부사장 : 4850000.0
					//...
					//사원 : 2017500.0원
				case 0: System.out.println("프로그램을 종료합니다.."); break;
				default: System.out.println("메뉴에 존재하는 번호만 입력하세요!");
				}
			}catch(InputMismatchException e) {
				System.out.println("정수만 입력해주세요");
				input = -1; // 반복문 첫 번째 바퀴에서 잘못입력하면 종료되는 상황을 방지
				sc.nextLine(); // 입력버퍼에 남아있는 잘못 입력된 문자열 제거해서 무한반복 방지.
			}catch(Exception e) {
				e.printStackTrace();
			}
		}while(input != 0);
	}
	
	private void selectSalaryEmp() {
		// TODO Auto-generated method stub
		System.out.println("<사원 정보 조회 - 입력 급여 이상>");
		int empsal = inputEmpSal();
		List<Employee> empList = service.selectSalEmp(empsal);
		printAll(empList);
	}

	private int inputEmpSal() {
		// TODO Auto-generated method stub
		System.out.println("급여 입력 : ");
		int empSal = sc.nextInt();
		sc.nextLine(); // 입력버퍼 개행제거
		return empSal;
	}

	private void selectDeptEmp() throws Exception {
		System.out.println("<사원 정보 조회 - 부서별>");

		String empDept = inputEmpDept();
		List<Employee> empList = service.selectDeptEmp(empDept);
		
		printAll(empList);
	}

	/**
	 * 전체 사원 정보 조회 View
	 * @throws Exception 
	 */
	public void selectAll() throws Exception {
		System.out.println("<전체 사원 정보 조회>");
		
		List<Employee> empList = service.selectAll();
		
		printAll(empList);
	}
	
	
	public void insertEmployee() throws Exception{
		System.out.println("<사원 정보 추가>");
		
		int empId = inputEmpId();
		System.out.print("이름 : ");
		String empName = sc.next();
		System.out.print("주민등록번호 : ");
		String empNo = sc.next();
		System.out.print("이메일 : ");
		String email = sc.next();
		System.out.println("전화번호 : ");
		String phone = sc.next();
		System.out.println("부서코드(D1~D9) : ");
		String deptCode = sc.next();
		System.out.println("직업코드");
		String jobCode = sc.next();
		System.out.println("급여등급(S1~S6)");
		String salLevel = sc.next();
		System.out.println("급여 : ");
		int salary = sc.nextInt();
		System.out.println("보너스 : ");
		double bonus = sc.nextDouble();
		System.out.println("사수번호 : ");
		int managerId = sc.nextInt();
	
		Employee emp = new Employee(empId, empName, empNo, email, phone, salary, deptCode, jobCode, salLevel, bonus, managerId);
		int result = service.insertEmployee(emp);
	
		
		
		if(result > 0) {
			System.out.println("사원 정보 추가 성공");
		} else {
			System.out.println("사원 정보 추가 실패!");
		}
	

	
	
	// 보조 메서드
	}
	
		public int inputEmpId() {
			System.out.println("사번 입력 : ");
			int empId = sc.nextInt();
			sc.nextLine(); // 입력버퍼 개행제거
			return empId;
		}
	
		public String inputEmpDept() {
			System.out.println("부서 입력 : ");
			String empDept = sc.next();
			sc.nextLine(); // 입력버퍼 개행제거
			return empDept;
		}
	
		public void selectEmpId() throws Exception {
			System.out.println("<사번이 일치하는 사원 정보 조회>");
			// 사번 입력 받기(inputEmpId() 이용)
			int empId = inputEmpId();
			
			//서비스 호출 및 결과 반환 받기
			Employee emp = service.selectEmployee(empId);
			
			// printOne() 메서드 이용하여 결과 출력하기
			System.out.println(emp);
		}


		public void updateEmployee() throws Exception{
			System.out.println("<사번이 일치하는 사원정보 수정>");
			int empId = inputEmpId();
			System.out.print("이메일 : ");
			String email = sc.next();
			System.out.println("전화번호(-제외) : ");
			String phone= sc.next();
			System.out.println("급여 : ");
			String salary = sc.next();
			Employee emp = new Employee();
			emp.setEmail(email);
			emp.setSalary(salary);
			emp.setEmpId(empId);
			emp.setPhone(phone);
			int result = service.updateEmployee(emp);
			if(result > 0) {
				System.out.println("사원 정보가 수정되었습니다.");
				
			}else {
				System.out.println("사번이 일치하는 직원이 존재하지 않습니다.");
			}
		}
	
	
		/** 전달받은 사원 List 모두 출력
		 *
		 */
		public void printAll(List<Employee> empList) {
			
			if(empList.isEmpty()) {
				System.out.println("조회된 사원 정보가 없습니다.");
				
			} else {
				System.out.println("사번 |   이름  | 주민 등록 번호 |        이메일        |   전화 번호   | 부서 | 직책 | 급여" );
				System.out.println("------------------------------------------------------------------------------------------------");
				for(Employee emp : empList) {
					System.out.printf(" %2d  | %4s | %s | %20s | %s | %s | %s | %d\n",
							emp.getEmpId(), emp.getEmpName(), emp.getEmpNo(), emp.getEmail(),
							emp.getPhone(), emp.getDepartmentTitle(), emp.getJobName(), emp.getSalary());
				}
			
			}
			
			return;
		}

		public void deleteEmployee() throws Exception {
			System.out.println("<사번이 일치하는 사원 정보 삭제>");
			int empId = inputEmpId();
			System.out.println("정말 삭제 하시겠습니까? (Y/N) : ");
			char input = sc.next().toUpperCase().charAt(0);
			if(input == 'Y') {
				int result = service.deleteEmployee(empId);
				if(result >0) {
					System.out.println("삭제되었습니다.");
					
				}else {
					System.out.println("사번이 일치하는 사원이 존재하지 않습니다.");
				}
			} else {
				System.out.println("취소되었습니다.");
			}
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
