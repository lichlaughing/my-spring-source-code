package cn.lichenghao.aop.cglib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MyMethodInterceptor implements MethodInterceptor {

	@Override
	public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
		System.out.println("cglib proxy before do");
		Object result = methodProxy.invokeSuper(o, objects);
		System.out.println("cglib proxy after do");
		return result;
	}
}
