package edu.kh.jdbc.run;

import edu.kh.jdbc.model.service.TestService;
import edu.kh.jdbc.model.vo.TestVO;

public class Run {

	public static void main(String[] args) {
		TestService service = new TestService();
		
		TestVO vo1 = new TestVO(1, "제목1", "내용1");
		service.insert(vo1);
		
	}
}
