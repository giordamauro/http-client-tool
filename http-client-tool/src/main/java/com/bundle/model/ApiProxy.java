package com.bundle.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "APIProxy")
public class ApiProxy {

	// TODO incluir ConfigurationVersion

	private String name;
	private int revision;

	private long createdAt;
	private String description;
	private String displayName;
	private long lastModifiedAt;
	private String lastModifiedBy;

	private List<String> policies;
	private List<String> proxyEndpoints;
	private List<String> resources;
	private List<String> targetServers;
	private List<String> targetEndpoints;

	public int getRevision() {
		return revision;
	}

	@XmlAttribute
	public void setRevision(int revision) {
		this.revision = revision;
	}

	public String getName() {
		return name;
	}

	@XmlAttribute
	public void setName(String name) {
		this.name = name;
	}

	public long getCreatedAt() {
		return createdAt;
	}

	@XmlElement(name = "CreatedAt")
	public void setCreatedAt(long createdAt) {
		this.createdAt = createdAt;
	}

	public String getDescription() {
		return description;
	}

	@XmlElement(name = "Description")
	public void setDescription(String description) {
		this.description = description;
	}

	public String getDisplayName() {
		return displayName;
	}

	@XmlElement(name = "DisplayName")
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public long getLastModifiedAt() {
		return lastModifiedAt;
	}

	@XmlElement(name = "LastModifiedAt")
	public void setLastModifiedAt(long lastModifiedAt) {
		this.lastModifiedAt = lastModifiedAt;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	@XmlElement(name = "LastModifiedBy")
	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public List<String> getPolicies() {
		return policies;
	}

	@XmlElementWrapper(name = "Policies")
	@XmlElement(name = "Policy")
	public void setPolicies(List<String> policies) {
		this.policies = policies;
	}

	public List<String> getProxyEndpoints() {
		return proxyEndpoints;
	}

	@XmlElementWrapper(name = "ProxyEndpoints")
	@XmlElement(name = "ProxyEndpoint")
	public void setProxyEndpoints(List<String> proxyEndpoints) {
		this.proxyEndpoints = proxyEndpoints;
	}

	public List<String> getResources() {
		return resources;
	}

	@XmlElementWrapper(name = "Resources")
	@XmlElement(name = "Resource")
	public void setResources(List<String> resources) {
		this.resources = resources;
	}

	public List<String> getTargetServers() {
		return targetServers;
	}

	@XmlElementWrapper(name = "TargetServers")
	@XmlElement(name = "TargetServer")
	public void setTargetServers(List<String> targetServers) {
		this.targetServers = targetServers;
	}

	public List<String> getTargetEndpoints() {
		return targetEndpoints;
	}

	@XmlElementWrapper(name = "TargetEndpoints")
	@XmlElement(name = "targetEndpoints")
	public void setTargetEndpoints(List<String> targetEndpoints) {
		this.targetEndpoints = targetEndpoints;
	}

}