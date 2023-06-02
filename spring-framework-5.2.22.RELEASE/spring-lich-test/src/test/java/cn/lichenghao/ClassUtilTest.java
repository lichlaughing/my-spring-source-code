package cn.lichenghao;

import org.junit.jupiter.api.Test;
import org.springframework.util.ClassUtils;

public class ClassUtilTest {

	@Test
	public void t1() {
		// A 和 B 均为 Class 对象，判断 B 是否等于/继承/实现A，是返回 TRUE；
		// TRUE
		System.out.println(ClassUtils.isAssignable(A.class, B.class));
		// TRUE
		System.out.println(ClassUtils.isAssignable(C.class, A.class));
	}

	static class A implements C {

	}

	static class B extends A {

	}

	interface C {

	}

	@Test
	public void t2() {
		// 如果 A 是基本类型比如(int.Class)，认为 B 是基本类型的包装类，获取其基本类型比较；
		System.out.println(int.class.isPrimitive());
		System.out.println(ClassUtils.isAssignable(int.class, Double.class));
		System.out.println(ClassUtils.isAssignable(int.class, Integer.class));
	}

	@Test
	public void t3() {
		// A 不是基本类型，那么可能是包装类，获取 rhsType 包装类对比
		System.out.println(ClassUtils.isAssignable(Integer.class, Double.class));
		System.out.println(ClassUtils.isAssignable(Integer.class, int.class));
	}
}
