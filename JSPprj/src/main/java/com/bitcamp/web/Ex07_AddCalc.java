package com.bitcamp.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/addc")
public class Ex07_AddCalc extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		PrintWriter out = res.getWriter();
		
		int x, y = 0;
		x = Integer.parseInt(req.getParameter("x")); 
		y = Integer.parseInt(req.getParameter("y")); 
		
		out.println("덧셈결과: " + (x + y));
	}
}
