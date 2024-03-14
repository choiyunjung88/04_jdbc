package edu.kh.jdbc.run;

import java.io.FileOutputStream;
import java.util.Properties;
import java.util.Scanner;

import edu.kh.jdbc.model.service.TestService;
import edu.kh.jdbc.model.vo.TestVO;

public class Run4 {

	// 삭제할 번호를 입력받아
	// 번호와 일치하는 행 삭제
	
	// 삭제 성공 시 -> 삭제 되었습니다.
	// 삭제 실패 시 -> 일치하는 번호 없음
	// 예외 발생 시 -> 삭제 중 예외 발생...
	
	public static void main(String[] args) {

		try {
			
			Scanner sc = new Scanner(System.in);
			
			TestService service = new TestService();
			
			System.out.print("삭제할 번호 이름 : ");
			int fileName = sc.nextInt();
			

			System.out.println(fileName + "삭제되었습니다");
			System.out.println(fileName + "일치하는 번호 없음");
			System.out.println(fileName + "삭제 중 예외 발생...");
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
