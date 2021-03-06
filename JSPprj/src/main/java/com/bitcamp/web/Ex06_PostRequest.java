package com.bitcamp.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * [POST 요청]
 * : 입력할 내용이 많은 경우
 * url 길이 제안 : 장문의 내용을 쿼리 스트링으로 전달하는 것은 적절하지 않다.
 * 				   따라서 url에 붙여서 전달하지 말고 요청(request) body에 붙여서 전달한다. 
 */

@WebServlet("/notice-reg")
public class Ex06_PostRequest extends HttpServlet {
	private static final long serialVersionUID = 1081257889931209320L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		/* 그런데 포스트로 입력 받은 데이터는 한글이 깨짐...
		 * 원인 : 입력(요청) 받은 데이터(UTF-8)를 톰캣이 1byte ISO-8859-1 인코딩 방식으로 해석
		 * 톰갯의 요청 인코딩 방식을 UTF-8로 설정
		 */
//		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		out.print(title + "<br>");
		out.print(content);
	}
}
