package com.bundle.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "Copy")
public class Add {

	private List<Property> headers;

	private List<Property> queryParams;

	private List<Property> formParams;

	public List<Property> getHeaders() {
		return headers;
	}

	@XmlElementWrapper(name = "Headers")
	@XmlElement(name = "Header")
	public void setHeaders(List<Property> headers) {
		this.headers = headers;
	}

	public List<Property> getQueryParams() {
		return queryParams;
	}

	@XmlElementWrapper(name = "QueryParams")
	@XmlElement(name = "QueryParam")
	public void setQueryParams(List<Property> queryParams) {
		this.queryParams = queryParams;
	}

	public List<Property> getFormParams() {
		return formParams;
	}

	@XmlElementWrapper(name = "FormParams")
	@XmlElement(name = "FormParam")
	public void setFormParams(List<Property> formParams) {
		this.formParams = formParams;
	}
}
