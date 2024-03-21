package edu.kh.servlet.controller;

public class ExampleController1 {
	String name = req.getParameter("inputName");
	String age = req.getParamenter("inputAge");
	System.out.println("입력 받은 이름 : "+name);
	System.out.println("입력 받은 나이 : "+age);
	//서버 -> 클라이언트 응답하기
	//httpservletresponse 객체 응용
	//서버 -> 클라이언트로 연결되는 스트림 연결하기
	//서버에서 클라이언트로 응답하는 방법은 응답 페이지 만들어 보냄.
	PrintWriter out = resp.getWriter();
	
			
}
