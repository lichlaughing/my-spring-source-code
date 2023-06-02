package cn.lichenghao.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * 注解AOP
 *
 * @author lichlaughing
 */
@Component("speLogger")
@EnableAspectJAutoProxy
@Aspect
public class AopLogger2 {

	@Pointcut(value = "execution(* cn.lichenghao.aop.jdk.service.impl.*.*(..))")
	public void pt() {
	}

	@Before("pt()")
	public void beforeOrgLogger() {
		System.out.println("前置通知 Executed !");
	}

	@AfterReturning("pt()")
	public void afterReturnOrgLogger() {
		System.out.println("后置通知 Executed !");
	}

	@AfterThrowing("pt()")
	public void throwOrgLogger() {
		System.out.println("异常通知 Executed !");
	}

	@After("pt()")
	public void afterOrgLogger() {
		System.out.println("最终通知 Executed !");
	}

	//@Around("pt()")
	public Object aroundOrgLogger(ProceedingJoinPoint proceedingJoinPoint) {
		Object data = null;
		try {
			System.out.println("前置通知");
			Object[] args = proceedingJoinPoint.getArgs();
			data = proceedingJoinPoint.proceed(args);
			System.out.println("后置通知");
		} catch (Throwable e) {
			System.out.println("异常通知");
		} finally {
			System.out.println("最终通知");
		}
		return data;
	}
}
