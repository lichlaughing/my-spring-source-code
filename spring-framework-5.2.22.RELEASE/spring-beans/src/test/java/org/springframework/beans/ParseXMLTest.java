package org.springframework.beans;

import org.junit.jupiter.api.Test;
import org.springframework.core.io.InputStreamResource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 测试解析XML配置文件
 */
public class ParseXMLTest {
	@Test
	public void parse() {
		try {
			// 1、获取XML资源
			InputStream in = new InputStreamResource(getClass().getResourceAsStream("ParseXMLTest.xml")).getInputStream();
			// 2、获取DocumentBuilderFactory实例
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			// 3、获取DocumentBuilder实例
			DocumentBuilder docBuilder = factory.newDocumentBuilder();
			// 4、将docBuilder转换为Document
			Document doc = docBuilder.parse(in);
			// 5、获取节点并循环输出节点值
			Element element = doc.getDocumentElement();
			NodeList childNodes = element.getChildNodes();
			// 解析，测试拿一些数据
			for (int i = 0; i < childNodes.getLength(); i++) {
				Node node = childNodes.item(i);
				NamedNodeMap attributesMap = node.getAttributes();
				if (null != attributesMap) {
					System.out.println(attributesMap.getNamedItem("id"));
					System.out.println(attributesMap.getNamedItem("class"));
				}
			}
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}
}