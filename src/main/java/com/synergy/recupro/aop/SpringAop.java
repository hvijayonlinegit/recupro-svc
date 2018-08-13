/**
 * 
 */
package com.synergy.recupro.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author Ahmar
 *
 */
@Aspect
@Component
public class SpringAop {

	public static final Logger logger = LogManager.getLogger(SpringAop.class);

	@Pointcut("execution(* org.springframework.data.repository.Repository+.*(..))")
	public void repository() {
	}

	@Pointcut("execution(* com.synergy.recupro..*.*(..)) ")
	public void core() {
	};

	/**
	 * AOP Around advice
	 * 
	 * @param pjp
	 * @return obj
	 * @throws Throwable
	 */
	@Around("core()")
	public Object aroundTest(ProceedingJoinPoint pjp) throws Throwable {
		Object obj = new Object();
		logger.info("Before Method execution Class Name : "
				+ pjp.getSignature().getDeclaringTypeName() + " Method Name : "
				+ pjp.getSignature().getName());
		obj = pjp.proceed();
		logger.info("After Method execution Class Name : "
				+ pjp.getSignature().getDeclaringTypeName() + " Method Name : "
				+ pjp.getSignature().getName());

		return obj;

	}

	@Around("repository()")
	public Object aroundTestSec(ProceedingJoinPoint pjp) throws Throwable {
		Object obj = new Object();
		logger.info("Before Method execution Class Name : "
				+ pjp.getSignature().getDeclaringTypeName() + " Method Name : "
				+ pjp.getSignature().getName());
		obj = pjp.proceed();
		logger.info("After Method execution Class Name : "
				+ pjp.getSignature().getDeclaringTypeName() + " Method Name : "
				+ pjp.getSignature().getName());

		return obj;

	}

}
