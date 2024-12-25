package springAOP.LoggingAspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import springAOP.Entity.Student;


@Component
@Aspect
public class LoggingAspect {
	
	private static final Logger LOGGER =LoggerFactory.getLogger(LoggingAspect.class);
	
	@Pointcut("execution( * springAOP.Service.StudentService.saveStudent(..))")
	 private void Pointcut() {}
	

	@Before("Pointcut()")
//	@Before("execution( * springAOP.Service.StudentService.saveStudent(..))")
//	@After("execution( * springAOP.Service.StudentService.saveStudent(..))")
//	@AfterReturning("execution( * springAOP.Service.StudentService.saveStudent(..))") No exception
//	@AfterThrowing("execution( * springAOP.Service.StudentService.saveStudent(..))") after exception
	public void print(JoinPoint j) {
		LOGGER.info("called" + "  " + j.getSignature().getName());
		System.out.println(j.getSignature().getName());
	}
	
	
	@Around("execution( * springAOP.Service.StudentService.saveStudent(..)) && args(student)")
//	@Around("execution( * springAOP.Service.StudentService.saveStudent(..))")

	public Object calculatetmethodexecution(ProceedingJoinPoint pjp,Student student) throws Throwable {
//	public Object calculatetmethodexecution(ProceedingJoinPoint pjp) throws Throwable {
		
		long start = System.currentTimeMillis();

		LOGGER.info(" Start time ==== " + (start) );
		
	Object obj=	pjp.proceed();
		
		long end = System.currentTimeMillis();
		
		if(student.getName().equals("sushant")) {
		student.setName("sush");
		}
		LOGGER.info(" End time ==== " + (end) );
		
		LOGGER.info("time ==== " + (end-start)+ "  "+ student.getName() );
		
		
		return obj;
	}
	
	
	
	
// SPRING create proxy object for that class
//    proxy object call first and then real object will be called. 
	//proxy object maintain Aop call
	

	// Around execute  before and After 
	
//	  ('return type' 'class-name.method-name(args)')
//			/\	   	      /\
//			|---------	  |
//				  	  |   |
//@Before("execution( *  springAOP.Service.StudentService.*(..) || (or && ) *  springAOP.product.StudentService.*(..)  ")
	     // within
		// @within
		// target
	    // @target
		// @anotation
		// arg
		// @arg
}
