package com.bundle.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

@XmlType(name = "AssignTo")
public class AssignTo {

	private boolean createNew;

	private String transport;

	private String type;

	private String value;

	public boolean isCreateNew() {
		return createNew;
	}

	@XmlAttribute
	public void setCreateNew(boolean createNew) {
		this.createNew = createNew;
	}

	public String getTransport() {
		return transport;
	}

	@XmlAttribute
	public void setTransport(String transport) {
		this.transport = transport;
	}

	public String getType() {
		return type;
	}

	@XmlAttribute
	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	@XmlValue
	public void setValue(String value) {
		this.value = value;
	}

}
