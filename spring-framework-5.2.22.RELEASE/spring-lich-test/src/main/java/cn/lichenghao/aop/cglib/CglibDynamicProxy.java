package cn.lichenghao.aop.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibDynamicProxy implements MethodInterceptor {

	private Class<?> parentClass;

	public void setParentClass(Class<?> parentClass) {
		this.parentClass = parentClass;
	}

	@Override
	public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
		System.out.println("cglib proxy before do");
		Object result = methodProxy.invokeSuper(o, objects);
		System.out.println("cglib proxy after do");
		return result;
	}

	public Object getProxyInstance() {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(parentClass);
		enhancer.setCallback(this);
		return enhancer.create();
	}
}
