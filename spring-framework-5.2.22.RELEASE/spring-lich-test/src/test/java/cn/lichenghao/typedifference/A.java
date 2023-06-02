package cn.lichenghao.typedifference;

import org.springframework.util.MethodInvoker;

/**
 * 测试方法 MethodInvoker.getTypeDifferenceWeight
 *
 * @author lichlaughing
 */
public class A extends B implements D {
	public static void main(String[] args) {
		Object[] myArgs = new Object[]{new A()};
		// 参数类型为A，完全匹配 0
		System.out.println(MethodInvoker.getTypeDifferenceWeight(new Class[]{A.class}, myArgs));
		// 参数类型为B，父类匹配 2
		System.out.println(MethodInvoker.getTypeDifferenceWeight(new Class[]{B.class}, myArgs));
		// 参数类型为C，父父匹配 4
		System.out.println(MethodInvoker.getTypeDifferenceWeight(new Class[]{C.class}, myArgs));
		// 参数类型为D，接口匹配 1
		System.out.println(MethodInvoker.getTypeDifferenceWeight(new Class[]{D.class}, myArgs));
	}
}