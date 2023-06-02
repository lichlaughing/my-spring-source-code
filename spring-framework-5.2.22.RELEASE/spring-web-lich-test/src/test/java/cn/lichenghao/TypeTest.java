package cn.lichenghao;

import javafx.util.Pair;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.core.MethodParameter;
import org.springframework.core.Ordered;
import org.springframework.core.ResolvableType;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class TypeTest {

	static class Animal<T> {
		public String name;
		public List<Pair<String, String>> propList;
	}

	static class Dog extends Animal<TypeTest> implements Serializable {
		private static final long serialVersionUID = 8833550896791988000L;

		public Dog() {

		}

		public Dog(String name) {

		}

		public Dog(List<Pair<String, String>> propList) {

		}

		public String say(List<Pair<String, String>> propList) {
			return "OK";
		}

		public String say2(List<Pair<String, String>> propList, Map<String, Ordered> map) {
			return "OK";
		}
	}

	/**
	 * Class获取Type
	 */
	@Test
	public void test1() {
		Dog dog = new Dog();
		System.out.println(dog.getClass().getSuperclass());
		System.out.println(dog.getClass().getGenericSuperclass());
		System.out.println(Arrays.toString(dog.getClass().getGenericInterfaces()));
		// class cn.lichenghao.TypeTest$Animal
		// cn.lichenghao.TypeTest$Animal<cn.lichenghao.TypeTest>
		// [interface java.io.Serializable]
	}

	/**
	 * Field获取Type
	 */
	@Test
	public void test2() {
		Dog dog = new Dog();
		Field[] fields = dog.getClass().getFields();
		for (Field field : fields) {
			System.out.println(field.getType() + "--" + field.getGenericType());
		}
		// class java.lang.String--class java.lang.String
		// interface java.util.List--java.util.List<javafx.util.Pair<java.lang.String, java.lang.String>>
	}

	/**
	 * Method获取Type
	 */
	@Test
	public void test3() throws NoSuchMethodException {
		Dog dog = new Dog();
		Method methodSay = dog.getClass().getMethod("say", List.class);
		System.out.println(Arrays.toString(methodSay.getParameterTypes()));
		System.out.println(Arrays.toString(methodSay.getGenericParameterTypes()));
		// [interface java.util.List]
		// [java.util.List<javafx.util.Pair<java.lang.String, java.lang.String>>]

		for (Constructor<?> constructor : dog.getClass().getConstructors()) {
			System.out.println(Arrays.toString(constructor.getGenericParameterTypes()));
		}
		// []
		// [java.util.List<javafx.util.Pair<java.lang.String, java.lang.String>>]
		// [class java.lang.String]
	}

	/**
	 * 测试 ResolvableType
	 */
	@Test
	public void test10() throws NoSuchFieldException, NoSuchMethodException {
		Dog dog = new Dog();

		// 根据实例创建 ResolvableType
		ResolvableType resolvableTypeDog = ResolvableType.forInstance(dog);
		System.out.println(resolvableTypeDog.getType());
		System.out.println(Arrays.toString(resolvableTypeDog.getGenerics()));
		// class cn.lichenghao.TypeTest$Dog
		// []

		// 根据原始类型 Class 创建 ResolvableType
		ResolvableType resolvableTypeClass = ResolvableType.forClass(dog.getClass());
		System.out.println(resolvableTypeClass.getType());
		System.out.println(Arrays.toString(resolvableTypeClass.getGenerics()));
		// class cn.lichenghao.TypeTest$Dog
		// []

		// 根据成员变量创建 ResolvableType
		ResolvableType resolvableTypeProp = ResolvableType.forField(dog.getClass().getField("propList"));
		System.out.println(resolvableTypeProp.getType());
		System.out.println(Arrays.toString(resolvableTypeProp.getGenerics()));
		// java.util.List<javafx.util.Pair<java.lang.String, java.lang.String>>
		// [javafx.util.Pair<java.lang.String, java.lang.String>]

		// 根据Method创建 ResolvableType
		System.out.println("根据Method创建 ResolvableType ==");
		MethodParameter methodParameter = MethodParameter.forParameter(dog.getClass().getMethod("say2", List.class, Map.class).getParameters()[1]);
		ResolvableType resolvableTypeSay =
				ResolvableType.forMethodParameter(methodParameter);
		System.out.println(resolvableTypeSay.getType());
		System.out.println(Arrays.toString(resolvableTypeSay.getGenerics()));
		// java.util.Map<java.lang.String, org.springframework.core.Ordered>
		// [java.lang.String, org.springframework.core.Ordered]
	}
}