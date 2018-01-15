package org.formation.proxibanque.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopLogger {
	
	@Pointcut("execution(* *.save(..))")
	public void executeMethod() {
	}

	
	// @AfterThrowing("executeMethod()")
	// public void sucks( ) {
	// log
	// }

	@Around("executeMethod()")
	public void watchingPerformance(ProceedingJoinPoint jp) {
		try {
			// Do something before execution of the method
			
			jp.proceed();	// Execution of the method
			
			// Do something else after execution of the method
			
			
		} catch (Throwable e) {
			// Do something when these is an exception thrown
//			System.out.println(e.getMessage());
		}
	}
}
