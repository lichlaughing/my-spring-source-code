package cn.lichenghao.context;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.core.Ordered;

/**
 * 自定义扩展
 *
 * @author chenghao.li
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor, Ordered {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		int beanDefinitionCount = beanFactory.getBeanDefinitionCount();
		System.out.println("MyBeanFactoryPostProcessor beanDefinitionCount:" + beanDefinitionCount);
	}

	@Override
	public int getOrder() {
		return 0;
	}
}