package com.bitcamp.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex08_Add
 * 이클립스 New Servlet 자동 생성기 이용
 */
@WebServlet("/add")
public class Ex08_Add extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String x_ = request.getParameter("x");
		String y_ = request.getParameter("y");
		
		int x = 0;
		int y = 0;
		
		if(!x_.equals("")) x = Integer.parseInt(x_);
		if(!y_.equals("")) y = Integer.parseInt(y_);
		
		int result = x + y;
		
		response.getWriter().printf("result is %d\n", result);
	}

}
