package com.bitcamp.web;

import java.io.IOException;

//import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

/** 상태 유지를 위한 5가지 방법
 * 1. application > 서블릿 컨텍스트(Context) 저장소 : 자원 공유
 * 2. session     > Session 객체로 상태 값 저장하기(Application객체와의 차이점)
 * 					: 세션(현재 접속한 사용자) 마다 저장공간이 달라짐
 * 					: 브라우저가 다르면 다른 사용자로 처리(서버는 JSESSIONID=62D84EA4A80356A72E453300EF6DEC5E로 사용자 식별)
 * 3. cookie	  > 클라이언트의 저장소(크롬 개인정보 및 보안 항목> 쿠키 및 기타 사이트 데이터 > 모든 쿠키 보기
 * 					: 쿠키는 모든 페이지마다 동일한가? No 관련 서블릿에게만..
 * 4. hidden input
 * 5. querystring
 */
@WebServlet("/calc2")
public class Ex11_Calc2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; cahrset=UTF-8");
		
	 // ServletContext application = request.getServletContext();
	 //	HttpSession session = request.getSession();
		Cookie[] cookies = request.getCookies();
		
		
		
		String v_ = request.getParameter("v");
		String op = request.getParameter("operator");
		
		int v = 0;
		if(!v_.equals("")) v = Integer.parseInt(v_);
		
		// 계산
		if(op.equals("=")) {
		 // int x = (Integer)application.getAttribute("value");
		 //	int x = (Integer)session.getAttribute("value");
			int x = 0;
			for(Cookie c : cookies) {
				if(c.getName().equals("value")) {
					x = Integer.parseInt(c.getValue());
					break;
				}
			}

			int y = v;
		 // String operator = (String)application.getAttribute("op");
		 //	String operator = (String)session.getAttribute("op");
			String operator = "";
			for(Cookie c : cookies) {
				if(c.getName().equals("op")) {
					operator = c.getValue();
					break;
				}
			}
			
			int result = 0;
			
			if(operator.equals("+"))
				result = x + y;
			else 
				result = x - y;
			response.getWriter().printf("result is %d\n", result);
		}
		// 저장
		else {
		 // application.setAttribute("value", v);
		 // application.setAttribute("op", op);			
		 //	session.setAttribute("value", v);
		 //	session.setAttribute("op", op);
			
			// 저장할 쿠키 2개 생성
			Cookie valueCookie = new Cookie("value", String.valueOf(v));
			Cookie opCookie = new Cookie("op", op);
			
			
			// valueCookie.setPath("/"); 		// 모든 url 요청시 쿠키 전달
			// valueCookie.setPath("/add"); 	// 모든 add 요청시 쿠키 전달
			valueCookie.setPath("/calc2");  // clac2만
			
			// 쿠키 전송(클라이언트 전달)
			response.addCookie(valueCookie);
			response.addCookie(opCookie);
		}		
	}

}
