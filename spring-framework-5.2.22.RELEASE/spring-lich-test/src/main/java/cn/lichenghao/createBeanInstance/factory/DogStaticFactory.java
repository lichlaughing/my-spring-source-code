package cn.lichenghao.createBeanInstance.factory;


import cn.lichenghao.createBeanInstance.entity.Dog;

public class DogStaticFactory {
	public static Dog getDog(String name, int age) {
		Dog dog = new Dog();
		dog.setName(name);
		dog.setAge(age);
		return dog;
	}
}
