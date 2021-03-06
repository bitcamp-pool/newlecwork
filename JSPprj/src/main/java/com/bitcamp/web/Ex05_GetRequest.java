package com.bitcamp.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * [사용자 입력을 통한 GET 요청]
 * 
 * html 입력폼을 사용하여 전달
 * 
 */
@WebServlet("/order")
public class Ex05_GetRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		// 기본값 설정
		int cnt = 1;
		String param = request.getParameter("cnt");
		if(param != null && !param.equals(""))
			cnt = Integer.parseInt(param);
		
		for(int i=0; i<cnt; i++)
			out.printf("<h3>🍕🍖🍔 : %d set</h3>", i + 1);
	}
}
