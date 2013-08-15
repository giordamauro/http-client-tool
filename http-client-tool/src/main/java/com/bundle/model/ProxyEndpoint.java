package com.bundle.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ProxyEndpoint")
public class ProxyEndpoint {

	private String name;
	private String description;

	private DefaultFaultRule defaultFaultRule;
	private List<FaultRule> faultRules;

	private List<Flow> flows;

	private Flow preFlow;
	private Flow postFlow;

	private HttpProxyConnection httpProxyConnection;

	private List<RouteRule> routeRoules;

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

	public DefaultFaultRule getDefaultFaultRule() {
		return defaultFaultRule;
	}

	@XmlElement(name = "DefaultFaultRule")
	public void setDefaultFaultRule(DefaultFaultRule defaultFaultRule) {
		this.defaultFaultRule = defaultFaultRule;
	}

	public List<FaultRule> getFaultRules() {
		return faultRules;
	}

	@XmlElementWrapper(name = "FaultRules")
	@XmlElement(name = "FaultRule")
	public void setFaultRules(List<FaultRule> faultRules) {
		this.faultRules = faultRules;
	}

	public List<Flow> getFlows() {
		return flows;
	}

	@XmlElementWrapper(name = "Flows")
	@XmlElement(name = "Flow")
	public void setFlows(List<Flow> flows) {
		this.flows = flows;
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

	public HttpProxyConnection getHttpProxyConnection() {
		return httpProxyConnection;
	}

	@XmlElement(name = "HTTPProxyConnection")
	public void setHttpProxyConnection(HttpProxyConnection httpProxyConnection) {
		this.httpProxyConnection = httpProxyConnection;
	}

	public List<RouteRule> getRouteRoules() {
		return routeRoules;
	}

	@XmlElement(name = "RouteRule")
	public void setRouteRoules(List<RouteRule> routeRoules) {
		this.routeRoules = routeRoules;
	}
}
