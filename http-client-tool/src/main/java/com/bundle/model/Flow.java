package com.bundle.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

@XmlType
public class Flow {

	private String name;

	private String description;

	private String condition;

	private List<Step> requestSteps;

	private List<Step> responseSteps;

	public String getName() {
		return name;
	}

	@XmlAttribute
	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	@XmlElement(name = "Description")
	public void setDescription(String description) {
		this.description = description;
	}

	public String getCondition() {
		return condition;
	}

	@XmlElement(name = "Condition")
	public void setCondition(String condition) {
		this.condition = condition;
	}

	public List<Step> getRequestSteps() {
		return requestSteps;
	}

	@XmlElementWrapper(name = "Request")
	@XmlElement(name = "Step")
	public void setRequestSteps(List<Step> requestSteps) {
		this.requestSteps = requestSteps;
	}

	public List<Step> getResponseSteps() {
		return responseSteps;
	}

	@XmlElementWrapper(name = "Response")
	@XmlElement(name = "Step")
	public void setResponseSteps(List<Step> responseSteps) {
		this.responseSteps = responseSteps;
	}
}
