package edu.kh.jdbc.member.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import edu.kh.jdbc.common.Session;
import edu.kh.jdbc.member.model.service.MemberService;

/**
 * 회원 전용 화면
 */
public class MemberView {
	
	private static Scanner sc = new Scanner(System.in);
	private static MemberService service = new MemberService();
	//회원기능화면객체생성
	private MemberView memberview = new MemberView();
	
	/**
	 * 회원 기능 메뉴 View
	 */
	public static void memberMenu() {
		int input = 0;
		
		do {
			try {
				System.out.println("\n===회원 기능===\n");
				System.out.println("1. 내 정보 조회");
				System.out.println("2. 회원 목록 조회(아이디, 이름, 성별)");
				System.out.println("3. 내 정보 수정(이름, 성별, (현재 로그인한 회원번호))");
				System.out.println("4. 비밀번호 변경(현재 비밀번호, 새 비민번호, 새 비밀번호 확인)");
				System.out.println("5. 회원 탈퇴(보안코드, 비밀번호, UPDATE)");
				
				System.out.println("9. 메인메뉴로 돌아가기");
				System.out.println("0. 프로그램 종료");
				
				System.out.println("\n메뉴 선택 : ");
				input = sc.nextInt();
				sc.nextLine();
				switch(input) {
				case 1: selectMyInfo(); break;
				case 2: selectMemberList(); break;
				case 3: updateMember(); break;
				case 4: updatePassword(); break;
				case 5: if(unResisterMenu()) return; break;
				case 9: System.out.println("\n==========메인메뉴로 돌아갑니다==========\n"); break;
				case 0: System.out.println("\n======프로그램 종료=======\n");
				
				//JVM 강제 종료 구문
				// 매개변수는 기본 0, 다른 숫자는 오류를 의미
				System.exit(0);
				default: System.out.println("\n*** 입력형식이 올바르지 않습니다 ***");
				
				}
			}catch(InputMismatchException e) {
				System.out.println("\n*** 입력형식이 올바르지 않습니다***\n");
				sc.nextLine();
				input = -1;
			}
		}while(input != 9);
	}

	private static boolean unResisterMenu() {
		System.out.println("\n==== 회원탈퇴 ====\n");
		System.out.println("현재 비밀번호 : ");
		String memberPw = sc.next();
		
		String code = service.
	}

	private static void updatePassword() {
		System.out.println("\n====비밀번호 변경====\n");
		
		System.out.println("현재 비밀번호 : ");
		String current = sc.next();
		
		String newPw1 = null;
		
		while(true) {
			// 새 비밀번호 입력
			System.out.print("새 비밀번호 : ");
			newPw1 = sc.next();
			System.out.print("새 비밀번호 확인 : ");
			String newPw2 = sc.next();
			
			// 같을 때까지 무한 반복
			if(newPw1.equals(newPw2)) {
				break;
			}
			
			// 아닐때
			System.out.println("\n***새 비밀번호가 일치하지 않습니다***\n");
			
			
		}
		
		try {
			// 서비스 호출 (현재 비밀번호,
			int result = service.update();                                
		}catch(Exception e) {
			System.out.println("\n*** 비밀번호 변경 중 예외 발생 ***\n");
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
	}

	private static void updateMember() {
		// TODO Auto-generated method stub
		
	}

	private static void selectMemberList() {
		System.out.println("\n====회원 목록 조회====\n");
	}

	/**
	 * 내 정보 조회
	 */
	private static void selectMyInfo() {
		System.out.println("\n====내 정보 조회====\n");
		
		// 회원 번호, 아이디, 이름, 성별(남/여), 가입일
		// Session.loginMember 이용
		
		System.out.println("회원 번호 : "+ Session.loginMember.getMemberNo());
		System.out.println("아이디 : " + Session.loginMember.getMemberId());
		System.out.println("이름 : " + Session.loginMember.getMemberName());
		
		if(Session.loginMember.getMemberGenter().equals("M")) {
			System.out.println("성별 : 남");
			
		} else {
			System.out.println("성별 : 여");
		}
		System.out.println("가입일 : " + Session.loginMember.getEnrollDate());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
