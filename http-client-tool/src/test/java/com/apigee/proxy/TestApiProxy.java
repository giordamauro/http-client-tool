package com.apigee.proxy;

import java.util.ArrayList;
import java.util.List;

import com.apigee.ApigeeAPI;
import com.apigee.model.Credential;
import com.apigee.model.DeveloperApp;
import com.util.ApiGeeUtil;

public class TestApiProxy {

	public static void main(String[] args) {

		final String organization = "ecollege";
		final String username = "mgiorda@apigee.com";
		final String password = "1234321Nomejodas";

		ApigeeAPI publicApi = ApiGeeUtil.getPublicApi(organization, username, password);

		// String appName = getAppNameForApiKey(publicApi,
		// "cd270703036051fbcccbc16920ace339");

		List<String> appNames = getEmptyCredentialsApps(publicApi);

		System.out.println(appNames);
		System.out.println(appNames.size());
	}

	private static List<String> getEmptyCredentialsApps(ApigeeAPI publicApi) {

		List<String> emptyApps = new ArrayList<String>();

		List<String> apps = publicApi.getApps();

		for (String appName : apps) {
			DeveloperApp app = publicApi.getApp(appName);
			List<Credential> credentials = app.getCredentials();
			if (credentials.isEmpty()) {
				emptyApps.add(appName);
			}

		}
		return emptyApps;
	}

	private static List<String> getEmptyProductsApps(ApigeeAPI publicApi) {

		List<String> emptyApps = new ArrayList<String>();

		List<String> apps = publicApi.getApps();

		for (String appName : apps) {
			DeveloperApp app = publicApi.getApp(appName);
			List<Credential> credentials = app.getCredentials();
			for (Credential credential : credentials) {
				if (credential.getApiProducts().isEmpty()) {
					emptyApps.add(appName);
				}
			}
		}
		return emptyApps;
	}

}
