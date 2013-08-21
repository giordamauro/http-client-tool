package com.bundle.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "MatchRule")
public class MatchRule {

	private String action;

	private List<SourceAddress> sourceAdrreses;

	public String getAction() {
		return action;
	}

	@XmlAttribute
	public void setAction(String action) {
		this.action = action;
	}

	public List<SourceAddress> getSourceAdrreses() {
		return sourceAdrreses;
	}

	@XmlElement(name = "SourceAddress")
	public void setSourceAdrreses(List<SourceAddress> sourceAdrreses) {
		this.sourceAdrreses = sourceAdrreses;
	}

}
