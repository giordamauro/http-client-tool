package com.bundle.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

@XmlType
public class CopySet {

	private String source;

	private List<Property> headers;

	private List<Property> queryParams;

	private List<Property> formParams;

	private String payload;

	private String verb;

	private int statusCode;

	private String reasonPhrase;

	private String path;

	public String getSource() {
		return source;
	}

	@XmlAttribute
	public void setSource(String source) {
		this.source = source;
	}

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

	public String getPayload() {
		return payload;
	}

	@XmlElement(name = "Payload")
	public void setPayload(String payload) {
		this.payload = payload;
	}

	public String getVerb() {
		return verb;
	}

	@XmlElement(name = "Verb")
	public void setVerb(String verb) {
		this.verb = verb;
	}

	public int getStatusCode() {
		return statusCode;
	}

	@XmlElement(name = "StatusCode")
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getReasonPhrase() {
		return reasonPhrase;
	}

	@XmlElement(name = "ReasonPhrase")
	public void setReasonPhrase(String reasonPhrase) {
		this.reasonPhrase = reasonPhrase;
	}

	public String getPath() {
		return path;
	}

	@XmlElement(name = "Path")
	public void setPath(String path) {
		this.path = path;
	}

}
