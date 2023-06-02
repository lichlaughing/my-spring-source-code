package cn.lichenghao.customtag;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class MyNameSpaceHandler extends NamespaceHandlerSupport {

	@Override
	public void init() {
		registerBeanDefinitionParser("keyboard", new KeyboardDefinitionParser());
	}
}
