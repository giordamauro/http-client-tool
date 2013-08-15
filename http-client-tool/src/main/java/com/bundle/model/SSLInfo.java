package com.bundle.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
public class SSLInfo {

	private boolean enabled;
	private boolean clientAuthEnabled;
	private String keyStore;
	private String keyAlias;

	public boolean isEnabled() {
		return enabled;
	}

	@XmlElement(name = "Enabled")
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isClientAuthEnabled() {
		return clientAuthEnabled;
	}

	@XmlElement(name = "ClientAuthEnabled")
	public void setClientAuthEnabled(boolean clientAuthEnabled) {
		this.clientAuthEnabled = clientAuthEnabled;
	}

	public String getKeyStore() {
		return keyStore;
	}

	@XmlElement(name = "KeyStore")
	public void setKeyStore(String keyStore) {
		this.keyStore = keyStore;
	}

	public String getKeyAlias() {
		return keyAlias;
	}

	@XmlElement(name = "KeyAlias")
	public void setKeyAlias(String keyAlias) {
		this.keyAlias = keyAlias;
	}
}
