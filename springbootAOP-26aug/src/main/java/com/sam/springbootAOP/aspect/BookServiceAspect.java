package com.sam.springbootAOP.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BookServiceAspect {
	
	@Before(value = "execution(* com.shaik.springbootaop.service.BookService.*(..)) and args(title, bookId)")
	public void beforeAdvice(JoinPoint joinPoint, String title, String bookId) {
	    System.out.println("Before method : " + joinPoint.getSignature());
	}
	
	@After(value = "execution(* com.shaik.springbootaop.service.BookService.*(..)) and args(title, bookId)")
	public void afterAdvice(JoinPoint joinPoint, String title, String bookId) {
		System.out.println("After method : " + joinPoint.getSignature());	
	    
	}
	
	@AfterReturning(value = "execution(* com.shaik.springbootaop.service.BookService.*(..)) and args(bookId)")
	public void afterReturningAdvice(JoinPoint joinPoint, String bookId) {
		System.out.println("After Returning method : " + joinPoint.getSignature());	
	}
	
	
}
