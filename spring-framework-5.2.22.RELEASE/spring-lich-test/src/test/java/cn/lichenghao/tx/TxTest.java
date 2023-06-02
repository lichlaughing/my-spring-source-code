package cn.lichenghao.tx;

import cn.lichenghao.tx.entity.UserInfo;
import cn.lichenghao.tx.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@DisplayName("事务测试")
public class TxTest {

	@Test
	public void userList() {
		ClassPathXmlApplicationContext context
				= new ClassPathXmlApplicationContext("tx/application.xml");
		UserService userService = context.getBean(UserService.class);
		System.out.println(userService.listUser());
	}

	@DisplayName("基于XML的事务")
	@Test
	public void addUser() {
		ClassPathXmlApplicationContext context
				= new ClassPathXmlApplicationContext("tx/application.xml");
		UserService userService = context.getBean(UserService.class);
		UserInfo user = new UserInfo(4, "44", "44");
		System.out.println(userService.addUser(user));
	}

	@DisplayName("基于注解的事务")
	@Test
	public void addUser2() {
		ClassPathXmlApplicationContext context
				= new ClassPathXmlApplicationContext("tx/application2.xml");
		UserService userService = context.getBean(UserService.class);
		UserInfo user = new UserInfo(5, "55", "55");
		System.out.println(userService.addUser2(user));
	}
}
