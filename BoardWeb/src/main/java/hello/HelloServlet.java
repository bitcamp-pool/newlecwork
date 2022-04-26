package hello;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* [ 톰캣 서블릿 컨테이너의 동작 ]
 * 1. WEB-INF/web.xml 파일을 로딩하여 구동
 * 2. 브라우저로부터 /hello.do 요청 수신
 * 3. hello.HelloServlet 클래스를 찾아 객체를 생성하고 doGet 호출
 * 4. doGet()메소드 실행 결과를 클라이언트 브라우저로 전송
 */
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HelloServlet() {
		System.out.println("===> HelloServlet 객체생성");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("doGet() 메소드 호출");
		
		resp.getWriter().println("HttpServlet  Test Page.");
	}
}
