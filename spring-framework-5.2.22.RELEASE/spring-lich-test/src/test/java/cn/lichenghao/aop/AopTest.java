package cn.lichenghao.aop;

import cn.lichenghao.aop.jdk.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@DisplayName("AOP测试")
public class AopTest {

	@DisplayName("xml配置文件AOP测试,基于配置")
	@Test
	public void xmlAopTest() {
		// 存储生成的字节码文件
		//String path = "/Users/lichenghao/my/mysite/study-code/spring-source-code/spring-framework-5.2.22.RELEASE/spring-lich-test/src/test/java/cn/lichenghao/aop/cglib";
		//System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, path);

		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("aop/application.xml");
		UserService bean = context.getBean(UserService.class);
		bean.save(1);
	}

	@DisplayName("xml配置文件AOP测试，基于aspectj注解")
	@Test
	public void xmlAopTest2() {
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("aop/application2.xml");
		UserService bean = context.getBean(UserService.class);
		bean.save(1);
	}

	@DisplayName("注解AOP测试")
	@Test
	public void annotationAopTest() {
		AnnotationConfigApplicationContext context
				= new AnnotationConfigApplicationContext("cn.lichenghao.aop");
		UserService user = (UserService) context.getBean("userService");
		user.save(1);
	}
}
