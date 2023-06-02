package cn.lichenghao.aop.jdk;

import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK动态代理
 *
 * @author lichlaughing
 */
@Component
public class JDKServiceDynamicProxy implements InvocationHandler {

	private Object target;

	public void setTarget(Object target) {
		this.target = target;
	}

	/**
	 * @param proxy  代理对象
	 * @param method 方法
	 * @param args   参数
	 * @return Object
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
		System.out.println("UserServiceDynamicProxy before do");
		Object result = method.invoke(target, args);
		System.out.println("UserServiceDynamicProxy after do");
		return result;
	}

	public Object getProxyInstance() {
		return Proxy.newProxyInstance(target.getClass().getClassLoader()
				, target.getClass().getInterfaces(), this);
	}
}
