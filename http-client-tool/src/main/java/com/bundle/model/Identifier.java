package com.bundle.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlType
public class Identifier {

	private String ref;

	private String type;

	public String getRef() {
		return ref;
	}

	@XmlAttribute
	public void setRef(String ref) {
		this.ref = ref;
	}

	public String getType() {
		return type;
	}

	@XmlAttribute
	public void setType(String type) {
		this.type = type;
	}

}
