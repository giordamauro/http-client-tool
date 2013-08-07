package com.apigee.model;

import java.util.List;

public class Credential {

	private List<DeveloperAppApiProduct> apiProducts;
	private List<Attribute> attributes;
	private String consumerKey;
	private String consumerSecret;
	private List<String> scopes;
	private String status;

	public List<DeveloperAppApiProduct> getApiProducts() {
		return apiProducts;
	}

	public void setApiProducts(List<DeveloperAppApiProduct> apiProducts) {
		this.apiProducts = apiProducts;
	}

	public List<Attribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<Attribute> attributes) {
		this.attributes = attributes;
	}

	public String getConsumerKey() {
		return consumerKey;
	}

	public void setConsumerKey(String consumerKey) {
		this.consumerKey = consumerKey;
	}

	public String getConsumerSecret() {
		return consumerSecret;
	}

	public void setConsumerSecret(String consumerSecret) {
		this.consumerSecret = consumerSecret;
	}

	public List<String> getScopes() {
		return scopes;
	}

	public void setScopes(List<String> scopes) {
		this.scopes = scopes;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
