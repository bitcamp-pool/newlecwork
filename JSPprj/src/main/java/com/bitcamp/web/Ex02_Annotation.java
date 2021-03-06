package com.bitcamp.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * url 매핑을 외부파일(web.xml)을 사용하지 않고 
 * 설정하는 방법???
 * 의미있는 주석 어노테이션 활용: 메타데이터
 * 서블릿 3.0 이상
 * web.xml에서 <web-app>의 
 * metadata-complete="true" -> "false"로 수정 : web.xml로만 설정(true) / 어노테이션 포함(false)
 * 공유파일(web.xml)로 설정하면 협업시 복잡도 증가 어노테이션 사용 권장
 */
@WebServlet("/annot")
public class Ex02_Annotation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		for (int i=0; i<5; i++)
			out.println("<h" + (i+1) + ">Annotion?</h" + (i+1) + ">");
	}
}
