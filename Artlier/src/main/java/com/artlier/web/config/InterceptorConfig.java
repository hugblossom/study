package com.artlier.web.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.artlier.web.interceptor.LoginInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
	
	private static final List<String> LOGIN_ESSENTIAL = Arrays.asList("/member/**", "/board/**");
	private static final List<String> LOGIN_INESSENTIAL = Arrays.asList("/member/login","/member/logout","/board/common/list");
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor( new LoginInterceptor() )
				.addPathPatterns(LOGIN_ESSENTIAL)
				.excludePathPatterns(LOGIN_INESSENTIAL);
	}
	
	
}
