package com.bitcamp.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** [한글과 콘텐츠 형식 출력하기]
 * 브라우저에 컨텐츠 형식을 알려주기
 * : 해석기에게 명시하지 않은 경우 브라우저가 자의적인(html/text) 해석을 방지
 *   한글 깨짐 해결
 * 
 * 원인 : 웹서버가 ISO-8859-1 유럽의 인코딩(1byte) 방식 사용
 * 
 */
@WebServlet("/content")
public class Ex03_Contents extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		/* 저장하거나 네트워크로 보낼 때 인코딩 방식을 지정
		 * explorer 인코딩 한국어->utf-8로하면 안깨짐 : 브라우저의 디코딩 방식도 지정해야 안깨짐
		 */
		response.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		for(int i=0; i<6; i++)
			out.printf("<h%d>안녕 서블릿!</h%d>", i+1, i+1);
	}
}
