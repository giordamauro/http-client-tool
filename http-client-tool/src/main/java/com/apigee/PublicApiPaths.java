package com.apigee;

public final class PublicApiPaths {

	public static final String API_GEE_HOST = "https://api.enterprise.apigee.com";

	public static final String DEVELOPERS_PATH = "/v1/o/{organization}/developers";
	public static final String DEVELOPER_APPS_PATH = "/v1/o/{organization}/developers/{developer}/apps";
	public static final String DEVELOPER_APP_PATH = "/v1/o/{organization}/developers/{developer}/apps/{app}";

	private PublicApiPaths() {
	}
}
