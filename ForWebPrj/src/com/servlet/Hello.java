package com.servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* [HttpServlet]
 *  
 * 상속받기 위해 WAS서버 라이브러리 참조가 필요
 * 라이브러리 참조를 위해서는 서버 등록이 필요 따라서
 * 1. Window->Preferences->Servers 또는 Window->Show View->Server 메뉴에서 WAS 등록
 * 2. 프로젝트->마우스오른->Build Path->Add Libraries..
 * 3. C:\DevPool\newlecture\tools\apache-tomcat-9.0.62\webapps\ROOT\WEB-INF\classes(약속된 곳)에
 *    해당 패키지를 저장(이 곳은 비공개 영역 사용자가 직접적인 호출 불가 서버만 사용)
 * 4. 사용자 요청 URL과 매핑된 Servlet 코드를 찾아서 실행
 * 5. web.xml 편집
 *    <servlet>
     	<servlet-name>Hello</servlet-name>
     	<servlet-class>com.servlet.Hello</servlet-class>
  	  </servlet>

	  <servlet-mapping>
	    <servlet-name>Hello</servlet-name>
	    <url-pattern>/hello</url-pattern>
	  </servlet-mapping>
 * 6. 서버시작
 * 7. localhost:8080/hello
 */
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// System.out.println("Hello Servlet");
		// req  : 입력객체
		// resp : 출력객체가 갖고 있는 출력 스트림 가져오기
		OutputStream os = resp.getOutputStream(); // binary 데이터가 아니므로 
		PrintStream out =  new PrintStream(os, true); // 문자열 출력에 특화된 기능을 사용 true=flush
		for (int i=0; i<10; i++)
			out.println("Hello Servlet!!!");
	}
}









