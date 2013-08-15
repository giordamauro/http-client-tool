package com.bundle.model;

import javax.xml.bind.annotation.XmlElement;

public class DefaultFaultRule extends FaultRule {

	private boolean alwaysEnforce;

	public boolean isAlwaysEnforce() {
		return alwaysEnforce;
	}

	@XmlElement(name = "AlwaysEnforce")
	public void setAlwaysEnforce(boolean alwaysEnforce) {
		this.alwaysEnforce = alwaysEnforce;
	}
}
