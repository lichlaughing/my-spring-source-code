package cn.lichenghao;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 编译后的第一个Hello World
 *
 * @author chenghao.li
 */
public class AppDog {
	public static void main(String[] args) {
		// 根据配置文件加载bean
		ClassPathXmlApplicationContext classPathXmlApplicationContext
				= new ClassPathXmlApplicationContext("dog.xml");
	}
}