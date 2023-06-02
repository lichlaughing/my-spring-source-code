package cn.lichenghao.context;

import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 自定义
 *
 * @author chenghao.li
 */
public class MyApplicationContext extends ClassPathXmlApplicationContext {

	public MyApplicationContext(String configLocation) throws BeansException {
		super(configLocation);
	}

	@Override
	protected void initPropertySources() {
		getEnvironment().setRequiredProperties("ABC");
		super.initPropertySources();
	}
}