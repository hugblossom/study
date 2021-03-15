package com.myapp.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

@WebFilter(urlPatterns = {"/board/delete", "/board/goodbad", "info/*", "/board/insert", "/board/update", "/member/join"})
public class LoginCheckFilter implements Filter {

    public LoginCheckFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request; // = ( (HttpServletRequest) request).getSession();
		HttpSession session = req.getSession();
		
		String mem_id = (String) session.getAttribute("session_mem_id");
		
		if ( StringUtils.isEmpty(mem_id) ) {
			session.invalidate();
			
			HttpServletResponse res = (HttpServletResponse) response;
			res.sendRedirect("/main");
		}

		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
