package cn.lichenghao.aop;

import cn.lichenghao.aop.cglib.CglibDynamicProxy;
import cn.lichenghao.aop.cglib.MyMethodInterceptor;
import cn.lichenghao.aop.jdk.JDKServiceDynamicProxy;
import cn.lichenghao.aop.jdk.UserServiceProxy;
import cn.lichenghao.aop.jdk.service.UserService;
import cn.lichenghao.aop.jdk.service.impl.UserServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@DisplayName("代理模式测试")
public class ProxyTest {

	@DisplayName("JDK静态代理")
	@Test
	public void jdkStaticProxy() {
		AnnotationConfigApplicationContext context
				= new AnnotationConfigApplicationContext("cn.lichenghao.aop");
		UserServiceProxy userServiceProxy = context.getBean(UserServiceProxy.class);
		userServiceProxy.save(1);
	}

	@DisplayName("JDK动态代理")
	@Test
	public void jdkDynamicProxy() {
		AnnotationConfigApplicationContext context
				= new AnnotationConfigApplicationContext("cn.lichenghao.aop");
		// 目标对象
		UserService userService = (UserService) context.getBean("userService");
		// 代理对象
		JDKServiceDynamicProxy dynamicProxy
				= context.getBean(JDKServiceDynamicProxy.class);
		dynamicProxy.setTarget(userService);
		UserService userServiceProxy = (UserService) dynamicProxy.getProxyInstance();
		// 执行测试方法
		userServiceProxy.save(1);
	}

	@DisplayName("CGLIB动态代理")
	@Test
	public void cglibDynamicProxy() {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(UserServiceImpl.class);
		enhancer.setCallback(new MyMethodInterceptor());
		UserService userServiceProxy = (UserService) enhancer.create();
		userServiceProxy.save(1);
	}

	@DisplayName("CGLIB动态代理")
	@Test
	public void cglibDynamicProxy2() {
		CglibDynamicProxy cglibDynamicProxy = new CglibDynamicProxy();
		cglibDynamicProxy.setParentClass(UserServiceImpl.class);
		UserService proxyInstance = (UserService) cglibDynamicProxy.getProxyInstance();
		proxyInstance.save(1);
	}
}
