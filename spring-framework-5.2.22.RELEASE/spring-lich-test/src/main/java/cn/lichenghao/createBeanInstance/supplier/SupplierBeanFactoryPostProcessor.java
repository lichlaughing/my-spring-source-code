package cn.lichenghao.createBeanInstance.supplier;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;

public class SupplierBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		BeanDefinition beanDefinition = beanFactory.getBeanDefinition("sua");
		GenericBeanDefinition genericBeanDefinition = (GenericBeanDefinition) beanDefinition;
		genericBeanDefinition.setInstanceSupplier(OrgSupplier::create);
		genericBeanDefinition.setBeanClass(SuA.class);
	}
}
