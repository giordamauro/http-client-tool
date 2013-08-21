package com.bundle.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
public class AssignVariable {

	private String name;

	private String value;

	private String ref;

	public String getName() {
		return name;
	}

	@XmlElement(name = "Name")
	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	@XmlElement(name = "Value")
	public void setValue(String value) {
		this.value = value;
	}

	public String getRef() {
		return ref;
	}

	@XmlElement(name = "Ref")
	public void setRef(String ref) {
		this.ref = ref;
	}
}
