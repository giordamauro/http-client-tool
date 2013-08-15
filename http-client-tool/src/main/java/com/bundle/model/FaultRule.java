package com.bundle.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
public class FaultRule {

	private String name;

	private String condition;

	private List<Step> steps;

	public String getName() {
		return name;
	}

	@XmlAttribute
	public void setName(String name) {
		this.name = name;
	}

	public String getCondition() {
		return condition;
	}

	@XmlElement(name = "Condition")
	public void setCondition(String condition) {
		this.condition = condition;
	}

	public List<Step> getSteps() {
		return steps;
	}

	@XmlElement(name = "Step")
	public void setSteps(List<Step> steps) {
		this.steps = steps;
	}

}
