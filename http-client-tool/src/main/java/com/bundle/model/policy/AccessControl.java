package com.bundle.model.policy;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.bundle.model.IPRules;

@XmlRootElement(name = "AccessControl")
public class AccessControl extends Policy {

	private IPRules ipRules;

	public IPRules getIpRules() {
		return ipRules;
	}

	@XmlElement(name = "IPRules")
	public void setIpRules(IPRules ipRules) {
		this.ipRules = ipRules;
	}

}
