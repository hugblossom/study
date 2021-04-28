package com.myapp.web.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
@Aspect
public class LoginCheckAspect {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Around("@annotation(com.myapp.web.annotation.LoginCheck)")
	public Object loginCheck(ProceedingJoinPoint jp) throws Throwable {
		
		HttpServletRequest request =
				((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
		HttpSession session = request.getSession();
		String session_member_id = (String) session.getAttribute("session_member_id");
		
		if ( StringUtils.isEmpty(session_member_id) ) {
			throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED);
		}
		
		return jp.proceed();
	}
}
