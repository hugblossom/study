package com.myapp.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class TestFilter implements Filter {

    public TestFilter() {
    	System.out.println("created test filter");
    }

	public void destroy() {
		System.out.println("destroyed test filter");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("started test filter");
		chain.doFilter(request, response);
		
		System.out.println("ended test filter");
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("inited test filter");
	}

}
