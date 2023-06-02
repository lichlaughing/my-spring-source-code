package cn.lichenghao;

import org.assertj.core.util.Lists;
import org.assertj.core.util.Maps;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.PropertyValue;
import org.springframework.core.convert.TypeDescriptor;

import java.util.List;
import java.util.Map;

@DisplayName("测试对Bean属性的读写能力")
public class PropertyAccessorTest {

	@Test
	public void beanWrapperTest() {
		Car car = new Car();
		car.setName("笨笨");
		car.setWeight(1000D);
		car.setLabels(Lists.list("a,b,c"));
		car.setProps(Maps.newHashMap("color", "red"));

		BeanWrapper beanWrapper = new BeanWrapperImpl(car);
		Class<?> type = beanWrapper.getPropertyType("type");
		System.out.println("获取属性type：" + type);

		boolean readName = beanWrapper.isReadableProperty("name");
		System.out.println("属性name是否可读：" + readName);

		boolean writeWeight = beanWrapper.isWritableProperty("weight");
		System.out.println("属性weight是否可写：" + writeWeight);

		TypeDescriptor typeDescriptor = beanWrapper.getPropertyTypeDescriptor("labels");
		System.out.println("属性描述器：" + typeDescriptor);

		Object props = beanWrapper.getPropertyValue("props");
		System.out.println("获取属性props值：" + (Map<String, Object>) props);

		beanWrapper.setPropertyValue("name", "1234");
		System.out.println("设置name属性值为 1234");
		System.out.println(car);

		PropertyValue weight = new PropertyValue("weight", 20D);
		beanWrapper.setPropertyValue(weight);
		System.out.println("设置weight属性值为 20");
		System.out.println(car);
	}


	static class Car {
		private String name;
		private double weight;
		private Map<String, Object> props;
		private List<String> labels;

		public Car() {
		}

		public void setName(String name) {
			this.name = name;
		}

		public void setWeight(double weight) {
			this.weight = weight;
		}

		public void setProps(Map<String, Object> props) {
			this.props = props;
		}

		public void setLabels(List<String> labels) {
			this.labels = labels;
		}

		public Map<String, Object> getProps() {
			return props;
		}

		@Override
		public String toString() {
			return "Car{" +
					"name='" + name + '\'' +
					", weight=" + weight +
					", props=" + props +
					", labels=" + labels +
					'}';
		}
	}
}
