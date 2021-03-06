package com.bitcamp.web;
/*
 * 서블릿 만들기
 */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ex01_Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		// 다국어 지원을 위해서 PrintStream이 아닌 Writer를 사용
		PrintWriter out = resp.getWriter(); 
		out.println("<h1>Hello Servlet!!!</h1>");
		out.println("<h2>Hello Servlet!!!</h2>");
		out.println("<h3>Hello Servlet!!!</h3>");
		out.println("<h4>Hello Servlet!!!</h4>");
		out.println("<h5>Hello Servlet!!!</h5>");
		out.println("안녕 서블릿!!!");
		
		/* 톰캣 web.xml에서 서블릿class가 url과 매핑 작업이 필요
		 * 톰캣의 web.xml 파일 복사 webapp/WEB-INF/ 붙여넣기
		 * web.xml 편집 
		 *
		 *
		  <servlet>
		  	<servlet-name>hs</servlet-name>
		  	<servlet-class>com.bitcamp.web.Ex01_Hello</servlet-class>
		  </servlet>
		  
		  <servlet-mapping>
		  	<servlet-name>hs</servlet-name>
		  	<url-pattern>/hello</url-pattern>  '/'빼먹지 않도록 주의!!!
		  </servlet-mapping>
		 */
		/**
		 * '/hello'라는 요청이 들어오면 서블릿 클래스 com.bitcamp.web.Hello를
		 *  로드하고 실행해서 그 결과를 클라이언트에 돌려준다.
		 *  
		 *  소스 수정하고 톰캣 restart 하면 적용
		 */
	}
}
