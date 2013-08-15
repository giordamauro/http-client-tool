package com.bundle.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "HTTPProxyConnection")
public class HttpProxyConnection {

	private String basePath;

	private String url;

	private List<String> virtualHosts;

	private List<Property> properties;

	public String getBasePath() {
		return basePath;
	}

	@XmlElement(name = "BasePath")
	public void setBasePath(String basePath) {
		this.basePath = basePath;
	}

	public List<String> getVirtualHosts() {
		return virtualHosts;
	}

	@XmlElement(name = "VirtualHost")
	public void setVirtualHosts(List<String> virtualHosts) {
		this.virtualHosts = virtualHosts;
	}

	public String getUrl() {
		return url;
	}

	@XmlElement(name = "URL")
	public void setUrl(String url) {
		this.url = url;
	}

	public List<Property> getProperties() {
		return properties;
	}

	@XmlElementWrapper(name = "Properties")
	@XmlElement(name = "Property")
	public void setProperties(List<Property> properties) {
		this.properties = properties;
	}
}
