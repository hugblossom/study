package com.artlier.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.lang.Nullable;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		HttpSession session = request.getSession();
		String session_member_id = (String) session.getAttribute("member_id");
		boolean result = false;
		
		if ( StringUtils.hasText(session_member_id) ) {
			
			result = true;
			
		} else {
			
			result = false;
			
			response.sendRedirect("/member/login");
		}
		
		return result;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
		
		System.out.println("post do");
		
	}
	
	
}
