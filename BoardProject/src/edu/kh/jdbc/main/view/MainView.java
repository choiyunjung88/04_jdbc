package edu.kh.jdbc.main.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import edu.kh.jdbc.common.Session;
import edu.kh.jdbc.member.view.MemberView;

public class MainView {
	private Scanner sc = new Scanner(System.in);
	
	public void mainMenu() {
		
		int input = 0; // 메뉴 선택용 변수
		
		do {
			try {
				if(Session.loginMember == null) {
				System.out.println("========회원제 게시판 프로그램=========");	
				System.out.println("1. 로그인");	
				System.out.println("2. 회원가입");	
				System.out.println("0. 프로그램 종료");	
				System.out.println("\n메뉴선택 : ");	
				input = sc.nextInt();
				sc.nextLine();
				switch(input) {
				case 1: //login(); break;
				case 2: signUp();break;
				case 0: System.out.println("\n프로그램종료...");break;
				default: System.out.println("메뉴번호만 입력해주세요\n");
				}
				
				}else {
					System.out.println("\n========로그인 메뉴=========\n");	
					System.out.println("1. 회원 기능");	
					System.out.println("2. 게시판 기능");	
					System.out.println("0. 로그 아웃");	
					System.out.println("\n메뉴선택 : ");	
					input = sc.nextInt();
					sc.nextLine();
					switch(input) {
					case 1: MemberView.memberMenu(); break;
					case 2://signUp();break;
					case 0: System.out.println("\n프로그램종료...");break;
					defalt: System.out.println("메뉴번호만 입력해주세요\n");
					}
				}}
			catch(InputMismatchException e){
				System.out.println("***입력형식이 올바르지 않습니다***");
				sc.nextLine();
				input = -1;
			}
		}while(input !=8);
			}


	/**
	 * 회원가입
	 */
	private void signUp() {

		// 아이디, 비밀버번호, 비밀번호 확인, 이름, 성별을 저장할 변수 선언
		
		
		String memberId = null;
		String memberPw = null;
		String pwConfirm = null;
		String memberName = null;
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	