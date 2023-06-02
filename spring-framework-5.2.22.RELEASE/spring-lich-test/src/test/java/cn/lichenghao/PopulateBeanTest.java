package cn.lichenghao;

import cn.lichenghao.populateBean.entity.Dog;
import cn.lichenghao.populateBean.service.AutowireByNameService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@DisplayName("Bean对象属性填充相关测试↓")
public class PopulateBeanTest {

	@DisplayName("自定义InstantiationAwareBeanPostProcessor")
	@Test
	public void OrgInstantiationAwareBeanPostProcessor() {
		ClassPathXmlApplicationContext classPathXmlApplicationContext
				= new ClassPathXmlApplicationContext("populateBean/InstantiationAwareBeanPostProcessor.xml");
		Dog dog = classPathXmlApplicationContext.getBean(Dog.class);
		System.out.println(dog.getName());
	}


	@DisplayName("测试根据属性名称注入")
	@Test
	public void autowireByNameServiceTest() {
		ClassPathXmlApplicationContext classPathXmlApplicationContext
				= new ClassPathXmlApplicationContext("populateBean/s1.xml");
		AutowireByNameService bean = classPathXmlApplicationContext.getBean(AutowireByNameService.class);
		bean.doSomething();
	}
}
