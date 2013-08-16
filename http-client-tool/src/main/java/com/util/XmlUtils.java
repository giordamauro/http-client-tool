package com.util;

import java.io.File;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

public final class XmlUtils {

	private XmlUtils() {
	}

	public static Element getRootelement(String file) {
		SAXBuilder builder = new SAXBuilder();
		try {
			File xmlFile = new File(file);
			Document document = (Document) builder.build(xmlFile);
			Element rootNode = document.getRootElement();
			return rootNode;
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}

	public static List<Element> getChildren(Element element, String name) {

		@SuppressWarnings("unchecked")
		List<Element> list = (List<Element>) element.getChildren(name);

		return list;
	}
}
