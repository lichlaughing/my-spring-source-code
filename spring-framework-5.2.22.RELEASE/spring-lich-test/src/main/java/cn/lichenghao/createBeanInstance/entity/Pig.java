package cn.lichenghao.createBeanInstance.entity;

import java.beans.ConstructorProperties;

public class Pig {
	private String id;
	private String name;
	private int age;
	private double height;

	public Pig() {
	}

	public Pig(String id) {
		this.id = id;
	}

	@ConstructorProperties({"name", "age"})
	public Pig(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public Pig(String id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public Pig(String id, String name, int age, double height) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.height = height;
	}

	@Override
	public String toString() {
		return "Pig{" +
				"id='" + id + '\'' +
				", name='" + name + '\'' +
				", age=" + age +
				", height=" + height +
				'}';
	}
}
