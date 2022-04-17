package com.bitcamp.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** 상태 유지를 위한 5가지 방법
 * 1. application 서블릿 컨텍스트(Context) 저장소 : 자원 공유
 * 2. session
 * 3. cookie
 * 4. hidden input
 * 5. querystring
 */
@WebServlet("/calc2")
public class Ex11_Calc2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; cahrset=UTF-8");
		
		ServletContext application = request.getServletContext();
		String v_ = request.getParameter("v");
		String op = request.getParameter("operator");
		
		int v = 0;
		if(!v_.equals("")) v = Integer.parseInt(v_);
		
		// 계산
		if(op.equals("=")) {
			int x = (Integer)application.getAttribute("value");
			int y = v;
			String operator = (String)application.getAttribute("op");
			int result = 0;
			
			if(operator.equals("+"))
				result = x + y;
			else 
				result = x - y;
			response.getWriter().printf("result is %d\n", result);
		}
		// 저장
		else {
			application.setAttribute("value", v);
			application.setAttribute("op", op);			
		}		
	}

}