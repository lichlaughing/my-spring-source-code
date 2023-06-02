package cn.lichenghao;

import cn.lichenghao.createBeanInstance.entity.Cat;
import cn.lichenghao.createBeanInstance.entity.Dog;
import cn.lichenghao.createBeanInstance.entity.Pig;
import cn.lichenghao.createBeanInstance.supplier.SuA;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@DisplayName("创建Bean实例测试")
public class CreateBeanInstanceTest {

	@DisplayName("自定义supplier")
	@Test
	public void supplierTest() {
		// 根据配置文件加载bean
		ClassPathXmlApplicationContext classPathXmlApplicationContext
				= new ClassPathXmlApplicationContext("createBeanInstance/supplier-test.xml");
		SuA bean = classPathXmlApplicationContext.getBean(SuA.class);
		System.out.println(bean);
	}

	@DisplayName("测试factoryMethod")
	@Test
	public void factoryMethodTest() {
		ClassPathXmlApplicationContext classPathXmlApplicationContext
				= new ClassPathXmlApplicationContext("createBeanInstance/factory-method.xml");
		Cat cat = classPathXmlApplicationContext.getBean(Cat.class);
		System.out.println(cat);
		Dog dog = classPathXmlApplicationContext.getBean(Dog.class);
		System.out.println(dog);
	}

	@DisplayName("构造函数创建bean")
	@Test
	public void constructorTest() {
		// 根据配置文件加载bean
		ClassPathXmlApplicationContext classPathXmlApplicationContext
				= new ClassPathXmlApplicationContext("createBeanInstance/constructor.xml");
		Pig bean = classPathXmlApplicationContext.getBean(Pig.class);
		System.out.println(bean);
	}
}
