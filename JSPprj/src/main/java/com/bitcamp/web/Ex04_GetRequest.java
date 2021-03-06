package com.bitcamp.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * [Get 요청과 쿼리 스트링]
 * get/post 요청
 * http://localhost/greq 문서 요청---GET---> 
 * http://localhost/greq?cnt=3 값을 전달하여 요청 : ?cnt=3(쿼리스트링) 
 * 서버는 추가적으로 옵션을 읽어서 그에 맞게 문서를 전달
 * 
 */
@WebServlet("/greq")
public class Ex04_GetRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		// int cnt = Integer.parseInt(request.getParameter("cnt")); // 문자열->정수로 변환
		/*
		 * 쿼리값이 없으면 404오류(NullPointerException)
		 * 쿼리값이 없을 때 처리 구현 필요
		 * http://greq?cnt=3 ----> "3"
		 * http://greq?cnt=  ----> ""
		 * http://greq?      ----> null
		 * http://greq       ----> null
		 */
		// 기본값 설정
		int cnt = 1;
		String param = request.getParameter("cnt");
		if(param != null && !param.equals(""))
			cnt = Integer.parseInt(param);
		
		for(int i=0; i<cnt; i++)
			out.printf("<h3>요청 : %d 번</h3>", i + 1);
		
		/* 주소창 입력 대신 <a>태그를 사용하여 실행
		 * index.html 수정
		 * 	<h1>환영합니다.....^^</h1>
			<a href="greq">GET 요청</a><br>
			<a href="greq?cnt=5">GET 요청(쿼리 스트링)</a>
		 */
	}
}
