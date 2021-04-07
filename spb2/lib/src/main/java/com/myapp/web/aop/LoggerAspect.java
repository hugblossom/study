package com.myapp.web.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggerAspect {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Around(
		"execution(* com.myapp.web..controller.*Controller.*(..)) ||" +
		"execution(* com.myapp.web..service.*Service.*(..)) || " +
		"execution(* com.myapp.web..mapper.*Impl..*(..))"
	)
	public Object printLog(ProceedingJoinPoint joinPoint) throws Throwable {
		String type = "";
		String name = joinPoint.getSignature().getDeclaringTypeName();
		
		if ( name.contains("Controller") ) {
			type = "Controller ===> ";
		}
		
		if ( name.contains("Service") ) {
			type = "Service ===> ";
		}
		
		if ( name.contains("Impl") ) {
			type = "Mapper ===> ";
		}
		
		logger.info(type + name + "." + joinPoint.getSignature().getName() );
		
		return joinPoint.proceed();
	}
}
