package com.myapp.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterEncodingFilter implements Filter {

	String encoding = "";
	
    public CharacterEncodingFilter() {
    		System.out.println("created CharacterEncodingFilter");
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("chain started CharacterEncodingFilter");
		request.setCharacterEncoding(encoding);
		
		chain.doFilter(request, response);
		System.out.println("chain ended CharacterEncodingFilter");
	}

	public void init(FilterConfig fConfig) throws ServletException {
		encoding = fConfig.getInitParameter("encoding");
	}

}
