package com.bundle.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

@XmlType(name = "SourceAddress")
public class SourceAddress {

	private String mask;

	private String value;

	public String getMask() {
		return mask;
	}

	@XmlAttribute
	public void setMask(String mask) {
		this.mask = mask;
	}

	public String getValue() {
		return value;
	}

	@XmlValue
	public void setValue(String value) {
		this.value = value;
	}

}
