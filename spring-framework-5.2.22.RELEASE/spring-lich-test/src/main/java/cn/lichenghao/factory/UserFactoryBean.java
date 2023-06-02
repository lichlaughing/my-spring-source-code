package cn.lichenghao.factory;

import cn.lichenghao.entity.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * 自定义FactoryBean
 *
 * @author lichlaughing
 */
public class UserFactoryBean implements FactoryBean<User> {
	private static final User instance = new User();

	@Override
	public User getObject() throws Exception {
		instance.setName("nb!");
		return instance;
	}

	@Override
	public Class<?> getObjectType() {
		return User.class;
	}
}
