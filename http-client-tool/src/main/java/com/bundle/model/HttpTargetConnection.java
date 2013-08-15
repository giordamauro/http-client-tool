package com.bundle.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "HTTPProxyConnection")
public class HttpTargetConnection {

	private List<Property> properties;

	private SSLInfo sslInfo;

	private String url;

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

	public SSLInfo getSslInfo() {
		return sslInfo;
	}

	@XmlElement(name = "SSLInfo")
	public void setSslInfo(SSLInfo sslInfo) {
		this.sslInfo = sslInfo;
	}

}
