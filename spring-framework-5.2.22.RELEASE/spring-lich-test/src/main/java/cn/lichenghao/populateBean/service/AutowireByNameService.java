package cn.lichenghao.populateBean.service;

import cn.lichenghao.populateBean.entity.Dog;
import org.springframework.stereotype.Component;

@Component
public class AutowireByNameService {

	private Dog dog;

	public void setDog(Dog dog) {
		this.dog = dog;
	}

	public void doSomething() {
		dog.say();
	}
}
