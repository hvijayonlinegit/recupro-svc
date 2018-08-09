/**
 * 
 */
package com.synergy.recupro.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author Ahmar
 *
 */
@Aspect
@Component
public class SpringAop {

	public static final Logger logger = LogManager.getLogger(SpringAop.class);

	/**
	 * AOP Around advice
	 * 
	 * @param pjp
	 * @return obj
	 */
	@Around(value = "execution(* com.synergy.recupro..*.*(..))")
	public Object aroundTest(ProceedingJoinPoint pjp) {
		Object obj=new Object();
		try {
			logger.info("Before Method execution Class Name : "
					+ pjp.getTarget().getClass().getName() + " Method Name : "
					+ pjp.getSignature().getName());
			obj=pjp.proceed();
			logger.info("After Method execution Class Name : "
					+ pjp.getTarget().getClass().getName() + " Method Name : "
					+ pjp.getSignature().getName());
		} catch (Throwable e) {
			obj=12;
			logger.info("After Throwable Method execution Class Name: "
					+ pjp.getTarget().getClass().getName() + " Method Name : "
					+ pjp.getSignature().getName());
		}
		return obj;

	}

}
