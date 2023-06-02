package cn.lichenghao;

import cn.lichenghao.context.MyApplicationContext2;
import cn.lichenghao.customtag.Keyboard;
import cn.lichenghao.entity.User;
import cn.lichenghao.replacedmethod.OrgMethod;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.convert.ConversionService;

import java.time.LocalDateTime;

public class BeanTests {

	@DisplayName("自定义转换器")
	@Test
	public void convert() {
		// 根据注解加载bean
		AnnotationConfigApplicationContext context
				= new AnnotationConfigApplicationContext("cn.lichenghao.converter");
		ConversionService conversionService = context.getBeanFactory().getConversionService();
		LocalDateTime convert = conversionService.convert("2023-01-21 13:36:28", LocalDateTime.class);
		System.out.println(convert);
	}

	@DisplayName("测试循环依赖")
	@Test
	public void cycle() {
		AnnotationConfigApplicationContext context
				= new AnnotationConfigApplicationContext("cn.lichenghao.entity.s");
	}

	@DisplayName("测试创建Bean")
	@Test
	public void createBean() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("s.xml");
	}

	@DisplayName("测试扩展 postProcessBeanFactory")
	@Test
	public void myApplicationContextTest() {
		MyApplicationContext2 myApplicationContext = new MyApplicationContext2("bean2.xml");
		User user = myApplicationContext.getBean(User.class);
		user.sayHello();
	}


	@DisplayName("测试 replaced-method")
	@Test
	public void replaceMethodTest() {
		ClassPathXmlApplicationContext context
				= new ClassPathXmlApplicationContext("replacemethod.xml");
		OrgMethod orgMethod = context.getBean(OrgMethod.class);
		orgMethod.change();
	}

	@DisplayName("测试自定义标签")
	@Test
	public void customTagTest() {
		ClassPathXmlApplicationContext context
				= new ClassPathXmlApplicationContext("customtag/keyboard.xml");
		Keyboard keyboard = context.getBean(Keyboard.class);
		System.out.println(keyboard);
	}
}
