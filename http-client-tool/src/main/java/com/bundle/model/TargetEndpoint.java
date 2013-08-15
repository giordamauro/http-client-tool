package com.bundle.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "TargetEndpoint")
public class TargetEndpoint {

	// TODO completar - testear

	private String name;
	private String description;

	private List<FaultRule> faultRules;

	private Flow preFlow;
	private Flow postFlow;

	private HttpTargetConnection httpTargetConnection;

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

	public List<FaultRule> getFaultRules() {
		return faultRules;
	}

	@XmlElementWrapper(name = "FaultRules")
	@XmlElement(name = "FaultRule")
	public void setFaultRules(List<FaultRule> faultRules) {
		this.faultRules = faultRules;
	}

	public Flow getPreFlow() {
		return preFlow;
	}

	@XmlElement(name = "PreFlow")
	public void setPreFlow(Flow preFlow) {
		this.preFlow = preFlow;
	}

	public Flow getPostFlow() {
		return postFlow;
	}

	@XmlElement(name = "PostFlow")
	public void setPostFlow(Flow postFlow) {
		this.postFlow = postFlow;
	}

	public HttpTargetConnection getHttpTargetConnection() {
		return httpTargetConnection;
	}

	@XmlElement(name = "HTTPTargetConnection")
	public void setHttpTargetConnection(HttpTargetConnection httpTargetConnection) {
		this.httpTargetConnection = httpTargetConnection;
	}
}
