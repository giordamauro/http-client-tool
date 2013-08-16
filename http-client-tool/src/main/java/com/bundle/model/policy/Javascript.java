package com.bundle.model.policy;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.bundle.model.FaultRule;
import com.bundle.model.Property;

@XmlRootElement(name = "Javascript")
public class Javascript extends Policy {

	private int timeLimit;

	private List<FaultRule> faultRules;

	private List<Property> properties;

	private List<String> includeURL;

	private String resourceURL;

	public int getTimeLimit() {
		return timeLimit;
	}

	@XmlAttribute
	public void setTimeLimit(int timeLimit) {
		this.timeLimit = timeLimit;
	}

	public List<FaultRule> getFaultRules() {
		return faultRules;
	}

	@XmlElementWrapper(name = "FaultRules")
	@XmlElement(name = "FaultRule")
	public void setFaultRules(List<FaultRule> faultRules) {
		this.faultRules = faultRules;
	}

	public List<Property> getProperties() {
		return properties;
	}

	@XmlElementWrapper(name = "Properties")
	@XmlElement(name = "Property")
	public void setProperties(List<Property> properties) {
		this.properties = properties;
	}

	public List<String> getIncludeURL() {
		return includeURL;
	}

	@XmlElement(name = "IncludeURL")
	public void setIncludeURL(List<String> includeURL) {
		this.includeURL = includeURL;
	}

	public String getResourceURL() {
		return resourceURL;
	}

	@XmlElement(name = "ResourceURL")
	public void setResourceURL(String resourceURL) {
		this.resourceURL = resourceURL;
	}
}
