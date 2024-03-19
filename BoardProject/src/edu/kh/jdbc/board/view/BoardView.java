package edu.kh.jdbc.board.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import edu.kh.jdbc.board.model.dto.Board;
import edu.kh.jdbc.board.model.service.BoardService;

public class BoardView<Board> {
	
	private Scanner sc = new Scanner(System.in);

	public void boardMenu() {
			
			int input = -1;
			
			do {
				try {
					System.out.println("\n===== 게시판 기능 =====\n");
					System.out.println("1. 게시글 목록 조회");
					System.out.println("2. 게시글 상세 조회(+ 댓글 기능)");
					System.out.println("3. 게시글 작성");
					// 제목, 내용(StringBuffer 이용) 입력
					// -> 게시글 삽입 서비스(제목, 내용, 로그인 회원 번호) 호출
					
					System.out.println("9. 메인 메뉴로 돌아가기");
					System.out.println("0. 프로그램 종료");
					
					System.out.print("\n메뉴 선택 : ");
					input = sc.nextInt();
					sc.nextLine();
					
					System.out.println();
					
					switch(input) {
					case 1: selectAllBoard();  break; // 게시글 목록 조회
					case 2: //selectBoard(); break; // 게시글 상세 조회
					case 3: //insertBoard(); break; // 게시글 등록(삽입)
					
					case 9:
						System.out.println("\n===== 메인 메뉴로 돌아갑니다 =====\n");
						break;
					
					case 0:
						System.out.println("\n=== 프로그램 종료 ===\n");
						System.exit(0);
					default: System.out.println("\n*** 메뉴 번호만 입력 해주세요 ***\n"); 
					}
					
					System.out.println();
					
				}catch (InputMismatchException e) {
					System.out.println("\n*** 입력 형식이 올바르지 않습니다***\n");
					sc.nextLine(); // 입력버퍼에 잘못된 문자열 제거
					input = -1; // while문 종료 방지
				}
				
			}while(input != 9);
			
		}

	public void selectAllBoard() {
		System.out.println("\n==== 게시글 목록 조회 ====\n");
		
		// 3 | 샘플 제목[2] | 신짱구 | 2024-03-19 | 0
		
		try {
			// 게시글 목록 조회 서비스 호출
			List<Board> boardList = BoardService.selectAllBoard();
			
		} catch(Exception e) {
			System.out.println("\n*** 게시글 목록 조회 중 예외 발생 ***\n");
			e.printStackTrace();
		}
		
	}
		


}
