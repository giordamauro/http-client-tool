package com.apigee.model;

import java.util.List;

public class ApiProxy {

	private String contextInfo;
	private long createdAt;
	private String createdBy;
	private String description;
	private String displayName;
	private long lastModifiedAt;
	private String lastModifiedBy;
	private String name;
	private List<String> policies;
	private List<String> proxyEndpoints;
	private List<String> resourceFiles;
	private List<String> resources;
	private int revision;
	private List<String> targetEndpoints;
	private List<String> targetServers;
	private String type;

	public String getContextInfo() {
		return contextInfo;
	}

	public void setContextInfo(String contextInfo) {
		this.contextInfo = contextInfo;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
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

	public List<String> getPolicies() {
		return policies;
	}

	public void setPolicies(List<String> policies) {
		this.policies = policies;
	}

	public List<String> getProxyEndpoints() {
		return proxyEndpoints;
	}

	public void setProxyEndpoints(List<String> proxyEndpoints) {
		this.proxyEndpoints = proxyEndpoints;
	}

	public List<String> getResourceFiles() {
		return resourceFiles;
	}

	public void setResourceFiles(List<String> resourceFiles) {
		this.resourceFiles = resourceFiles;
	}

	public List<String> getResources() {
		return resources;
	}

	public void setResources(List<String> resources) {
		this.resources = resources;
	}

	public int getRevision() {
		return revision;
	}

	public void setRevision(int revision) {
		this.revision = revision;
	}

	public List<String> getTargetEndpoints() {
		return targetEndpoints;
	}

	public void setTargetEndpoints(List<String> targetEndpoints) {
		this.targetEndpoints = targetEndpoints;
	}

	public List<String> getTargetServers() {
		return targetServers;
	}

	public void setTargetServers(List<String> targetServers) {
		this.targetServers = targetServers;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
