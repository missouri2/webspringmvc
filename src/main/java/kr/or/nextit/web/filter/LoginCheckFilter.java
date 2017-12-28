package kr.or.nextit.web.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCheckFilter implements Filter{
	
	List<String> excludeURI = new ArrayList<String>();
	
	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		excludeURI.add("/login/loginForm");
		excludeURI.add("/login/login");
		excludeURI.add("/login/logout");
		excludeURI.add("/board/boardList");
		excludeURI.add("/board/boardView");
		excludeURI.add("/member/memberList");
		excludeURI.add("/member/memberView");
		excludeURI.add("/member/memberForm");
		excludeURI.add("/member/memberInsert");
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpServletResponse httpResponse = (HttpServletResponse)response;
		
		HttpSession session = httpRequest.getSession();
		
		// /login/loginForm, /board/boardList, /board/boardView
		String uri = httpRequest.getRequestURI();  // /webmvc/????
		
		if(uri.indexOf(httpRequest.getContextPath()) == 0) {
			uri = uri.substring(httpRequest.getContextPath().length());
		}		
		
		// 로그인 정보 체크
		if(!excludeURI.contains(uri) && session.getAttribute("LOGIN_USER") == null) {
			
			session.setAttribute("previewPage", uri);
			
			httpResponse.sendRedirect(httpRequest.getContextPath() + "/login/loginForm");
			
		} else {
			// 정상 진행.
			chain.doFilter(request, response);
		}
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}
}










