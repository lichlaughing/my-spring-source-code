package cn.lichenghao.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class AopLogger {

	public void beforeOrgLogger() {
		System.out.println("前置通知 Executed !");
	}

	public void afterReturnOrgLogger() {
		System.out.println("后置通知 Executed !");
	}


	public void throwOrgLogger() {
		System.out.println("异常通知 Executed !");
	}


	public void afterOrgLogger() {
		System.out.println("最终通知 Executed !");
	}

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
