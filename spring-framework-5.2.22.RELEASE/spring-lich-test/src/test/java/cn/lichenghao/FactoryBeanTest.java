package cn.lichenghao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@DisplayName("工厂Bean测试↓")
public class FactoryBeanTest {
	@Test
	public void test() {
		// 根据配置文件加载bean
		ClassPathXmlApplicationContext context
				= new ClassPathXmlApplicationContext("factoryBean.xml");
		// 直接获取userFactoryBean得到的是其getObject返回的对象
		Object obj1 = context.getBean("userFactoryBean");
		// 加&前缀，获取到FactoryBean实例
		Object obj2 = context.getBean("&userFactoryBean");
		System.out.println(obj1);
		System.out.println(obj2);
	}
}
