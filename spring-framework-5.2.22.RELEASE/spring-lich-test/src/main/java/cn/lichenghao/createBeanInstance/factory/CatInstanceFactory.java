package cn.lichenghao.createBeanInstance.factory;


import cn.lichenghao.createBeanInstance.entity.Cat;

public class CatInstanceFactory {
	public Cat getCat(String name, int age) {
		Cat cat = new Cat();
		cat.setName(name);
		cat.setAge(age);
		return cat;
	}
}
