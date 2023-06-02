package cn.lichenghao.context;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 自定义ApplicationContext,重载postProcessBeanFactory可以操作元数据
 *
 * @author chenghao.li
 */
public class MyApplicationContext2 extends ClassPathXmlApplicationContext {

	public MyApplicationContext2(String configLocation) throws BeansException {
		super(configLocation);
	}

	@Override
	protected void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) {
		int beanDefinitionCount = beanFactory.getBeanDefinitionCount();
		System.out.println("beanDefinitionCount：" + beanDefinitionCount);
	}
}