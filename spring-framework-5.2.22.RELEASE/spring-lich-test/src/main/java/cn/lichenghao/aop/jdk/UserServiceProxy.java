package cn.lichenghao.aop.jdk;

import cn.lichenghao.aop.jdk.service.UserService;
import cn.lichenghao.aop.jdk.service.impl.UserServiceImpl;
import org.springframework.stereotype.Component;

/**
 * JDK静态代理
 *
 * @author lichlaughing
 */
@Component
public class UserServiceProxy implements UserService {

	private final UserServiceImpl userService = new UserServiceImpl();

	@Override
	public void save(int a) {
		System.out.println("proxy save method invoke");
		userService.save(a);
	}

	@Override
	public void get() {

	}

	@Override
	public void delete(int id) {

	}
}
