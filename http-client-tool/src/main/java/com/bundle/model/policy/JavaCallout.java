package com.bundle.model.policy;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "JavaCallout")
public class JavaCallout extends Policy {

	private String resourceURL;

	private String className;

	public String getResourceURL() {
		return resourceURL;
	}

	@XmlElement(name = "ResourceURL")
	public void setResourceURL(String resourceURL) {
		this.resourceURL = resourceURL;
	}

	public String getClassName() {
		return className;
	}

	@XmlElement(name = "ClassName")
	public void setClassName(String className) {
		this.className = className;
	}

}
