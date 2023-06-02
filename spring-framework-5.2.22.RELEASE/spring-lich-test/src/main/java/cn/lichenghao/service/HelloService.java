package cn.lichenghao.service;

import org.springframework.stereotype.Component;

/**
 * 编译后的第一个接口
 *
 * @author chenghao.li
 */
@Component
public class HelloService {
	public void say() {
		System.out.println("hello world");
	}
}