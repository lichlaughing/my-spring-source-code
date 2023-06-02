package cn.lichenghao.aop.jdk.service.impl;

import cn.lichenghao.aop.jdk.service.UserService;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Override
	public void save(int a) {
		System.out.println("save 方法执行");
	}

	@Override
	public void get() {
		System.out.println("get 方法执行");
	}

	@Override
	public void delete(int id) {
		System.out.println("delete 方法执行");
	}
}
