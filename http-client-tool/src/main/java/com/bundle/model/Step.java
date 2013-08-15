package com.bundle.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

@XmlType
public class Step {

	private List<FaultRule> faultRules;

	private String condition;

	private String name;

	public List<FaultRule> getFaultRules() {
		return faultRules;
	}

	@XmlElementWrapper(name = "FaultRules")
	@XmlElement(name = "FaultRule")
	public void setFaultRules(List<FaultRule> faultRules) {
		this.faultRules = faultRules;
	}

	public String getCondition() {
		return condition;
	}

	@XmlElement(name = "Condition")
	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getName() {
		return name;
	}

	@XmlElement(name = "Name")
	public void setName(String name) {
		this.name = name;
	}
}
