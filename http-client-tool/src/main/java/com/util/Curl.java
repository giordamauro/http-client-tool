package com.util;

import java.util.ArrayList;
import java.util.List;

public class Curl {

	private List<String> options = new ArrayList<String>();

	private Curl(String path) {
		options.add("curl");
		options.add("-k");
		options.add("-v");
		options.add(path);
	}

	public String send() {
		return CmdUtils.excecListOptions(options);
	}

	public Curl setUser(String username, String password) {
		this.addOptionValue("-u", username + ":" + password);
		return this;
	}

	public Curl addOption(String option) {
		options.add(option);
		// TODO -> FILTRAR SOLO OPCIONES CONOCIDAS
		return this;
	}

	public Curl addOptionValue(String option, String value) {
		options.add(option);
		options.add(value);
		return this;
	}

	private void setMethod(String method) {
		this.addOptionValue("-X", method);
	}

	public static Curl get(String path) {
		return new Curl(path);
	}

	public static Curl post(String path) {
		Curl curl = new Curl(path);
		curl.setMethod("POST");
		return curl;
	}

	public static Curl put(String path) {
		Curl curl = new Curl(path);
		curl.setMethod("PUT");
		return curl;
	}

	public static Curl delete(String path) {
		Curl curl = new Curl(path);
		curl.setMethod("DELETE");
		return curl;
	}

	public static Curl options(String path) {
		Curl curl = new Curl(path);
		curl.setMethod("OPTIONS");
		return curl;
	}
}
