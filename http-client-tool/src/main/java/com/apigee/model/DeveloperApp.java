package com.apigee.model;

import java.util.List;

public class DeveloperApp {

	private String accessType;
	private List<DeveloperAppApiProduct> apiProducts;
	private String appFamily;
	private String appId;
	private List<Attribute> attributes;
	private String callbackUrl;
	private long createdAt;
	private String createdBy;
	private List<Credential> credentials;
	private String developerId;
	private long lastModifiedAt;
	private String lastModifiedBy;
	private String name;
	private List<String> scopes;
	private String status;

	public String getAccessType() {
		return accessType;
	}

	public void setAccessType(String accessType) {
		this.accessType = accessType;
	}

	public String getAppFamily() {
		return appFamily;
	}

	public void setAppFamily(String appFamily) {
		this.appFamily = appFamily;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public List<Attribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<Attribute> attributes) {
		this.attributes = attributes;
	}

	public String getCallbackUrl() {
		return callbackUrl;
	}

	public void setCallbackUrl(String callbackUrl) {
		this.callbackUrl = callbackUrl;
	}

	public long getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(long createdAt) {
		this.createdAt = createdAt;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public List<Credential> getCredentials() {
		return credentials;
	}

	public void setCredentials(List<Credential> credentials) {
		this.credentials = credentials;
	}

	public String getDeveloperId() {
		return developerId;
	}

	public void setDeveloperId(String developerId) {
		this.developerId = developerId;
	}

	public long getLastModifiedAt() {
		return lastModifiedAt;
	}

	public void setLastModifiedAt(long lastModifiedAt) {
		this.lastModifiedAt = lastModifiedAt;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public List<DeveloperAppApiProduct> getApiProducts() {
		return apiProducts;
	}

	public void setApiProducts(List<DeveloperAppApiProduct> apiProducts) {
		this.apiProducts = apiProducts;
	}
}
