package com.bitcamp.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**             서블릿컨테이너
 * [웹서버] -------> [WAS] <----req/res--(필터)--> Servlet  
 * 필터 : 최초 톰캣 실행시 실행, 어떤 요청이 와도 실행
 * 설정 : web.xml 에서 또는 어노테이션 이용
 * 
 * request.setCharacterEncoding("UTF-8");주석 처리
 * Ex06_PostRequest 실행 
 * 새로고침 누를 때마다 Hello filter 출력
 * 
 * 필터는 chain.doFilter()를 통해 요청의 흐름을 넘겨 서블릿으로 전달하고 
 * 서블릿으로부터 받은 응답을  웹서버에 전달  
 * 
 * web.xml 필터 설정 주석
 * 어노테이션 설정
 */

@WebFilter("/*")
public class Ex01_CharacterEncodingFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
//		System.out.println("before filter");
		
		request.setCharacterEncoding("UTF-8"); 	// 모든 서블릿 인코딩 UTF-8 설정
		
		chain.doFilter(request, response); 		// 흐름을 제어, 관할
		
//		System.out.println("after filter");
	}
}
