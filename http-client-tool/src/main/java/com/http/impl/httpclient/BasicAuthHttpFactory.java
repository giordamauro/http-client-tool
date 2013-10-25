package com.http.impl.httpclient;

import org.apache.commons.codec.binary.Base64;

public class BasicAuthHttpFactory extends HttpClientFactory {

	private static final String AUTHORIZATION_HEADER = "Authorization";

	public BasicAuthHttpFactory(HttpRequester httpRequester, String username, String password) {
		super(httpRequester);
		setAuthorizationHeader(username, password);
	}

	public BasicAuthHttpFactory(HttpRequester httpRequester, String host, String username, String password) {
		super(httpRequester, host);
		setAuthorizationHeader(username, password);
	}

	private void setAuthorizationHeader(String username, String password) {
		if (username == null || password == null) {
			throw new IllegalArgumentException("Username and password cannot be null");
		}

		String usernamePassword = username + ":" + password;
		byte[] inBase64 = Base64.encodeBase64(usernamePassword.getBytes());
		String basicAuth = new String(inBase64);

		super.setHeader(AUTHORIZATION_HEADER, "Basic " + basicAuth);
	}
}
