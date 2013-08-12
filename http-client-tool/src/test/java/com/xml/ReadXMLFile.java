package com.xml;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

public class ReadXMLFile {

	public static final class Timestamp {

		private long time;

		private Map<String, String> properties;

		private int executionTime;

		public Long getTime() {
			return time;
		}

		public void setTime(Long time) {
			this.time = time;
		}

		public Map<String, String> getProperties() {
			return properties;
		}

		public void setProperties(Map<String, String> properties) {
			this.properties = properties;
		}

		public Timestamp(Long time, Map<String, String> properties) {
			super();
			this.time = time;
			this.properties = properties;
		}

		public String toString() {
			return String.valueOf(time) + " - " + properties.toString() + " : " + executionTime;
		}

		public int getExecutionTime() {
			return executionTime;
		}

		public void setExecutionTime(int executionTime) {
			this.executionTime = executionTime;
		}
	}

	public static void main(String[] args) {

		String filePath = "c:\\xmlFile.xml";
		Element rootNode = getRootelement(filePath);

		List<Element> points = getChildren(rootNode, "Point");

		List<Timestamp> timeStamps = new ArrayList<Timestamp>();

		for (Element point : points) {
			String pointId = point.getAttributeValue("id");
			if (!pointId.equals("Paused") && !pointId.equals("Resumed")) {
				Element debugInfo = point.getChild("DebugInfo");
				Element timeStamp = debugInfo.getChild("Timestamp");
				String timestamp = timeStamp.getValue();

				Long time = getTimestampInMs(timestamp);

				Map<String, String> properties = getProperties(debugInfo.getChild("Properties"));

				Timestamp dto = new Timestamp(time, properties);

				timeStamps.add(dto);
			}
		}

		long lastTime = 0;
		for (Timestamp stamp : timeStamps) {
			int exec = (int) (stamp.getTime() - lastTime);
			stamp.setExecutionTime(exec);

			lastTime = stamp.getTime();
			System.out.println(exec + ": " + stamp.getProperties());
		}

	}

	private static Long getTimestampInMs(String timestamp) {

		try {
			Date date = new SimpleDateFormat("MM-dd-yy HH:mm:ss:SSS").parse(timestamp);
			return date.getTime();

		} catch (ParseException e) {
			throw new IllegalStateException(e);
		}
	}

	private static Map<String, String> getProperties(Element info) {

		Map<String, String> map = new HashMap<String, String>();

		List<Element> properties = getChildren(info, "Property");
		for (Element property : properties) {
			String name = property.getAttributeValue("name");
			String value = property.getValue();

			map.put(name, value);
		}
		return map;
	}

	private static Element getRootelement(String file) {
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

	private static List<Element> getChildren(Element element, String name) {

		@SuppressWarnings("unchecked")
		List<Element> list = (List<Element>) element.getChildren(name);

		return list;
	}
}