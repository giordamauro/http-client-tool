package com.bundle.model.policy;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Policy {

	private Class<? extends Policy> type;

	private String name;

	private boolean async;

	private boolean continueOnError;

	private String displayName;

	public Class<? extends Policy> getType() {
		return type;
	}

	public void setType(Class<? extends Policy> type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	@XmlAttribute
	public void setName(String name) {
		this.name = name;
	}

	public boolean isAsync() {
		return async;
	}

	@XmlAttribute
	public void setAsync(boolean async) {
		this.async = async;
	}

	public boolean isContinueOnError() {
		return continueOnError;
	}

	@XmlAttribute
	public void setContinueOnError(boolean continueOnError) {
		this.continueOnError = continueOnError;
	}

	public String getDisplayName() {
		return displayName;
	}

	@XmlElement(name = "DisplayName")
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
}
