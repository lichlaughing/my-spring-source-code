package cn.lichenghao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.PropertyEditorRegistrySupport;

import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@DisplayName("自定义属性解析器及注册测试")
public class PropertyEditorRegistryTest {

	@Test
	public void customPropertyEditorRegistryTest() {
		// 注册解析器
		PropertyEditorRegistrySupport registrySupport = new PropertyEditorRegistrySupport();
		registrySupport.registerCustomEditor(ConfigInfo.class, new CustomPropertyEditorRegistry());

		// 解析属性测试
		PropertyEditor customEditor = registrySupport.findCustomEditor(ConfigInfo.class, null);
		customEditor.setAsText("treasure,soul");
		ConfigInfo value = (ConfigInfo) customEditor.getValue();
		System.out.println(value);
	}

	/**
	 * 自定义属性解析器
	 */
	static class CustomPropertyEditorRegistry extends PropertyEditorSupport {

		private String text;

		@Override
		public void setAsText(String text) throws IllegalArgumentException {
			this.text = text;
		}

		@Override
		public Object getValue() {
			ConfigInfo configInfo = new ConfigInfo();
			configInfo.setWords(Arrays.stream(text.split(",")).collect(Collectors.toList()));
			return configInfo;
		}
	}

	static class ConfigInfo {
		private List<String> words;

		public ConfigInfo() {
		}

		public void setWords(List<String> words) {
			this.words = words;
		}

		@Override
		public String toString() {
			return "ConfigInfo{" +
					"words=" + words +
					'}';
		}
	}
}
