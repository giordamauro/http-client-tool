package com.bundle.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "RouteRule")
public class RouteRule {

	private String name;

	private String targetEndpoint;

	private String condition;

	public String getName() {
		return name;
	}

	@XmlAttribute
	public void setName(String name) {
		this.name = name;
	}

	public String getTargetEndpoint() {
		return targetEndpoint;
	}

	@XmlElement(name = "TargetEndpoint")
	public void setTargetEndpoint(String targetEndpoint) {
		this.targetEndpoint = targetEndpoint;
	}

	public String getCondition() {
		return condition;
	}

	@XmlElement(name = "Condition")
	public void setCondition(String condition) {
		this.condition = condition;
	}

}
